package com.riobener;

import javax.sound.midi.MidiUnavailableException;

public class RhythmTrack extends Thread {

    @Override
    public void run() {
        SoundPlayer melody = new SoundPlayer();
        SongSpecification specification = new SongSpecification();
        try {
            melody.init(0);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        Note[] notes = new Note[]{
                new Note(4,"C"),
                new Note(4,"D#"),
                new Note(4,"F"),
                new Note(4,"G"),
                new Note(4,"A#")
        };
        SoundRandomizer soundRandomizer = new SoundRandomizer(melody,specification,notes);
        while(true){
            soundRandomizer.nextRandomChord(true);
        }
    }
}

