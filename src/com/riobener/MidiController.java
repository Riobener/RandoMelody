package com.riobener;

import javax.sound.midi.*;

public class MidiController {


    /*public static void startPlaying() throws MidiUnavailableException {
        Synthesizer synth = MidiSystem.getSynthesizer();

        long startTime = System.nanoTime();
        synth.open();
        long estimatedTime = System.nanoTime() - startTime;

        MidiChannel[] midiChannels = synth.getChannels();
        Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();
        boolean successLoadingInstrument = synth.loadInstrument(instruments[0]);

        note.setNoteValue(noteValueToPlay);
        noteValueToPlay++;
        if(noteValueToPlay>12){
            noteValueToPlay=0;
        }
        midiChannels[0].noteOn(note.getMidiNoteNumber(),93);
    }*/
}
