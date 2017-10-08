
package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.entidades.Tcc;
import java.util.List;
import org.bson.Document;

public interface ITccDaoMongo {
    
    public boolean insert(Document d);
    public List<Tcc> fullTextSearch(String query);
    public int generatorID();
    
}
