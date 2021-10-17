package com.riobener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserInputValidation {
    public int validateBPM(String count) {
        int countInt = Integer.parseInt(count);
        if ((countInt > 60) && (countInt < 300)) {
            return countInt;
        } else {
            return 0;
        }
    }
    public String[] validateNoteList(String str){
        String[] notes = new String[] {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
        String s1 = str.replaceAll(" ","");
        long numOfNotes = str.chars().filter(ch -> ch == ',').count() + 1;
        String[] notesArray = s1.split(",");
        if(numOfNotes >= 4 && numOfNotes <=7 && !s1.startsWith(",") && !s1.contains(",,") && !s1.endsWith(",") && !str.contains(" #")){
            boolean flag = false;
            ArrayList<String> check = new ArrayList<String>();
            for (String note:notesArray){
                if(!Arrays.asList(notes).contains(note) || check.contains(note)){
                    flag =true;
                    break;
                }
                check.add(note);
            }
            if(flag) {
                notesArray = new String[0];
            }

        }else {
            notesArray = new String[0];
        }
        return notesArray;
    }
    public int[] validateRandomBeatRange(String str) {
        int[] ans = new int[0];
        if (str.matches("\\s*[0-9]{1,3}\\s*,\\s*[0-9]{1,3}\\s*")) {
            int a = Integer.parseInt(str.replaceAll(" ", "").split(",")[0]);
            int b = Integer.parseInt(str.replaceAll(" ", "").split(",")[1]);
            if (a > 0 && b < 251 && a < b) {
                ans = new int[]{a, b};
            }
        }
        return ans;
    }
    public int[] validateRandomOctaveRange(String str) {
        int[] ans = new int[0];
        if (str.matches("\\s*[3-7]{1}\\s*,\\s*[3-7]{1}\\s*")) {
            int a = Integer.parseInt(str.replaceAll(" ", "").split(",")[0]);
            int b = Integer.parseInt(str.replaceAll(" ", "").split(",")[1]);
            if (a < b) {
                ans = new int[]{a, b};
            }
        }
        return ans;
    }
    public Boolean validateMoodAndMode(String value)
    {
        if(Objects.equals(value, "true"))
        {
            return true;
        } else if (Objects.equals(value, "false")) {
            return false;
        } else {
            return null;
        }
    }

}

