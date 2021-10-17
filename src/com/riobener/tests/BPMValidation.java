package com.riobener.tests;

import com.riobener.UserInputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BPMValidation {
    UserInputValidation validation = new UserInputValidation();
    String count = "70";
    String incorrectCountMin = (int) (Math.random() * 60) + "";
    String incorrectCountMax = 300 + (int) (Math.random() * ((2147483647 - 300) + 1)) + "";

    @Test
    public void setTempoCorrect() {
        Assertions.assertEquals(new UserInputValidation().validateBPM(count), count);
    }

    @Test
    public void setTempoIncorrect() {
        Assertions.assertEquals(0, validation.validateBPM(incorrectCountMin));
        Assertions.assertEquals(0, validation.validateBPM(incorrectCountMax));
    }

}
