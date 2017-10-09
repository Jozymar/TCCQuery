package com.ifpb.TCCQuery.interfaces;

import com.ifpb.TCCQuery.entidades.Tcc;

public interface ITccDaoRedis {

    public boolean insert(Tcc tcc);

    public Tcc read();

    public boolean delete(Tcc tcc);

}
