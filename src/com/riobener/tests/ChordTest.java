package com.riobener.tests;

import com.riobener.Chord;
import com.riobener.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ChordTest {
    Note keyC;
    List<Integer> chordCMaj;
    List<Integer> chordCMin;

    @BeforeEach
    void setUp() {
        keyC = new Note(5, "C");
        chordCMaj = new ArrayList<>();
        chordCMaj.add(60);
        chordCMaj.add(64);
        chordCMaj.add(67);
        chordCMin = new ArrayList<>();
        chordCMin.add(60);
        chordCMin.add(63);
        chordCMin.add(67);
    }

    @Test
    void getChordFromNote() {
        Assertions.assertEquals(chordCMaj, new Chord().getMajorChord(keyC));
        Assertions.assertEquals(chordCMin, new Chord().getMinorChord(keyC));
    }

}
