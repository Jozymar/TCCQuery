package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.UsuarioDaoPostgre;
import com.ifpb.TCCQuery.entidades.Usuario;
import com.ifpb.TCCQuery.interfaces.ICommand;
import com.ifpb.TCCQuery.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroUsuarioController implements ICommand, IFileManager {

    @Override
    public final void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        UsuarioDaoPostgre userDAO = new UsuarioDaoPostgre();
        Usuario u = new Usuario();

        if (userDAO.userExists(req.getParameter("email"))) {
            res.sendRedirect("erro.jsp");
        } else {
            u.setEmail(req.getParameter("email"));

            String data = req.getParameter("nascimento");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(data, formatter);

            if (date.isAfter(LocalDate.now())) {
                res.sendRedirect("erroData.jsp");
            } else {
                u.setNascimento(date.toString());

                String foto = uploadFile("fotoPerfil", req,
                        req.getPart("foto"), req.getParameter("email"));
                u.setFoto(foto);
            }
        }

        u.setNome(req.getParameter("nome"));
        u.setCidade(req.getParameter("cidade"));
        u.setUniversidade(req.getParameter("universidade"));
        u.setCampus(req.getParameter("campus"));
        u.setSenha(req.getParameter("senha"));
        u.setSexo(req.getParameter("sexo"));

        if (userDAO.insert(u)) {
            res.sendRedirect("index.jsp");

        } else {
            res.sendRedirect("erro.jsp");
        }

    }

}
