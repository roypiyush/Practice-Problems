package com.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SurveillanceSystem {

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
			if(segmentNumber == null) {
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
		
		
		for(Entry<Integer, Integer> reportCount : requiredContainersToSegmentMap.entrySet()) {

			Map<Integer, Float> sectors = new HashMap<Integer, Float>();
			List<Integer> list = containerTosegments.get(reportCount.getKey());
			Float max = new Float(1);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < L; j++) {
					
					Integer sector = list.get(i) + j;
					Float sectorRepitition = sectors.get(sector);
					if(sectorRepitition == null) {
						sectors.put(sector, new Float(1));
					}
					else {
						Float value = sectors.get(sector);
						value = value + 1;
						if(value > max)
							max = value;
						sectors.put(sector, value);
					}
					
				}
			}
			
//			int factor = list.size() / reportCount.getValue();
			for(Entry<Integer, Float> entry : sectors.entrySet()) {
				sectors.put(entry.getKey(), entry.getValue() / list.size());
				
				if(sectorInfo.charAt(entry.getKey()) != '+')
					sectorInfo.setCharAt(entry.getKey(), sectors.get(entry.getKey()) >= 1 ? '+' : '?');
			}
			
			
		}
		

		
		return sectorInfo.toString();
	}

	public static void main(String[] args) {

		String containers = "-XXXXX---X--";
		int[] reports = {2, 1, 0, 1};
		int L = 3;

		System.out.println(new SurveillanceSystem().getContainerInfo(
				containers, reports, L));

	}

}
