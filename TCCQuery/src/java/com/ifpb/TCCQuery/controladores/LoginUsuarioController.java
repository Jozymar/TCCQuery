package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.UsuarioDaoPostgre;
import com.ifpb.TCCQuery.entidades.Usuario;
import com.ifpb.TCCQuery.interfaces.IAutenticavelUsuario;
import com.ifpb.TCCQuery.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUsuarioController implements ICommand, IAutenticavelUsuario {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        if (autenticarUsuario(email, senha)) {

            UsuarioDaoPostgre userDAO = new UsuarioDaoPostgre();

            Usuario u = userDAO.read(email);

            HttpSession session = req.getSession();
            session.setAttribute("nome", u.getNome());
            session.setAttribute("cidade", u.getCidade());
            session.setAttribute("nascimento", u.getNascimento());
            session.setAttribute("universidade", u.getUniversidade().toUpperCase());
            session.setAttribute("campus", u.getCampus());
            session.setAttribute("email", u.getEmail());
            session.setAttribute("senha", u.getSenha());
            session.setAttribute("sexo", u.getSexo());
            session.setAttribute("foto", u.getFoto());

            req.getRequestDispatcher("inicial.jsp").forward(req, res);

        } else {
            res.sendRedirect("erroLogin.jsp");
        }

    }

}
