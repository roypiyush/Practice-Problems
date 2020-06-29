package com.topcoder.bruteforce;

public class ParallelSpeedup {

    public static long getCombination(long processors) {

        return processors * (processors - 1) / 2;

    }

    public static long totalOverhead(long processors, long task, long overhead) {
        long totalOverhead = (long) Math.ceil((double) task / (double) processors) + overhead * getCombination(processors);

        return totalOverhead;
    }

    public static long numProcessors(long k, long overhead) {

        long minTime = Long.MAX_VALUE;
        long minProc = Long.MAX_VALUE;

        for (long processors = 1; processors <= k; processors++) {
            long time = totalOverhead(processors, k, overhead);

            if (minTime > time) {
                minTime = time;
                minProc = processors;
            }
        }

        return minProc;
    }

    public static void main(String[] args) {

        long k = 1000000;
        long overhead = 4;

        long minTime = Long.MAX_VALUE;
        long minProc = Long.MAX_VALUE;

        for (long processors = 1; processors <= k; processors++) {
            long time = totalOverhead(processors, k, overhead);

            if (minTime > time) {
                minTime = time;
                minProc = processors;
            }
        }

        System.out.println("minProc: " + minProc + " minTime: " + minTime);

    }

}
