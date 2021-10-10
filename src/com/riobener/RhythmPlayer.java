package com.riobener;

import com.riobener.exceptions.UnableToCloseRhythmPlayerException;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

public class RhythmPlayer implements Player{
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
        channels[1].programChange(this.instrumentNumber);
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

    public MidiChannel[] getChannels() {
        return channels;
    }

    public void setChannels(MidiChannel[] channels) {
        this.channels = channels;
    }

    @Override
    public void playSound(int channel, int duration, int volume, List<Integer> notes) {

    }
}
