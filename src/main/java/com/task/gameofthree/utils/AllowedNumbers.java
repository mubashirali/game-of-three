package com.task.gameofthree.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AllowedNumbers {

    NUMBER_0(0),
    NUMBER_1(1),
    NUMBER_NEGATIVE_1(-1);

    private final Integer value;
}
