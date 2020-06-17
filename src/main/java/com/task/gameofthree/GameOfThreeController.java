package com.task.gameofthree;

import com.task.gameofthree.dto.PlayerMsg;
import com.task.gameofthree.service.Publisher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("v1/api/gameofthree")
@Api("Game of three Rest controller.")
@RequiredArgsConstructor
public class GameOfThreeController {

    public final Publisher publisher;

    @PostMapping("/play")
    @ApiOperation("Start the game.")
    public void startGame(@RequestBody final PlayerMsg playerMsg) {
        publisher.publishMessage(playerMsg);
    }
}
