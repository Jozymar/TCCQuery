
package com.ifpb.TCCQuery.conexao;

import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import redis.clients.jedis.Jedis;

public class ConFactory {
 
    public static Connection getConnectionPostgre() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/TCCQuery";
        String usuario = "postgres";
        String senha = "postgres";
        
        return DriverManager.getConnection(url, usuario, senha);
    }
    
    public static Jedis getConnectionRedis(){
        return new Jedis("127.0.0.1", 6379);
    }
    
    public static MongoClient getConnectionMongo(){
        return new MongoClient("localhost", 27017);
    }
             
    
}
    

