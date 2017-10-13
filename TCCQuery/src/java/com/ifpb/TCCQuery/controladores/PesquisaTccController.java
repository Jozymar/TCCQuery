package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.TccDaoMongo;
import com.ifpb.TCCQuery.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesquisaTccController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        TccDaoMongo tccDaoMongo = new TccDaoMongo();
        String query = req.getParameter("query");

        if (req.getParameter("buscaTccPorAno") != null) {
            req.setAttribute("tccs", tccDaoMongo.searchByYear(query));
            req.getRequestDispatcher("buscaTccPorAno.jsp").forward(req, res);
        } else {
            req.setAttribute("tccs", tccDaoMongo.fullTextSearch(query));
            req.getRequestDispatcher("buscaTccPorConteudo.jsp").forward(req, res);
        }
        
    }

}
