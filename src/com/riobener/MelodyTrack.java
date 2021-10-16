package com.riobener;

import javax.sound.midi.MidiUnavailableException;

public class MelodyTrack extends Thread {


    @Override
    public void run() {
        SoundPlayer melody = new SoundPlayer();
        SongSpecification specification = new SongSpecification();
        try {
            melody.init(3);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        while(true){
            melody.playNote(specification.beatDuration, 50,new Note(4,"E"));
            melody.playNote(specification.beatDuration, 50,new Note(4,"C"));
            melody.playNote(specification.beatDuration, 50,new Note(4,"E"));
            melody.playNote(specification.beatDuration, 50,new Note(4,"C"));
            melody.playNote(specification.beatDuration, 50,new Note(5,"E"));
            melody.playNote(specification.beatDuration, 50,new Note(5,"C"));
            melody.playNote(specification.beatDuration, 50,new Note(5,"E"));
            melody.playNote(specification.beatDuration, 50,new Note(5,"C"));
        }

    }
}
