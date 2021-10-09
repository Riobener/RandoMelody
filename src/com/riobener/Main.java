package com.riobener;

import javax.sound.midi.*;

public class Main {

    public static void main(String[] args) throws MidiUnavailableException {
        int noteNumber = 60;
        noteNumber -= 21; // see the explanation below.
        String[] notes = new String[] {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
        int octave = noteNumber / 12 + 1;
        String name = notes[noteNumber % 12];
        System.out.println(name + octave);
    }
    public static void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.setTempoInBPM(34);
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1); //fired on "tick 1"
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16); //fired on "tick 8"
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
