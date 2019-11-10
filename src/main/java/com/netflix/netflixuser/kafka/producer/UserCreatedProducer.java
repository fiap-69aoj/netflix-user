package com.netflix.netflixuser.kafka.producer;

import com.netflix.commons.kafka.dto.UserCreatedDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 14:47
 */
@Service
public class UserCreatedProducer {

    private static final Logger logger = LoggerFactory.getLogger(UserCreatedProducer.class);
    private static final String TOPIC = "user_created";

    @Autowired
    private KafkaTemplate<String, UserCreatedDto> userCreatedKafkaTemplate;

    public void sendMessage(UserCreatedDto user) {
        logger.info(String.format("POST message user_created, user: %s", user.toString()));
        this.userCreatedKafkaTemplate.send(TOPIC, user);
    }

}
