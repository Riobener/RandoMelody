package com.riobener;

import com.riobener.exceptions.UnableToCloseRhythmPlayerException;
import org.junit.jupiter.api.function.Executable;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class RhythmPlayer {
    private MidiChannel[] channels = null;
    private Synthesizer synth = null;
    private int instrumentNumber = 0;
    public RhythmPlayer() {

    }

    public int getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(int instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public void init(int instrumentNumber) throws MidiUnavailableException {
        this.instrumentNumber = instrumentNumber;
        synth = MidiSystem.getSynthesizer();
        synth.open();
        channels = synth.getChannels();
        channels[0].programChange(this.instrumentNumber);
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
