package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.entidades.Usuario;
import java.sql.SQLException;

public interface IUsuarioDaoPostgre {

    public Usuario read(String email)
            throws SQLException, ClassNotFoundException;

    public boolean insert(Usuario u)
            throws SQLException, ClassNotFoundException;

    public boolean update(String email, Usuario u)
            throws SQLException, ClassNotFoundException;

    public boolean userExists(String email)
            throws ClassNotFoundException, SQLException;

}
