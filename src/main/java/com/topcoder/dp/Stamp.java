package com.topcoder.dp;

/* Problem Statement
 * 
 Little Fox Jiro has a rectangular board. On the board there is a row of N unit cells. The cells are numbered 0 through N-1 
 from the left to the right. Initially, the cells are not colored. Jiro must color each of the cells red, green, or blue.
 You are given a String desiredColor with N nodes. For each i, character i of desiredColor represents the color Jiro
 must use for cell i. If a character is one of 'R' (as red), 'G' (as green), and 'B' (as blue), it means that Jiro must use 
 that particular color. If a character is '*', Jiro may use any of the three colors for the particular cell.
 You are also given the ints stampCost and pushCost that describe the cost of the coloring process. The coloring process 
 consists of two phases. In the first phase, Jiro must pick a single stamp he will then use to color all the cells. The 
 length L of the stamp can be any integer between 1 and N, inclusive. A stamp of length L costs L*stampCost.
 
 In the second phase, Jiro must repeatedly use the stamp to color the cells. Each use of the stamp works as follows:
 1) Jiro picks one of the three colors and pushes the stamp into ink of the chosen color C.
 2) Jiro picks a segment of L contiguous cells such that each of them is either uncolored or already has the color C. 
 The segment must be completely inside the board. That is, the leftmost cell of the segment must be one of the cells 0 through N-L.
 3) Jiro pushes the stamp onto the chosen segment of cells. All the cells now have color C.
 Each use of the stamp costs pushCost.
 
 Return the smallest possible total cost of coloring all the        cells using the above process.
 
 Constraints
-	desiredColor will contain between 1 and 50 nodes, inclusive.
-	Each character of desiredColor will be either 'R' or 'G' or 'B' or '*'.
-	stampCost will be between 1 and 100,000, inclusive.
-	pushCost will be between 1 and 100,000, inclusive.
 
 
 */

/*
 * Firstly, Need to find longest length stamp, l
 * Secondly, Need to find color change count along desirecColor, colorChange
 * result = l * stampCost + colorChange * pushCost
 *
 *
 */

public class Stamp {


    public static void main(String[] args) {
        String desiredColor = "RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG";

        int stampCost = 1;
        int pushCost = 100000;

        Stamp stamp = new Stamp();
        System.out.println(stamp.getMinimumCost(desiredColor, stampCost, pushCost));
    }

    private boolean validateLength(String desiredColor, int start, int end, int stampingLength) {

        if (start < desiredColor.length() && end < desiredColor.length() && start + stampingLength <= end + 1)
            return true;

        return false;
    }

    private boolean validateColor(String desiredColor, int start, int end, int stampingLength) {

        // Performing validation if it is of same color
        char a = '\0';
        for (int i = start; i <= end; i++) {
            if (desiredColor.charAt(i) == '*')
                continue;

            if (a == '\0')
                a = desiredColor.charAt(i);
            else if (desiredColor.charAt(i) != a)
                return false;
        }

        return true;
    }

    /**
     * @param desiredColor
     * @param start          => 0 based
     * @param end            => 1 based
     * @param stampingLength
     * @return pushCount
     */
    int calculatePushCount(String desiredColor, int start, int end, int stampingLength) {
        return (end - start + 1) / stampingLength + ((end - start + 1) % stampingLength > 0 ? 1 : 0);
    }

    /**
     * Find stamping count for a given <em>stampingLength</em>
     *
     * @param desiredColor
     * @param start          = index based
     * @param end            = index based
     * @param stampingLength
     * @param result
     * @return
     */
    int findMinimumPushCount(String desiredColor, int start, int end, int stampingLength, int[][] result) {

        if (start > end)
            return 0;
        else if (start >= desiredColor.length() || end >= desiredColor.length()) {
            return 0;
        }

        if (result[start][end] > 0)
            return result[start][end];

        int min = desiredColor.length();

        for (int i = start; i <= end; i++) {

            boolean isValid = validateLength(desiredColor, start, i, stampingLength) & validateColor(desiredColor, start, i, stampingLength);

            if (isValid) {

                // Break and calculate
                int pc = calculatePushCount(desiredColor, start, i, stampingLength);

                // This will calculate from next index position
                int fmpc = findMinimumPushCount(desiredColor, i + 1, end, stampingLength, result);

                if (pc + fmpc < min) {
                    result[start][end] = pc + fmpc;
                    min = pc + fmpc;
                }

            }
        }

        return min;
    }

    int getMinimumCost(String desiredColor, int stampCost, int pushCost) {

        int cost = 1 * stampCost + desiredColor.length() * pushCost;
        for (int i = 1; i <= desiredColor.length(); i++) {

            int[][] result = new int[desiredColor.length()][desiredColor.length()];
            for (int k = 0; k < result.length; k++) {
                for (int j = 0; j < result.length; j++) {
                    result[k][j] = -1;
                }
            }

            int pushCount = findMinimumPushCount(desiredColor, 0, desiredColor.length() - 1, i, result);

            cost = Math.min(cost, i * stampCost + pushCount * pushCost);
        }

        return cost;
    }

}