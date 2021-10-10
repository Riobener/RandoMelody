package com.riobener.tests;

import com.riobener.Chord;
import com.riobener.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChordTest {
    int[] chordCMaj;
    int[] chordFMaj;
    Note keyF;
    Note keyC;
    int[] chordCMin;
    int[] chordFMin;

    @BeforeEach
    void setUp() {
        keyC = new Note(5, "C", 1000);
        keyF = new Note(3, "F", 1000);
        chordCMaj = new int[]{60, 64, 67};
        chordFMaj = new int[]{41, 45, 48};
        chordCMin = new int[]{60, 63, 67};
        chordFMin = new int[]{41, 44, 48};
    }

    @Test
    void getChordFromNote() {
        Assertions.assertArrayEquals(chordCMaj, new Chord().getMajorChord(keyC));
        Assertions.assertArrayEquals(chordFMaj, new Chord().getMajorChord(keyF));
        Assertions.assertArrayEquals(chordCMin, new Chord().getMinorChord(keyC));
        Assertions.assertArrayEquals(chordFMin, new Chord().getMinorChord(keyF));
    }

}
