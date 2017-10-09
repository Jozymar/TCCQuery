package com.ifpb.TCCQuery.conexao;

import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import redis.clients.jedis.Jedis;

public class ConFactory {

    public static Connection getConnectionPostgre() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/TCCQuery";
        String usuario = "postgres";
        String senha = "postgres";

        return DriverManager.getConnection(url, usuario, senha);
    }

    public static Jedis getConnectionRedis() {
        return new Jedis("127.0.0.1", 6379);
    }

    public static MongoClient getConnectionMongo() {
        return new MongoClient("localhost", 27017);
    }

    public static Session getConnectionNeo4j() {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "neo4j123"));
        return driver.session();
    }

}
