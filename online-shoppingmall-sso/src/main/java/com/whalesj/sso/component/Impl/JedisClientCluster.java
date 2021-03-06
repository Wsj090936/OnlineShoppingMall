package com.whalesj.sso.component.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.whalesj.sso.component.JedisClient;

import redis.clients.jedis.JedisCluster;

/**
 * redis集群版的实现类
 * @author wushijia
 *
 */
public class JedisClientCluster implements JedisClient {
	
	@Autowired
	JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		String res = jedisCluster.set(key, value);
		return res;
	}

	@Override
	public String get(String key) {
		String res = jedisCluster.get(key);
		return res;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Long res = jedisCluster.hset(key, item, value);
		return res;
	}

	@Override
	public String hget(String key, String item) {
		String res = jedisCluster.hget(key, item);
		return res;
	}

	@Override
	public Long incr(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.incr(key);
	}

	@Override
	public Long decr(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.decr(key);
	}

	@Override
	public Long expire(String key, int second) {
		// TODO Auto-generated method stub
		return jedisCluster.expire(key, second);
	}

	@Override
	public Long ttl(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.ttl(key);
	}

	@Override
	public Long hdel(String key, String item) {
		return jedisCluster.hdel(key, item);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

}
