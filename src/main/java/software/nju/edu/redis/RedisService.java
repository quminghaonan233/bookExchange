package software.nju.edu.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

	@Autowired
	JedisPool jedisPool;

	/**
	 * 获取单个对象
	 * 
	 * @param prefix
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真实的key
			String realKey = prefix.getPrefix() + key;
			String str = jedis.get(realKey);
			T t = stringToBean(str, clazz);
			return t;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * expice
	 * 
	 * @param prefix
	 * @param key
	 * @param exTime
	 * @return
	 */
	public Long expice(KeyPrefix prefix, String key, int exTime) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.expire(prefix.getPrefix() + key, exTime);
			return result;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 设置对象
	 * 
	 * @param prefix
	 * @param key
	 * @param value
	 * @param exTime
	 * @return
	 */
	public <T> boolean set(KeyPrefix prefix, String key, T value, int exTime) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String str = beanToString(value);
			if (str == null || str.length() <= 0)
				return false;
			// 生成真实的key
			String realKey = prefix.getPrefix() + key;
			if (exTime == 0) {
				jedis.set(realKey, str);
			} else {
				jedis.setex(realKey, exTime, str);
			}
			return true;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * delete
	 * 
	 * @param prefix
	 * @param key
	 * @return
	 */
	public Long del(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(prefix.getPrefix() + key);
			return result;
		} finally {
			returnToPool(jedis);
		}

	}

	/**
	 * is key existed?
	 * 
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> boolean exists(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真实的KEY
			String realKey = prefix.getPrefix() + key;
			return jedis.exists(realKey);
		} finally {
			// 回收资源
			returnToPool(jedis);
		}
	}

	/**
	 * increase value
	 * 
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long incr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真实的KEY
			String realKey = prefix.getPrefix() + key;
			return jedis.incr(realKey);
		} finally {
			// 回收资源
			returnToPool(jedis);
		}

	}

	/**
	 * decrease value
	 * 
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long decr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真实的KEY
			String realKey = prefix.getPrefix() + key;
			return jedis.decr(realKey);
		} finally {
			// 回收资源
			returnToPool(jedis);
		}
	}

	/**
	 * bean to string
	 * 
	 * @param value
	 * @return
	 */
	private <T> String beanToString(T value) {
		if (value == null)
			return null;
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class)
			return "" + value;
		else if (clazz == String.class)
			return (String) value;
		else if (clazz == long.class || clazz == Long.class)
			return "" + value;
		else
			return JSON.toJSONString(value); // alibaba JSON
	}

	/**
	 * string to bean
	 * 
	 * @param str
	 * @param clazz
	 * @return
	 */
	private <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null)
			return null;
		if (clazz == int.class || clazz == Integer.class)
			return (T) Integer.valueOf(str);
		else if (clazz == String.class)
			return (T) str;
		else if (clazz == long.class || clazz == Long.class)
			return (T) Long.valueOf(str);
		else
			return JSON.toJavaObject(JSON.parseObject(str), clazz); // alibaba JSON
	}

	private void returnToPool(Jedis jedis) {
		if (jedis != null)
			jedis.close();
	}

}
