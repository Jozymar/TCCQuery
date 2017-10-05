package com.ifpb.TCCQuery.daos;

import com.google.gson.Gson;
import com.ifpb.TCCQuery.entidades.Tcc;
import redis.clients.jedis.Jedis;

public class TccDaoRedis {
    
    public boolean insert(Tcc tcc) {
        
        Gson gson = new Gson();
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String json = gson.toJson(tcc);
        
        tcc.setId(1);
        jedis.setex("" + tcc.getId(), 30, json);
        
        return true;
    }
}
