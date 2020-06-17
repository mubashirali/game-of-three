package com.task.gameofthree.service;

import com.task.gameofthree.dto.PlayerMsg;

public interface SimpleMessageListener {
    void handleMessage(PlayerMsg playerMsg);
}
