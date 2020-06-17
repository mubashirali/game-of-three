package com.task.gameofthree.service.listener;

import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.service.GameOfThreeService;
import com.task.gameofthree.service.SimpleMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener implements SimpleMessageListener {
    public final GameOfThreeService gameOfThreeService;

    @Override
    @JmsListener(destination = "${listener.queue.name}")
    public void handleMessage(PlayerMsg playerMsg) {
        log.info("Received message: {}", playerMsg);

        gameOfThreeService.play(playerMsg);
    }
}
