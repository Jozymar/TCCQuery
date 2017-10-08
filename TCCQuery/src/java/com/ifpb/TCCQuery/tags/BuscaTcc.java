package com.ifpb.TCCQuery.tags;

import com.ifpb.TCCQuery.daos.TccDaoMongo;
import com.ifpb.TCCQuery.entidades.Tcc;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BuscaTcc extends SimpleTagSupport {

    private String id;

    @Override
    public void doTag() {
        TccDaoMongo tccDaoMongo = new TccDaoMongo();
        List<Tcc> tccs =  tccDaoMongo.fullTextSearch(id);
        Tcc tcc = tccs.get(0);
        getJspContext().setAttribute("tcc", tcc);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
