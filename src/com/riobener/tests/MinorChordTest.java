package com.riobener.tests;

import com.riobener.MajorChord;
import com.riobener.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinorChordTest {
    int[] chordC;
    int[] chordF;
    Note keyF;
    Note keyC;

    @BeforeEach
    void setUp() {
        chordC = new int[]{60, 63, 67};
        chordF = new int[]{41, 44, 48};
        keyC = new Note(5, "C", 1000);
        keyF = new Note(3, "F", 1000);
    }

    @Test
    void getChordFromNote() {
        Assertions.assertEquals(chordC, new MajorChord().getFrom(keyC));
        Assertions.assertEquals(chordF, new MajorChord().getFrom(keyF));
    }

}
