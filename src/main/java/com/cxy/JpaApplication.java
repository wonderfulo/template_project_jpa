package com.cxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.params.SetParams;

import javax.annotation.PostConstruct;

/**
 * @author 陈翔宇
 */
@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml"})
@EnableJpaRepositories(basePackages = "com.cxy.repository")
//@EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
public class JpaApplication {

    @Autowired
    private RedisTemplate redisTemplate = null;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    //自定义后初始化方法
    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    //设置redis的序列化器
    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

    @Bean
    public SetParams initSetParams(){
        return new SetParams();
    }
}
