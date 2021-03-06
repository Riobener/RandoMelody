package com.riobener;

import java.util.concurrent.ThreadLocalRandom;

public class SoundRandomizer {
    private final SoundPlayer player;
    private SongSpecification spec;
    private RandomizerParams params;

    public SoundRandomizer(SoundPlayer player, SongSpecification spec, RandomizerParams params) {
        this.player = player;
        this.spec = spec;
        this.params = params;
    }

    public void nextRandomNote() {
        int randomNote = ThreadLocalRandom.current().nextInt(0, params.getNotes().length);
        int randomOctave = ThreadLocalRandom.current().nextInt(params.getOctaveRange()[0], params.getOctaveRange()[1]);
        int randomBeat = ThreadLocalRandom.current().nextInt(params.getBeatRange()[0], params.getBeatRange()[1]);
        player.playNote(spec.getMeasureDuration() / randomBeat, 100, new Note(randomOctave, params.getNotes()[randomNote].getNoteName()));
    }

    public void nextRandomChord() {
        boolean perMeasure;
        perMeasure = params.getBeatRange().length == 0;
        int randomNote = ThreadLocalRandom.current().nextInt(0, params.getNotes().length);
        int randomOctave = ThreadLocalRandom.current().nextInt(params.getOctaveRange()[0], params.getOctaveRange()[1]);

        if (perMeasure) {
            if(params.getMood()){
                player.playChord(spec.getMeasureDuration(), 95, new Chord().getMajorChord(new Note(randomOctave, params.getNotes()[randomNote].getNoteName())));
            }else{
                player.playChord(spec.getMeasureDuration(), 95, new Chord().getMinorChord(new Note(randomOctave, params.getNotes()[randomNote].getNoteName())));
            }
        } else {
            int randomBeat = ThreadLocalRandom.current().nextInt(params.getBeatRange()[0], params.getBeatRange()[1]);
            if(params.getMood()){
                player.playChord(spec.getMeasureDuration() / randomBeat, 95, new Chord().getMajorChord(new Note(randomOctave, params.getNotes()[randomNote].getNoteName())));
            }else{
                player.playChord(spec.getMeasureDuration() / randomBeat, 95, new Chord().getMinorChord(new Note(randomOctave, params.getNotes()[randomNote].getNoteName())));
            }

        }
    }
}
