package com.riobener;

public class Chord {

    private final int[] chord = new int[3];

    public int[] getMajorChord(Note note) {
        chord[0] = note.getMidiNote();
        chord[1] = note.getMidiNote() + 4;
        chord[2] = note.getMidiNote() + 7;
        return chord;
    }
    public int[] getMinorChord(Note note) {
        chord[0] = note.getMidiNote();
        chord[1] = note.getMidiNote() + 3;
        chord[2] = note.getMidiNote() + 7;
        return chord;
    }
}

