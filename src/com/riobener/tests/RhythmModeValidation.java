package com.riobener.tests;

import com.riobener.UserInputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RhythmModeValidation {
    UserInputValidation validation = new UserInputValidation();

    @Test
    public void setModeTest() {
        Assertions.assertEquals(true, validation.validateMoodAndMode("true"));
        Assertions.assertEquals(false, validation.validateMoodAndMode("false"));
        Assertions.assertEquals(null, validation.validateMoodAndMode("abc"));
    }
}
