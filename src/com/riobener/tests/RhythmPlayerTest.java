package com.riobener.tests;

import com.riobener.RhythmPlayer;
import com.riobener.exceptions.NoteNameFormatException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RhythmPlayerTest {

    @Test
    void initPlayer() {
        RhythmPlayer player = new RhythmPlayer();
        assertTrue(player.init());
    }
    @Test
    void closePlayer_withFailure() {
        RhythmPlayer player = new RhythmPlayer();
        Exception exception = assertThrows(NoteNameFormatException.class, player::close);
        String expectedMessage = "Impossible to close player when he is not opened yet";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
