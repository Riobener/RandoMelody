package com.riobener;

public class SongSpecification {
    int bpm = 170;
    double beatDuration = 60000 / bpm;
    double measureDuration = beatDuration * 4;

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public double getBeatDuration() {
        return beatDuration;
    }

    public void setBeatDuration(long beatDuration) {
        this.beatDuration = beatDuration;
    }
}
