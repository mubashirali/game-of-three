package com.task.gameofthree.service.publisher;

import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.service.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagePublisher implements Publisher {

    private final JmsTemplate jmsTemplate;

    @Value("${publisher.queue.name}")
    private String queueName;

    @Override
    public void publishMessage(PlayerMsg playerMsg) {
        log.info("Publishing message: {} to queue: {}", playerMsg, queueName);

        jmsTemplate.convertAndSend(queueName, playerMsg);
    }
}
