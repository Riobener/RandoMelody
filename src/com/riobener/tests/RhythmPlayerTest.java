package com.riobener.tests;

import com.riobener.RhythmPlayer;
import com.riobener.exceptions.UnableToCloseRhythmPlayerException;
import org.junit.jupiter.api.Test;


import javax.sound.midi.MidiUnavailableException;

import static org.junit.jupiter.api.Assertions.*;

public class RhythmPlayerTest {

    @Test
    void initPlayer() throws MidiUnavailableException {
        RhythmPlayer player = new RhythmPlayer();
        assertDoesNotThrow(() -> player.init(0));
    }
    @Test
    void closePlayer_withFailure() throws MidiUnavailableException {
        String notOpenMessage = "Impossible to close player when he is not opened yet";
        RhythmPlayer player = new RhythmPlayer();
        assertThrows(NullPointerException.class, player::close);
        player.init(0);
        Exception synthOpenException = assertThrows(UnableToCloseRhythmPlayerException.class, player::close);
        assertTrue(synthOpenException.getMessage().contains(notOpenMessage));
    }

}
