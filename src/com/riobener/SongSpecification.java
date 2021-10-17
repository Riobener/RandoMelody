package com.riobener;

public class SongSpecification {
    private int bpm = 140;
    private double beatDuration = 60000 / bpm;
    private double measureDuration = beatDuration * 4;

    public void setBeatDuration(double beatDuration) {
        this.beatDuration = beatDuration;
    }

    public double getMeasureDuration() {
        return measureDuration;
    }

    public void setMeasureDuration(double measureDuration) {
        this.measureDuration = measureDuration;
    }

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
