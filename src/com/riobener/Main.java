package com.riobener;

import javax.sound.midi.*;

public class Main {

    public static void main(String[] args) throws MidiUnavailableException {
        new RhythmTrack().start();
        new MelodyTrack().start();
        /*try (Sequencer sequencer = MidiSystem.getSequencer()) {
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();
            ShortMessage change = new ShortMessage();
            change.setMessage(ShortMessage.PROGRAM_CHANGE,0,0,2);
            ShortMessage noteOnMsg = new ShortMessage();
            noteOnMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 30);
            ShortMessage noteOffMsg = new ShortMessage();
            noteOffMsg.setMessage(ShortMessage.NOTE_OFF, 0, 60, 100);

            track.add(new MidiEvent(change, 0));
            track.add(new MidiEvent(noteOnMsg, 0));
            track.add(new MidiEvent(noteOnMsg, 0));
            track.add(new MidiEvent(noteOnMsg, 0));
            track.add(new MidiEvent(noteOnMsg, 0));
            track.add(new MidiEvent(noteOnMsg, 0));
            track.add(new MidiEvent(noteOffMsg, 4));
            sequencer.setSequence(sequence);
            while(true){
                sequencer.start();
            }

            //Thread.sleep(20000);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }*/
    }
}
