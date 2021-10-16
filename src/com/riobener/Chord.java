package com.riobener;

import java.util.ArrayList;
import java.util.List;

public class Chord {

    private final List<Integer> chord= new ArrayList<>();

    public List<Integer> getMajorChord(Note note) {
        chord.add(note.getMidiNote());
        chord.add(note.getMidiNote() + 4);
        chord.add(note.getMidiNote()+ 7);
        return chord;
    }
    public List<Integer> getMinorChord(Note note) {
        chord.add(note.getMidiNote());
        chord.add(note.getMidiNote() + 3);
        chord.add(note.getMidiNote()+ 7);
        return chord;
    }
}

