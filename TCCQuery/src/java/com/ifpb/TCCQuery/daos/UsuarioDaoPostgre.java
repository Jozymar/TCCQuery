
package com.ifpb.TCCQuery.daos;

import com.ifpb.TCCQuery.conexao.ConFactory;
import com.ifpb.TCCQuery.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ifpb.TCCQuery.interfaces.IUsuarioDaoPostgre;

public class UsuarioDaoPostgre implements IUsuarioDaoPostgre{
    
    @Override
    public Usuario read(String email) 
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnectionPostgre();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?");

        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setNascimento(rs.getString("nascimento"));
            usuario.setUniversidade(rs.getString("universidade"));
            usuario.setCampus(rs.getString("campus"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setFoto(rs.getString("foto"));

            con.close();
            return usuario;
            
        } else {
            con.close();
            return null;
        }

    }

    @Override
    public boolean insert(Usuario u) 
            throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnectionPostgre();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO usuario (nome, cidade, nascimento, universidade, "
                + "campus, email, senha, sexo, foto) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)");

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCidade());
        stmt.setString(3, u.getNascimento());
        stmt.setString(4, u.getUniversidade());
        stmt.setString(5, u.getCampus());
        stmt.setString(6, u.getEmail());
        stmt.setString(7, u.getSenha());
        stmt.setString(8, u.getSexo());
        stmt.setString(9, u.getFoto());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(String email, Usuario u) 
            throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnectionPostgre();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE usuario SET (nome, cidade, nascimento, universidade, campus, "
                        + "senha, sexo, foto, email) = (?,?,?,?,?,?,?,?,?) "
                        + "WHERE email = ?");
        
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCidade());
        stmt.setString(3, u.getNascimento());
        stmt.setString(4, u.getUniversidade());
        stmt.setString(5, u.getCampus());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getSexo());
        stmt.setString(8, u.getFoto());
        stmt.setString(9, u.getEmail());
        stmt.setString(10, email);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }
    
    @Override
    public boolean userExists(String email) 
            throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnectionPostgre();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?");

        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }
    
}