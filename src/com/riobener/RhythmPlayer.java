package com.riobener;

import com.riobener.exceptions.UnableToCloseRhythmPlayerException;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class RhythmPlayer {
    private MidiChannel[] channels = null;
    private Synthesizer synth = null;

    public RhythmPlayer() {

    }

    public boolean init() throws MidiUnavailableException {
        synth = MidiSystem.getSynthesizer();
        return true;
    }

    public void close() throws UnableToCloseRhythmPlayerException {
        if (synth.isOpen()) {
            synth.close();
        } else if (synth == null) {
            throw new NullPointerException("Synth must be initialized");
        } else {
            throw new UnableToCloseRhythmPlayerException("Impossible to close player when he is not opened yet");
        }
    }

}
