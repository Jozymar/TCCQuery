package com.ifpb.TCCQuery.daos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TccDaoMongo {
    
    public boolean insert(Document d) {
    
        MongoClient cliente = new MongoClient("localhost", 27017);
        
        MongoDatabase database = cliente.getDatabase("Tcc");
        MongoCollection<Document> colecao = database
                .getCollection("Tccs");
        
        colecao.insertOne(d);
        
        cliente.close();
        return true;
    } 
}
