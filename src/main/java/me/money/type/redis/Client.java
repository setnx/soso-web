package me.money.type.redis;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import me.money.type.object.pool.JedisPoolFactory;
import redis.clients.jedis.Jedis;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis redis = JedisPoolFactory.get();

		List<String> hvals = redis.hvals("open-crowd-user-name");
		for (String v : hvals) {
			System.out.println(v);
		}
		Set<String> hkeys = redis.hkeys("open-crowd-user-name");
		System.out.println(hkeys);

		while (true) {
			String ip = redis.get("rttask");
			System.out.println(ip);
			if (StringUtils.isNotEmpty(ip))
				break;
		}
	}

}