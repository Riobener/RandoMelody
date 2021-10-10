package com.riobener;

import java.util.List;

public interface Player {
    void playSound(int channel, int duration, int volume, List<Integer> notes);
}
