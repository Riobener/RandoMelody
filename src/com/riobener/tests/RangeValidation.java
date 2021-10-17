package com.riobener.tests;

import com.riobener.UserInputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeValidation {
    UserInputValidation validation = new UserInputValidation();

    @Test
    public void beatRangeTest(){
        Assertions.assertArrayEquals(new int[]{10,20},validation.validateRandomBeatRange("10   ,   20  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("20   ,   10  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("20   ,   10  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("20 a  ,   B  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("251 , 1  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("0 , 251  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange(" 1 0  , 25 1  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange(", 10  , 251  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomBeatRange("10  , 251,  "));
    }
    @Test
    public void octaveRangeTest(){
        Assertions.assertArrayEquals(new int[]{3,7},validation.validateRandomOctaveRange("3   ,   7  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomOctaveRange("7   ,   3  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomOctaveRange("3 a  ,  7 B  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomOctaveRange("2 , 1  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomOctaveRange(", 6  , 7  "));
        Assertions.assertArrayEquals(new int[0],validation.validateRandomOctaveRange("4  , 5,  "));
    }
}
