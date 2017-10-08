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
        
        String query = req.getParameter("query");
        
        TccDaoMongo tccDaoMongo = new TccDaoMongo();
        
        req.setAttribute("tccs", tccDaoMongo.fullTextSearch(query));    
        req.getRequestDispatcher("buscaTcc.jsp").forward(req, res);
        
    }

}
