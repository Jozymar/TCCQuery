package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.daos.UsuarioDAO;
import com.ifpb.TCCQuery.entidades.Usuario;
import java.sql.SQLException;


public interface IAutenticavelUsuario {
    
    public default boolean autenticarUsuario(String email, String senha) 
            throws SQLException, ClassNotFoundException {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario u = userDAO.read(email);
        if(u != null)
            return u.getEmail().equals(email) && u.getSenha().equals(senha);
        else return false;
    }
}

    