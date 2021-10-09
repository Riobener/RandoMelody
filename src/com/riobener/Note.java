package com.riobener;

public class Note {
    private int octave;
    private String noteName;
    String[] notes = new String[] {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
    public Note(int octave, String noteName) {
        this.octave = octave;
        this.noteName = noteName;
    }

    public int getMidiNote(){
        return -1;
    }

    public String getNoteName(){
        return noteName;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public void setNoteName(String noteName) {

    }
}
