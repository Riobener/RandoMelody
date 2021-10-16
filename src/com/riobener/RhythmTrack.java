package com.riobener;

import javax.sound.midi.MidiUnavailableException;

public class RhythmTrack extends Thread {

    @Override
    public void run() {
        SoundPlayer rhythm = new SoundPlayer();
        SongSpecification specification = new SongSpecification();
        try {
            rhythm.init(0);
            while(true){
                rhythm.playChord(specification.measureDuration, 50, new Chord().getMajorChord(new Note(4, "C")));
                rhythm.playChord(specification.measureDuration, 50, new Chord().getMajorChord(new Note(3, "E")));
                rhythm.playChord(specification.measureDuration, 50, new Chord().getMajorChord(new Note(5, "C")));
                rhythm.playChord(specification.measureDuration, 50, new Chord().getMajorChord(new Note(4 , "E")));
            }
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
}

