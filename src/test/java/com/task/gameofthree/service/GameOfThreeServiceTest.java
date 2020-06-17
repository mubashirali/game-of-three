package com.task.gameofthree.service;

import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.service.impl.GameOfThreeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class GameOfThreeServiceTest {

    @Mock
    private Publisher publisher;

    @InjectMocks
    private GameOfThreeServiceImpl service;

    @Captor
    private ArgumentCaptor<PlayerMsg> argumentCaptor;

    @Test
    void testPlay() {
        //Given
        final PlayerMsg playerMsg = getPlayerMsg();

        //When
        service.play(playerMsg);

        //Then
        verify(publisher, times(1)).publishMessage(argumentCaptor.capture());
        final PlayerMsg msg = argumentCaptor.getValue();
        Assertions.assertEquals(19, msg.getNumber());
    }

    @Test
    void testPlayInvalidNumber() {
        //Given
        final PlayerMsg playerMsg = new PlayerMsg(0);

        //When
        service.play(playerMsg);

        //Then
        verify(publisher, times(0)).publishMessage(argumentCaptor.capture());
    }

    @Test
    void testPlayAlreadyWinner() {
        //Given
        final PlayerMsg playerMsg = new PlayerMsg(1);

        //When
        service.play(playerMsg);

        //Then
        verify(publisher, times(0)).publishMessage(argumentCaptor.capture());
    }

    private PlayerMsg getPlayerMsg() {
        return new PlayerMsg(56);
    }
}
