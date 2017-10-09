package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.entidades.Tcc;
import java.util.List;

public interface ITccDaoNeo4j {

    public void insertNode(Tcc tcc);

    public void createRelationship(Tcc tcc);

    public List<String> suggestionDataMining(Tcc tcc);

    public void sessionClose();

}
