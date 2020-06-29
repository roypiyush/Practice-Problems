package com.topcoder.bruteforce;

public class PaperFold {

    public static void rotate(float[] paper) {
        float t = paper[0];
        paper[0] = paper[1];
        paper[1] = t;
    }

    public static int numFolds(float[] paper, float[] box) {
        int folds = 0;

        while (folds < 9) {

            float wwdiff = paper[0] - box[0];
            float wldiff = paper[0] - box[1];
            float lwdiff = paper[1] - box[0];
            float lldiff = paper[1] - box[1];

            if ((wwdiff <= 0 && lldiff <= 0) || (wldiff <= 0 && lwdiff <= 0)) {
                break;
            } else if ((wwdiff > 0 && lldiff <= 0)) {

                paper[0] = paper[0] / 2;
                folds++;
            } else if ((wwdiff <= 0 && lldiff > 0)) {
                paper[1] = paper[1] / 2;
                folds++;
            } else {
                rotate(paper);
                if ((paper[0] > paper[1])) {
                    paper[0] = paper[0] / 2;
                    folds++;
                } else {
                    paper[1] = paper[1] / 2;
                    folds++;
                }
            }

        }

        return folds > 8 ? -1 : folds;
    }

    public static void main(String[] args) {

        float[] paper = {1895, 6416};
        float[] box = {401, 1000};

        int count = numFolds(paper, box);
        System.out.println(count);

    }

}
