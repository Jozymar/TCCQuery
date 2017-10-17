package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.TccDaoMongo;
import com.ifpb.TCCQuery.daos.TccDaoNeo4j;
import com.ifpb.TCCQuery.daos.TccDaoRedis;
import com.ifpb.TCCQuery.daos.LeitorPdfDao;
import com.ifpb.TCCQuery.entidades.Tcc;
import com.ifpb.TCCQuery.interfaces.ICommand;
import com.ifpb.TCCQuery.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.tika.exception.TikaException;

public class CadastroTccController implements ICommand, IFileManager {

    @Override
    public final void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        TccDaoMongo tccDaoMongo = new TccDaoMongo();

        Tcc tcc = new Tcc();
        tcc.setTitulo(req.getParameter("titulo"));
        tcc.setAutor(req.getParameter("autor"));
        tcc.setOrientador(req.getParameter("orientador"));
        tcc.setPalavrasChave(req.getParameter("palavrasChave"));
        tcc.setResumo(req.getParameter("resumo"));
        tcc.setAno(req.getParameter("ano"));
        tcc.setArea(req.getParameter("area"));
        tcc.setId("" + (tccDaoMongo.generatorID() + 1));

        String pdf = uploadFile("pdfs", req, req.getPart("pdf"));
        tcc.setPath(pdf.substring(pdf.lastIndexOf("pdfs")));

        LeitorPdfDao leitorPDF = new LeitorPdfDao(pdf);

        try {
            tcc.setPdf(leitorPDF.getText());
        } catch (SAXException | TikaException | org.xml.sax.SAXException ex) {
            Logger.getLogger(CadastroTccController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TccDaoRedis tccDaoRedis = new TccDaoRedis();
        tccDaoRedis.insert(tcc);
        HttpSession session = req.getSession();
        
        if (tccDaoMongo.insert(tcc.toDocument())) {
            TccDaoNeo4j tccDaoNeo4j = new TccDaoNeo4j();
            tccDaoNeo4j.insertNode(tcc);
            tccDaoNeo4j.createRelationship(tcc);
            tccDaoNeo4j.sessionClose();

            session.removeAttribute("tcc");
            session.removeAttribute("erro");
            tccDaoRedis.delete(tcc);
            res.sendRedirect("inicial.jsp");
        } else {
            
            session.setAttribute("tcc", tccDaoRedis.read());
            session.setAttribute("erro","Erro ao cadastrar TCC, tente novamente!");
            req.getRequestDispatcher("cadastroTcc.jsp").forward(req, res);
        }

    }

}
