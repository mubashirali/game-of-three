package com.task.gameofthree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PlayerMsg implements Serializable {
    private static final long serialVersionUID = -8288631412318210495L;

    private int number;
}
