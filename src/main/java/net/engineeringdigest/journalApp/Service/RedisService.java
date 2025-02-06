package net.engineeringdigest.journalApp.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Autowired
   private RedisTemplate redisTemplate;

    public <T> T get(String key ,Class<T> weatherResponseClass) {
        try{
            Object o = redisTemplate.opsForValue().get(key);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(o.toString(),weatherResponseClass);
        }
        catch(Exception e) {
            log.error("Exception",e);
            return null;
        }
    }
    public void sett(String key ,Object o,Long ttl) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key,jsonValue,ttl, TimeUnit.SECONDS);
        }
        catch(Exception e) {
            log.error("Exception",e);
        }
    }
}
