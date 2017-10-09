package com.ifpb.TCCQuery.daos;

import com.ifpb.TCCQuery.conexao.ConFactory;
import com.ifpb.TCCQuery.entidades.Tcc;
import com.ifpb.TCCQuery.interfaces.ITccDaoNeo4j;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

public class TccDaoNeo4j implements ITccDaoNeo4j {

    private Session session;

    public TccDaoNeo4j() {
        session = ConFactory.getConnectionNeo4j();
    }

    @Override
    public void insertNode(Tcc tcc) {
        session.run("CREATE (:Tcc{id: $id})",
                Values.parameters("id", tcc.getId()));
        session.run("CREATE (:Area{area: $area})",
                Values.parameters("area", tcc.getArea()));
        session.run("CREATE (:Orientador{nome: $nome})",
                Values.parameters("nome", tcc.getOrientador()));
    }

    @Override
    public void createRelationship(Tcc tcc) {
        session.run("MATCH (t:Tcc{id:$id}), (a:Area{area:$area}), (o:Orientador{nome:$nome}) "
                + "CREATE (t)-[r:PERTENCE]->(a), (t)-[r1:ORIENTADO_POR]->(o)",
                Values.parameters("id", tcc.getId(), "area", tcc.getArea(),
                        "nome", tcc.getOrientador()));
    }

    @Override
    public List<String> suggestionDataMining(Tcc tcc) {
        StatementResult result = session.run("MATCH (t:Tcc),(a:Area), (tr:Tcc) "
                + "WHERE (t:Tcc{id:$id})-[:PERTENCE]->(a:Area) "
                + "AND (tr:Tcc)-[:PERTENCE]->(a:Area) "
                + "AND (tr.id <> t.id) "
                + "RETURN tr.id as ids",
                Values.parameters("id", tcc.getId()));

        List<String> tccsRelacionados = new ArrayList<>();

        while (result.hasNext()) {
            tccsRelacionados.add(result.next().get("ids").toString());
        }
        return tccsRelacionados;
    }

    @Override
    public void sessionClose() {
        session.close();
    }

}
