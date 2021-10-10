package com.riobener.tests;

import com.riobener.Chord;
import com.riobener.Note;
import com.riobener.RhythmPlayer;
import com.riobener.exceptions.UnableToCloseRhythmPlayerException;
import org.junit.jupiter.api.Test;


import javax.sound.midi.MidiUnavailableException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RhythmPlayerTest {

    @Test
    void initPlayer() {
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
    @Test
    void playSound() throws MidiUnavailableException {
        RhythmPlayer player = new RhythmPlayer();
        player.init(0);
        List<Integer>rhythm = new ArrayList<>();
        for(Integer s: new Chord().getMajorChord(new Note(4,"C",2000))){
            rhythm.add(s);
        }
        assertDoesNotThrow(() -> player.playSound(1,1000,70,rhythm));
    }

}
