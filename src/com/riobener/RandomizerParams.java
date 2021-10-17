package com.riobener;

public class RandomizerParams {
    private Note[] notes;
    private int[] octaveRange;
    private int[] beatRange;
    private Boolean mood; //true - major, false - minor

    public RandomizerParams(Note[] notes, int[] octaveRange, int[] beatRange, Boolean mood) {
        this.notes = notes;
        this.octaveRange = octaveRange;
        this.beatRange = beatRange;
        this.mood = mood;
    }

    public Boolean getMood() {
        return mood;
    }

    public void setMood(Boolean mood) {
        this.mood = mood;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }

    public int[] getOctaveRange() {
        return octaveRange;
    }

    public void setOctaveRange(int[] octaveRange) {
        this.octaveRange = octaveRange;
    }

    public int[] getBeatRange() {
        return beatRange;
    }

    public void setBeatRange(int[] beatRange) {
        this.beatRange = beatRange;
    }
}
