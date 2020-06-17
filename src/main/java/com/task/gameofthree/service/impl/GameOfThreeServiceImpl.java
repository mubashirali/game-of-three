package com.task.gameofthree.service.impl;

import com.task.gameofthree.service.GameOfThreeService;
import com.task.gameofthree.service.Publisher;
import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.utils.AllowedNumbers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameOfThreeServiceImpl implements GameOfThreeService {

    public static final Integer DIVISOR = 3;
    private final Publisher publisher;

    @Override
    public void play(PlayerMsg playerMsg) {
        if (playerMsg.getNumber() <= 1) {
            log.error("Invalid Number: {}", playerMsg.getNumber());
            return;
        }

        int newNumber =
                Arrays.stream(AllowedNumbers.values())
                        .filter(item -> numberIsDivisible(playerMsg.getNumber(), item.getValue()))
                        .findFirst().map(item -> getNewNumber(playerMsg.getNumber(), item.getValue()))
                        .orElse(0);

        if (newNumber == 1) {
            log.info("Winner, winner, chicken dinner!!!");
        } else {
            publisher.publishMessage(new PlayerMsg(newNumber));
        }
    }

    private boolean numberIsDivisible(int number, int item) {
        return (number + item) % DIVISOR == 0;
    }

    private int getNewNumber(int number, Integer value) {
        return (number + value) / DIVISOR;
    }
}
