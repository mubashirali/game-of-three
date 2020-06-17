package com.task.gameofthree.service;

import com.task.gameofthree.dto.PlayerMsg;

public interface Publisher {
    void publishMessage(PlayerMsg playerMsg);
}
