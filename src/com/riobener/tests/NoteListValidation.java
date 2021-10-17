package com.riobener.tests;

import com.riobener.UserInputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteListValidation {
    UserInputValidation validation = new UserInputValidation();

    @Test
    public void test() {
        Assertions.assertArrayEquals(new String[]{"A", "B", "C", "D", "F"}, validation.validateNoteList(("A,B,C,D,F")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList((",A,B,C,D,F,")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList((",A,B,C,D,F")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList(("A,B,C,D,F #")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList(("A,B,C,D,F,")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList(("A,B,C,D,F#,A#,H")));
        Assertions.assertArrayEquals(new String[0], validation.validateNoteList(("AA,B,C,D,F#,A#")));
        Assertions.assertArrayEquals(new String[]{"A", "B", "C", "D", "F#", "A#"}, validation.validateNoteList(("A,B,C,D,F#,A#")));
        Assertions.assertArrayEquals(new String[]{"A", "B", "C", "D", "F#", "A#"}, validation.validateNoteList(("    A  ,  B,C,  D,F#  ,A#  ")));
        Assertions.assertArrayEquals(new String[]{"A", "B", "C", "D", "F#", "A#"}, validation.validateNoteList(("A,B,C,D,F#,A#")));
    }
}
