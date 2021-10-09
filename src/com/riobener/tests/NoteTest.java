package com.riobener.tests;

import com.riobener.Note;
import com.riobener.exceptions.NoteNameFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NoteTest {
    Note note;
    @BeforeEach
    void setUp() {
        note = new Note(5,"C");
    }

    @Test
    void getMidiNote() throws NoteNameFormatException {
        Assertions.assertEquals(60,note.getMidiNote());
        note.setNoteName("A");
        Assertions.assertEquals(69,note.getMidiNote());
        note.setOctave(4);
        Assertions.assertEquals(57,note.getMidiNote());
    }

    @Test()
    void setNoteName_withWrongValue() {
        Exception exception = assertThrows(NoteNameFormatException.class, () -> note.setNoteName("C$"));
        String expectedMessage = "Wrong note name format exception!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}