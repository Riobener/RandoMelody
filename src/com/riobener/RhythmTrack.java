package com.riobener;

import javax.sound.midi.MidiUnavailableException;

public class RhythmTrack implements Runnable {
    private RandomizerParams randomizerParams;
    private SongSpecification songSpecification;

    public RhythmTrack(SongSpecification songSpecification, RandomizerParams randomizerParams) {
        this.songSpecification = songSpecification;
        this.randomizerParams = randomizerParams;
    }
    @Override
    public void run() {
        SoundPlayer melody = new SoundPlayer();
        SongSpecification specification = new SongSpecification();
        try {
            melody.init(0);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        SoundRandomizer soundRandomizer = new SoundRandomizer(melody,songSpecification, randomizerParams);
        while(true){
            soundRandomizer.nextRandomChord(true);
        }
    }
}

