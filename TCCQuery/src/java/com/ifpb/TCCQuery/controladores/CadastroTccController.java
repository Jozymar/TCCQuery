package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.TccDaoMongo;
import com.ifpb.TCCQuery.daos.TccDaoRedis;
import com.ifpb.TCCQuery.entidades.LeitorPdf;
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
        tcc.setAno(Integer.parseInt(req.getParameter("ano")));
        tcc.setArea(req.getParameter("area"));

        String pdf = uploadFile("pdfs", req, req.getPart("pdf"));
        LeitorPdf leitorPDF = new LeitorPdf(pdf);

        try {
            tcc.setPdf(leitorPDF.getText());
        } catch (SAXException | TikaException | org.xml.sax.SAXException ex) {
            Logger.getLogger(CadastroTccController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TccDaoRedis tccDaoRedis = new TccDaoRedis();
//        Gson gson = new Gson();
//        String json = gson.toJson(tcc);
//        Tcc tccRedis = gson.fromJson(json, Tcc.class);
        
        tccDaoRedis.insert(tcc);
        
        tccDaoMongo.insert(tcc.toDocument());
        res.sendRedirect("inicial.jsp");

    }

}
