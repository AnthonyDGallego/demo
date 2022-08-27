package com.mutant.demo.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantUtils {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String ADN_NOT_CORRECT = "Incorrect DNA sequence.";
    public static final String ADN_WRONG_SIZE = "Wrong DNA size(NxN non-square shape).";
    public static final String ADN_NOT_MUTANT = "Human ADN.";
    public static final Integer MAX_SQUARE_SIZE = 15;
    public static final String ADN_MAX_SIZE_EXCEEDED = "Maximum size exceeded, Max= ".concat(MAX_SQUARE_SIZE.toString().
            concat("x".concat(MAX_SQUARE_SIZE.toString())));

}
