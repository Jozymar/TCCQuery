
package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeslogaSistemaController implements ICommand{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        HttpSession session = req.getSession();
        session.invalidate();
        
        res.sendRedirect("index.jsp");
    }
    
}
