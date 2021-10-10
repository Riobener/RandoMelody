package com.riobener;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public class RhythmPlayer {
    private MidiChannel[] channels = null;
    private Synthesizer synth = null;

    public RhythmPlayer() {
    }
    public boolean init(){
        return true;
    }
    public boolean close() {
        return true;
    }

}
