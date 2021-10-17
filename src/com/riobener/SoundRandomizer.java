package com.riobener;

import java.util.concurrent.ThreadLocalRandom;

public class SoundRandomizer {
    private final SoundPlayer player;
    private final SongSpecification spec;
    private final Note[] notes;

    public SoundRandomizer(SoundPlayer player, SongSpecification spec, Note[] notes) {
        this.player = player;
        this.spec = spec;
        this.notes = notes;
    }

    public void nextRandomNote() {
        int randomNote = ThreadLocalRandom.current().nextInt(0, notes.length);
        int randomOctave = ThreadLocalRandom.current().nextInt(4, 7);
        int randomBeat = ThreadLocalRandom.current().nextInt(3, 4);
        player.playNote(spec.getMeasureDuration()/randomBeat, 100, new Note(randomOctave, notes[randomNote].getNoteName()));
    }
    public void nextRandomChord(boolean perMeasure) {
        if(perMeasure){
            int randomNote = ThreadLocalRandom.current().nextInt(0, notes.length);
            player.playChord(spec.getMeasureDuration(), 90, new Chord().getMinorChord(notes[randomNote]));
        }else{
            int randomNote = ThreadLocalRandom.current().nextInt(0, notes.length);
            int randomBeat = ThreadLocalRandom.current().nextInt(1, 4);
            player.playChord(spec.getMeasureDuration()/randomBeat, 90, new Chord().getMajorChord(notes[randomNote]));
        }
    }
}
