package com.ifpb.TCCQuery.controladores;

import com.ifpb.TCCQuery.daos.UsuarioDaoPostgre;
import com.ifpb.TCCQuery.entidades.Usuario;
import com.ifpb.TCCQuery.interfaces.ICommand;
import com.ifpb.TCCQuery.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtualizaUsuarioController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String emailLogado = (String) session.getAttribute("email");
        String fotoLogada = (String) session.getAttribute("foto");

        String data = req.getParameter("nascimento");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(data, formatter);

        if (date.isAfter(LocalDate.now())) {
            res.sendRedirect("erroDataUp.jsp");
        } else {

            String sep = File.separator;
            String pathFolder = req.getServletContext().getRealPath("fotoPerfil");
            removeFile(pathFolder + fotoLogada.substring(fotoLogada.lastIndexOf(sep)));
            
            //Monta caminho da pasta de upload da imagem
            String foto = uploadFile("fotoPerfil", req,
                    req.getPart("foto"), req.getParameter("email"));

            Usuario u = new Usuario();
            u.setNascimento(req.getParameter("nascimento"));
            u.setFoto(foto);
            u.setNome(req.getParameter("nome"));
            u.setEmail(req.getParameter("email"));
            u.setCidade(req.getParameter("cidade"));
            u.setUniversidade(req.getParameter("universidade"));
            u.setCampus(req.getParameter("campus"));
            u.setSenha(req.getParameter("senha"));
            u.setSexo(req.getParameter("sexo"));

            UsuarioDaoPostgre userDAO = new UsuarioDaoPostgre();
            if (userDAO.update(emailLogado, u)) {
                session.setAttribute("email", u.getEmail());
                session.setAttribute("senha", u.getSenha());
                session.setAttribute("nome", u.getNome());
                session.setAttribute("foto", u.getFoto());
                session.setAttribute("cidade", u.getCidade());
                session.setAttribute("universidade", u.getUniversidade());
                session.setAttribute("campus", u.getCampus());
                session.setAttribute("sexo", u.getSexo());
                session.setAttribute("nascimento", u.getNascimento());
                
                req.getRequestDispatcher("inicial.jsp").forward(req, res);
            } else {
                res.sendRedirect("erro.jsp");
            }
        }

    }

}
