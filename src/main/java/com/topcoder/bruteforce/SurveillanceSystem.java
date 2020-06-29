package com.topcoder.bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SurveillanceSystem {

    public static void main(String[] args) {

        String containers = "-X-XXX-X-XXXX--XX-XX-X---XX----XX---X-XX--X-X-X-";
        int[] reports = {11, 9};
        int L = 18;

        System.out.println(new SurveillanceSystem().getContainerInfo(
                containers, reports, L));

    }

    public String getContainerInfo(String containers, int[] reports, int L) {

        StringBuffer sectorInfo = new StringBuffer();


        for (int i = 0; i < containers.length(); i++) {
            sectorInfo.insert(0, '-');
        }

        int numberOfSegments = containers.length() - L + 1;

        int[] containersInSegment = new int[numberOfSegments];
        for (int i = 0; i < containersInSegment.length; i++) {
            for (int j = 0; j < L; j++) {
                if (containers.charAt(i + j) == 'X')
                    containersInSegment[i]++;
            }
        }

        // Key is count of containers
        // Value is list of sectors where 'key' number containers are present
        Map<Integer, List<Integer>> containerTosegments = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < containersInSegment.length; i++) {

            List<Integer> segmentNumber = containerTosegments.get(containersInSegment[i]);
            if (segmentNumber == null) {
                segmentNumber = new ArrayList<Integer>();
            }
            segmentNumber.add(new Integer(i));
            containerTosegments.put(containersInSegment[i], segmentNumber);

        }

        // Key count of containers
        // Value is count of sectors required
        Map<Integer, Integer> requiredContainersToSegmentMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < reports.length; i++) {
            requiredContainersToSegmentMap.put(reports[i], requiredContainersToSegmentMap.get(reports[i]) == null ? 1 : (requiredContainersToSegmentMap.get(reports[i]) + 1));
        }

        System.out.println(containerTosegments);
        System.out.println(requiredContainersToSegmentMap);


        for (Entry<Integer, Integer> reportCount : requiredContainersToSegmentMap.entrySet()) {

            Map<Integer, Integer> sectors = new HashMap<Integer, Integer>();
            List<Integer> list = containerTosegments.get(reportCount.getKey());
            Integer max = new Integer(1);
            for (int i = 0; i < list.size(); i++) {

                for (int j = 0; j < L; j++) {

                    Integer sector = list.get(i) + j;
                    Integer sectorRepitition = sectors.get(sector);
                    if (sectorRepitition == null) {
                        sectors.put(sector, new Integer(1));
                    } else {
                        Integer value = sectors.get(sector);
                        value = value + 1;
                        if (value > max)
                            max = value;
                        sectors.put(sector, value);
                    }
                }


            }

            for (Entry<Integer, Integer> entry : sectors.entrySet()) {

                if (sectorInfo.charAt(entry.getKey()) != '+') {
                    int remaining = containerTosegments.get(reportCount.getKey()).size() - reportCount.getValue();
                    if (remaining == 0) {
                        sectorInfo.setCharAt(entry.getKey(), '+');
                    } else if (remaining > 0) {
                        sectorInfo.setCharAt(entry.getKey(), sectors.get(entry.getKey()).intValue() > remaining ? '+' : '?');
                    }

                }

            }


        }


        return sectorInfo.toString();
    }

}
