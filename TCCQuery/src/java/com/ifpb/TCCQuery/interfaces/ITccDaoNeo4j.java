package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.entidades.Tcc;
import java.util.List;

public interface ITccDaoNeo4j {

    public void insertNode(Tcc tcc);

    public void createRelationship(Tcc tcc);

    public List<String> suggestionDataMining(Tcc tcc);

    public void sessionClose();

    public boolean nodeTccExists(String id);

    public boolean nodeAreaExists(String area);

    public boolean nodeOrientadorExists(String nome);

}
