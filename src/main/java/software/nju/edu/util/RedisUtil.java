package software.nju.edu.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	public static void main(String[] args) {
		// 连接到本地的redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 查看redis服务是否运行
		System.out.println("服务正在运行" + jedis.ping());
	}

}
