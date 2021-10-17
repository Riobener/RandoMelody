package com.riobener;

public class RandomizerParams {
    private Note[] notes;
    private int[] octaveRange;
    private int[] beatRange;

    public RandomizerParams(Note[] notes, int[] octaveRange, int[] beatRange) {
        this.notes = notes;
        this.octaveRange = octaveRange;
        this.beatRange = beatRange;
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
