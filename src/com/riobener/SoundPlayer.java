package com.riobener;

import com.riobener.exceptions.UnableToCloseRhythmPlayerException;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SoundPlayer {
    private MidiChannel[] channels = null;
    private Synthesizer synth = null;
    private int instrumentNumber = 0;
    private int channel;

    public SoundPlayer() {

    }

    public Synthesizer getSynth() {
        return synth;
    }

    public void setSynth(Synthesizer synth) {
        this.synth = synth;
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
        channels[0].programChange(instrumentNumber);
    }

    public void close() throws UnableToCloseRhythmPlayerException {
        if (synth == null) {
            throw new NullPointerException("Synth must be initialized");
        } else if (!synth.isOpen()) {
            throw new UnableToCloseRhythmPlayerException("Impossible to close player when he is not opened yet");
        }else{
            synth.close();
        }
    }

    public MidiChannel[] getChannels() {
        return channels;
    }

    public void setChannels(MidiChannel[] channels) {
        this.channels = channels;
    }

    public void playChord(double duration, int volume, List<Integer> notes) {
        for (int note : notes) {
            channels[channel].noteOn(note, volume);
        }
        try {
            Thread.sleep((long) duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int note : notes) {
            channels[channel].noteOff(note);
        }
    }

    public void playNote(double duration, int volume, Note note) {
        channels[channel].noteOn(note.getMidiNote(), volume);
        try {
            Thread.sleep((long) duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        channels[channel].noteOff(note.getMidiNote());

    }
}
