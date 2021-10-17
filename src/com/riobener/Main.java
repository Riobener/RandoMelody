package com.riobener;

import javax.sound.midi.*;

public class Main {

    public static void main(String[] args) throws MidiUnavailableException {
        new RhythmTrack().start();
        new MelodyTrack().start();
    }
}
