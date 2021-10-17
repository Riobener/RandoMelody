package com.riobener;

import javax.sound.midi.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MidiUnavailableException {
        Scanner scan = new Scanner(System.in);
        SongSpecification specification = new SongSpecification();
        RandomizerParams melodyRandomizer;
        RandomizerParams rhythmRandomizer;
        UserInputValidation validate = new UserInputValidation();
        System.out.println("Choose the bpm of the song (from 60 to 300):");
        String bpm;
        bpm = scan.nextLine();
        while (validate.validateBPM(bpm) == 0) {
            System.out.println("That is not valid input. Please enter again");
            bpm = scan.nextLine();
        }
        specification.setBpm(validate.validateBPM(bpm));

        System.out.println("Choose the mood of song (true-major, false-minor):");
        String mood = scan.nextLine();
        while (validate.validateMoodAndMode(mood) == null) {
            System.out.println("That is not valid input. Please enter again");
            mood = scan.nextLine();
        }

        System.out.println("Write the list of notes (from 4 to 7, with no repeat):");
        String notes = scan.nextLine();
        while (validate.validateNoteList(notes).length == 0) {
            System.out.println("That is not valid input. Please enter again");
            notes = scan.nextLine();
        }
        Note[] noteArray = new Note[validate.validateNoteList(notes).length];
        for (int i = 0; i < noteArray.length; i++) {
            noteArray[i] = new Note(3, validate.validateNoteList(notes)[i]);
        }

        System.out.println("MelodyTrack: choose the octave interval (3, 7):");
        String melodyOctave = scan.nextLine();//OCTAVE RANGE
        while (validate.validateRandomOctaveRange(melodyOctave).length == 0) {
            System.out.println("That is not valid input. Please enter again");
            melodyOctave = scan.nextLine();
        }
        System.out.println("MelodyTrack: choose beat interval (1, 250). Recommended (1,4):");
        String melodyBeat = scan.nextLine();
        while (validate.validateRandomBeatRange(melodyBeat).length == 0) {
            System.out.println("That is not valid input. Please enter again");
            melodyBeat = scan.nextLine();
        }

        System.out.println("Do you want to change rhythm mode params? (true or false)");
        String rhythmMode = scan.nextLine();
        while (validate.validateMoodAndMode(rhythmMode) == null) {
            System.out.println("That is not valid input. Please enter again");
            rhythmMode = scan.nextLine();
        }

        if (validate.validateMoodAndMode(rhythmMode)) {
            System.out.println("RhythmTrack: choose the octave interval (3, 7):");
            String rhythmOctave = scan.nextLine();//OCTAVE RANGE
            while (validate.validateRandomOctaveRange(rhythmOctave).length == 0) {
                System.out.println("That is not valid input. Please enter again");
                rhythmOctave = scan.nextLine();
            }
            System.out.println("RhythmTrack: choose beat interval (1, 250). Recommended (1,4):");
            String rhythmBeat = scan.nextLine();
            while (validate.validateRandomBeatRange(rhythmBeat).length == 0) {
                System.out.println("That is not valid input. Please enter again");
                rhythmBeat = scan.nextLine();
            }
            rhythmRandomizer = new RandomizerParams(noteArray,
                    validate.validateRandomOctaveRange(rhythmOctave),
                    validate.validateRandomBeatRange(rhythmBeat),
                    validate.validateMoodAndMode(mood));
            melodyRandomizer = new RandomizerParams(noteArray,
                    validate.validateRandomOctaveRange(melodyOctave),
                    validate.validateRandomBeatRange(melodyBeat),
                    validate.validateMoodAndMode(mood));
        } else {
            System.out.println("RhythmTrack: choose the octave interval (3, 7):");
            String rhythmOctave = scan.nextLine();//OCTAVE RANGE
            while (validate.validateRandomOctaveRange(rhythmOctave).length == 0) {
                System.out.println("That is not valid input. Please enter again");
                rhythmOctave = scan.nextLine();
            }
            rhythmRandomizer = new RandomizerParams(noteArray,
                    validate.validateRandomOctaveRange(rhythmOctave),
                    validate.validateRandomBeatRange(""),
                    validate.validateMoodAndMode(mood));
            melodyRandomizer = new RandomizerParams(noteArray,
                    validate.validateRandomOctaveRange(melodyOctave),
                    validate.validateRandomBeatRange(melodyBeat),
                    validate.validateMoodAndMode(mood));
        }
        Runnable melody = new MelodyTrack(specification, melodyRandomizer);
        Runnable rhythm = new RhythmTrack(specification, rhythmRandomizer);

        try {
            System.out.println("Music will start playing in:");
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Music successfully started!\n");
        System.out.println("For closing program, write smth to console\n");
        Thread mel = new Thread(melody);
        Thread rh = new Thread(rhythm);
        mel.start();
        rh.start();
        while (true) {
            String line = scan.next();
            System.exit(0);
        }
    }
}
