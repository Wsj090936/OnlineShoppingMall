package com.whalesj.sso.component.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.whalesj.sso.component.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * redis客户端单机版实现
 * @author wushijia
 *
 */
public class JedisClientSingle implements JedisClient {
	@Autowired
	private JedisPool jedisPool;//由Spring注入

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String res = jedis.set(key, value);
		jedis.close();
		return res;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String res = jedis.get(key);
		jedis.close();
		return res;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.hset(key, item, value);
		jedis.close();
		return res;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String res = jedis.hget(key, item);
		jedis.close();
		return res;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.incr(key);
		jedis.close();
		return res;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.decr(key);
		jedis.close();
		return res;
	}

	@Override
	public Long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.expire(key, second);
		jedis.close();
		return res;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.ttl(key);
		jedis.close();
		return res;
	}

	@Override
	public Long hdel(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.hdel(key, item);
		jedis.close();
		return res;
	}
	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long res = jedis.decr(key);
		jedis.close();
		return res;
	}

}
