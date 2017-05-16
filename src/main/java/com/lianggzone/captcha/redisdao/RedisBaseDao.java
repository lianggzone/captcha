package com.lianggzone.captcha.redisdao;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * <h3>概要:</h3><p>RedisBaseDao</p>
 * <h3>功能:</h3><p>RedisBaseDao</p>
 * <h3>履历:</h3>
 * <li>2017年5月16日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@Repository
public class RedisBaseDao {

    @Resource(name="redisTemplate")
    protected ValueOperations<String, String> valueOperations;
    
    @Resource(name = "redisTemplate")
    protected RedisTemplate<String, String> redisTemplate;
    
    public void addValue(String key, String value){
        valueOperations.set(key, value);
    }
 
    public String getValue(String key){
        return valueOperations.get(key);
    }
    
    /** 
     * 设置超时      
     * @param key
     * @param timeout
     * @param unit
     * @author lianggz
     */
    public void expire(String key, final long timeout, final TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }
}