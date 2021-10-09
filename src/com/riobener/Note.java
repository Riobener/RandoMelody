package com.riobener;

import com.riobener.exceptions.NoteNameFormatException;

public class Note {
    private int octave;
    private String noteName;
    String[] notes = new String[] {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
    public Note(int octave, String noteName) {
        this.octave = octave;
        this.noteName = noteName;
    }

    public int getMidiNote(){
        /*
        int noteIndex = 0;
        for(int i = 0; i<notes.length;i++){
            if(noteName.equals(notes[i])){
                noteIndex = i;
                break;
            }
        }
        noteNumber = (octave-1)/12*(noteIndex+1);*/
        int noteIndex = 0;
        for(int i = 0; i<notes.length;i++){
            if(noteName.equals(notes[i])){
                noteIndex = i;
                break;
            }
        }
        int noteNumber = 0;
        for (int noteNum = 0; noteNum < 128; noteNum++) {
            if((noteNum/12-1)==octave){
                noteNumber = noteNum+noteIndex;
            }
        }
        return noteNumber - 23;
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

    public void setNoteName(String noteName) throws NoteNameFormatException {
        boolean isSuccessful = false;
        for(String note: notes){
            if (note.equals(noteName)) {
                this.noteName = noteName;
                isSuccessful=true;
                break;
            }
        }
        if(!isSuccessful)
        throw new NoteNameFormatException("Wrong note name format exception!");
    }
}
