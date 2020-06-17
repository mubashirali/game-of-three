package com.task.gameofthree;

import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.service.impl.GameOfThreeServiceImpl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class GameOfThreeControllerTest {

    @LocalServerPort
    private Integer localeServicePort;

    @Value("http://localhost/v1/api/gameofthree")
    private String baseUrl;

    @MockBean
    private GameOfThreeServiceImpl service;

    @Captor
    private ArgumentCaptor<PlayerMsg> msgArgumentCaptor;

    @BeforeEach
    void setup() {
        RestAssured.port = localeServicePort;
        RestAssured.baseURI = baseUrl;
    }

    @Test
    void startGame() throws InterruptedException {
        String url = format("%s/play", baseUrl);
        PlayerMsg playerMsg = new PlayerMsg(56);

        given().body(playerMsg).contentType(ContentType.JSON).when().post(url)
                .prettyPeek().then().statusCode(OK.value());

        Thread.sleep(500);

        verify(service, times(1)).play(msgArgumentCaptor.capture());
        assertEquals(playerMsg.getNumber(), msgArgumentCaptor.getValue().getNumber());
    }
}
