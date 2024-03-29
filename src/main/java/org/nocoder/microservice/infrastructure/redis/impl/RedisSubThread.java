package org.nocoder.microservice.infrastructure.redis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * redis订阅消息线程
 */
public class RedisSubThread extends Thread {
    Logger LOG = LoggerFactory.getLogger(RedisSubThread.class);
    private final JedisPool jedisPool;
    private final JedisPubSub jedisPubSub;
    private final String channel;

    public RedisSubThread(JedisPool jedisPool, JedisPubSub jedisPubSub, String channel) {
        this.jedisPool = jedisPool;
        this.jedisPubSub = jedisPubSub;
        this.channel = channel;
    }

    @Override
    public void run() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(jedisPubSub, channel);
        } catch (Exception e) {
            LOG.error("subsrcibe channel {} error {}", channel, e.getStackTrace());
        } finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
    }
}
