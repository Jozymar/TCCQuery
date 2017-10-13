package com.ifpb.TCCQuery.daos;

import com.ifpb.TCCQuery.conexao.ConFactory;
import com.ifpb.TCCQuery.entidades.Tcc;
import com.ifpb.TCCQuery.interfaces.ITccDaoMongo;
import com.mongodb.MongoTimeoutException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class TccDaoMongo implements ITccDaoMongo {

    private MongoDatabase database;
    private MongoCollection<Document> colecao;

    public TccDaoMongo() {
        database = ConFactory.getConnectionMongo().getDatabase("Tcc");
        colecao = database.getCollection("Tccs");
    }

    @Override
    public boolean insert(Document d) {
        try {
            colecao.insertOne(d);
            ConFactory.getConnectionMongo().close();
            return true;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return false;
        }

    }

    @Override
    public List<Tcc> fullTextSearch(String query) {
        try {
            MongoCursor<Document> cursor = null;
            cursor = colecao.find(new Document("$text", new Document("$search", query))).
                    projection(Projections.metaTextScore("score")).
                    sort(Sorts.metaTextScore("score")).iterator();
            List<Tcc> tccs = new ArrayList<>();

            while (cursor.hasNext()) {
                Document searchTCC = cursor.next();
                tccs.add(new Tcc().fromDocument(searchTCC));
            }

            cursor.close();
            ConFactory.getConnectionMongo().close();
            return tccs;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return null;
        }

    }

    @Override
    public List<Tcc> searchByYear(String ano) {
        try {
            MongoCursor<Document> cursor = null;
            cursor = colecao.find(new Document("ano", ano)).
                    projection(Projections.metaTextScore("score")).
                    sort(Sorts.metaTextScore("score")).iterator();
            List<Tcc> tccs = new ArrayList<>();

            while (cursor.hasNext()) {
                Document searchTCC = cursor.next();
                tccs.add(new Tcc().fromDocument(searchTCC));
            }

            cursor.close();
            ConFactory.getConnectionMongo().close();
            return tccs;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return null;
        }

    }

    @Override
    public int generatorID() {
        try {
            int qnt = (int) colecao.count();

            ConFactory.getConnectionMongo().close();

            return qnt;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return 0;
        }
    }

}
