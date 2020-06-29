package com.topcoder.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ICPCBalloons {


    public static void main(String[] args) {

        Integer[] balloonCount = {62, 15, 56, 65, 10, 10, 61, 23};
        String balloonSize = "LLLLLLLL";
        Integer[] maxAccepted = {21, 1, 17, 7, 20, 8, 7, 19, 11, 21, 13, 12, 17, 15, 27};

        System.out.println(new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));

    }

    int solve(Integer bc[], Integer ma[], int totalBalloons, int totalWinners) {

        // find sum of remaining winners to keep track if at the end condition is satisfied
        if (totalWinners == 0)
            for (int i = 0; i < ma.length; i++) {
                totalWinners += ma[i];
            }

        if (totalBalloons == 0)
            for (int i = 0; i < bc.length; i++) {
                totalBalloons += bc[i];
            }

        if (totalBalloons < totalWinners)
            return -1;


        for (int j = 0; j < Math.min(bc.length, ma.length); j++) {
            int min = Math.min(bc[j], ma[j]);
            totalWinners -= min;
            ma[j] -= min;
            totalBalloons -= min;
            bc[j] -= min;

        }

        if (totalBalloons >= totalWinners)
            return totalWinners;
        else
            return -1;
    }

    private int minRepaintings(Integer[] balloonCount, String balloonSize, Integer[] maxAccepted) {

        Collections.sort(Arrays.asList(maxAccepted), Collections.reverseOrder());

        ArrayList<Integer> mb = new ArrayList<Integer>();
        ArrayList<Integer> lb = new ArrayList<Integer>();

        int mCount = 0, lCount = 0;
        for (int i = 0; i < balloonCount.length; i++) {
            if (balloonSize.charAt(i) == 'M') {
                mCount += balloonCount[i];
                mb.add(balloonCount[i]);
            } else {
                lCount += balloonCount[i];
                lb.add(balloonCount[i]);
            }
        }

        Collections.sort(mb, Collections.reverseOrder());
        Collections.sort(lb, Collections.reverseOrder());

        ArrayList<Integer> mma = new ArrayList<Integer>();
        ArrayList<Integer> lma = new ArrayList<Integer>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << maxAccepted.length; i++) {
            String binary = "";
            if ((maxAccepted.length - Integer.toBinaryString(i).length()) > 0) {
                binary = String.format("%0" + (maxAccepted.length - Integer.toBinaryString(i).length()) + "d%s", 0, Integer.toBinaryString(i));
            } else {
                binary = String.format("%s", Integer.toBinaryString(i));
            }

            int mmaCount = 0;
            int lmaCount = 0;
            mma.clear();
            lma.clear();

            /*
             * Dividing the balloons in two arrays with different sizes
             */
            for (int j = 0; j < binary.length(); j++) {

                if (binary.charAt(j) == '1') {
                    mma.add(maxAccepted[j]);
                    mmaCount += maxAccepted[j];
                } else {
                    lma.add(maxAccepted[j]);
                    lmaCount += maxAccepted[j];
                }
            }

            /*
             * Solve each separate size arrays
             */
            if (mb.size() > 0 && lb.size() > 0) {

                int ans1 = -1, ans2 = -1;
                if (mCount >= mmaCount && lCount >= lmaCount && mmaCount > 0 && lmaCount > 0) {
                    ans1 = solve(mb.toArray(new Integer[mb.size()]), mma.toArray(new Integer[mma.size()]), mCount, mmaCount);
                    ans2 = solve(lb.toArray(new Integer[lb.size()]), lma.toArray(new Integer[lma.size()]), lCount, lmaCount);
                }

                if ((ans1 != -1 && ans2 != -1)) {
                    min = Math.min(ans1 + ans2, min);
                }

            } else if (mCount > 0) {
                return solve(mb.toArray(new Integer[mb.size()]), maxAccepted, mCount, mmaCount);
            } else if (lCount > 0) {
                return solve(lb.toArray(new Integer[lb.size()]), maxAccepted, lCount, lmaCount);
            }


        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
