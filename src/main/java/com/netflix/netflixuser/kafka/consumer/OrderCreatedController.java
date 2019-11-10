package com.netflix.netflixuser.kafka.consumer;

import com.netflix.commons.kafka.dto.OrderCreatedDto;
import com.netflix.netflixuser.entity.UserEntity;
import com.netflix.netflixuser.entity.enums.UserStatus;
import com.netflix.netflixuser.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 18:56
 */
@Service
public class OrderCreatedController {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedController.class);

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "order_created", groupId = "group_id", containerFactory = "orderCreatedKafkaListenerContainerFactory")
    public void consume(OrderCreatedDto message) throws IOException {
        logger.info(String.format("Consuming order_created, user: %s", message.toString()));
        final Optional<UserEntity> user = userService.findById(message.getClientId());
        if(user.isPresent()) {
            logger.info(String.format("Updating user status, userId %d", message.getClientId()));
            final UserEntity userEntity = user.get();
            userEntity.setStatus(UserStatus.ACTIVE);
            userService.save(userEntity);
        }
    }

}
