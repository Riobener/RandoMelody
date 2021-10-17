package com.riobener;

import javax.sound.midi.MidiUnavailableException;

public class MelodyTrack implements Runnable {
    private RandomizerParams randomizerParams;
    private SongSpecification songSpecification;

    public MelodyTrack(SongSpecification songSpecification, RandomizerParams randomizerParams) {
        this.songSpecification = songSpecification;
        this.randomizerParams = randomizerParams;
    }
    @Override
    public void run() {
        SoundPlayer melody = new SoundPlayer();
        try {
            melody.init(randomizerParams.getInstrument());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        SoundRandomizer soundRandomizer = new SoundRandomizer(melody,songSpecification,randomizerParams);
        while(true){
            soundRandomizer.nextRandomNote();
        }

    }
}
