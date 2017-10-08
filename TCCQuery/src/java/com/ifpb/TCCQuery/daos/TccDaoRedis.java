package com.ifpb.TCCQuery.daos;

import com.google.gson.Gson;
import com.ifpb.TCCQuery.conexao.ConFactory;
import com.ifpb.TCCQuery.entidades.Tcc;
import com.ifpb.TCCQuery.interfaces.ITccDaoRedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class TccDaoRedis implements ITccDaoRedis {

    @Override
    public boolean insert(Tcc tcc) {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
        String json = gson.toJson(tcc);

        try {
            return jedis.set("1", json).equals("OK");
        } catch (JedisConnectionException j) {
            return false;
        }
        
    }
    
    @Override
    public Tcc read() {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
 
        try {
            Tcc t = gson.fromJson(jedis.get("1"), Tcc.class);
            return t;
        } catch (JedisConnectionException j) {
            return null;
        }
        
    }
    
    @Override
    public boolean delete(Tcc tcc) {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
        String json = gson.toJson(tcc);

        try {
            jedis.del("1");
            return true;
        } catch (JedisConnectionException j) {
            return false;
        }
        
    }

}
