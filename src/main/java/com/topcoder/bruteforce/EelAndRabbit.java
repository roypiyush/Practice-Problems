package com.topcoder.bruteforce;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


class SortWithStart implements Comparator<Eel> {
    public int compare(Eel e1, Eel e2) {
        return e1.getStart() - e2.getStart();
    }
}

class SortWithEnd implements Comparator<Eel> {
    public int compare(Eel e1, Eel e2) {
        return e1.getEnd() - e2.getEnd();
    }
}

class Eel {

    private int start;
    private int end;

    public Eel(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        Eel eel = null;
        if (o == null || !(o instanceof Eel)) {
            return false;
        }
        eel = (Eel) o;
        if (this.start == eel.getStart() && this.end == eel.getEnd())
            return true;
        else
            return false;

    }

    @Override
    public String toString() {
        return "Eel [start=" + start + ", end=" + end + "]";
    }

}

public class EelAndRabbit {

    public static void main(String[] args) {

//		int[] l = {925860128, 352368525, 44902106, 860136733, 471569488, 139173200, 376482278, 463384991, 546870708, 625674455, 556427037, 591760935, 468854534, 455004214, 523333786, 230141605, 52231465, 103657267, 15081092, 502651897, 420460974, 937293703, 135014018, 693974683, 1000000000, 867250346, 641790292, 655972113, 932141290, 360889250, 518975058, 725606408, 316842192, 818357724, 708072309, 966080205, 776030859, 434747924, 688443645, 88292749, 107668054, 809869761, 408399458, 207422940, 745058701, 802273571, 358594999, 786743954, 822666157, 478381787};
//		int[] t = {925860128, 352368525, 44902106, 860136733, 471569488, 139173200, 376482278, 463384991, 546870708, 625674455, 556427037, 591760935, 468854534, 455004214, 523333786, 230141605, 52231465, 103657267, 15081092, 502651897, 420460974, 937293703, 135014018, 693974683, 1000000000, 867250346, 641790292, 655972113, 932141290, 360889250, 518975058, 725606408, 316842192, 818357724, 708072309, 966080205, 776030859, 434747924, 688443645, 88292749, 107668054, 809869761, 408399458, 207422940, 745058701, 802273571, 358594999, 786743954, 822666157, 478381787};
        int[] l = {50, 38, 3, 43, 7, 7, 81, 22, 93, 59, 51, 39, 84, 29, 17, 15, 32, 84, 8, 46, 92, 86, 6, 6, 90, 22, 40, 15, 28, 79};
        int[] t = {64, 63, 42, 74, 44, 77, 73, 52, 22, 41, 38, 39, 18, 23, 90, 40, 38, 25, 27, 84, 48, 49, 25, 46, 39, 30, 54, 35, 18, 26};
        System.out.println(new EelAndRabbit().getmax(l, t));

    }

    public int getmax(int[] l, int[] t) {

        int count = 0;

        Set<Integer> setofPoints = new HashSet<Integer>();
        for (int i = 0; i < t.length; i++) {

            setofPoints.add(t[i]);
            setofPoints.add(t[i] + l[i]);
        }

        // Count on first run
        for (Integer integer1 : setofPoints) {
            for (Integer integer2 : setofPoints) {
                int res = 0;
                for (int i = 0; i < t.length; i++) {
                    if (integer1 >= t[i] && t[i] + l[i] >= integer1) {
                        res++;
                    } else if (integer2 >= t[i] && t[i] + l[i] >= integer2) {
                        res++;
                    }
                }
                count = Math.max(count, res);
            }
        }

        return count;
    }

}
 