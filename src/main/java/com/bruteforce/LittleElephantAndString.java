package com.bruteforce;

public class LittleElephantAndString {

	private boolean isTransformable(String source, String target) {

		if (source.length() != target.length())
			return false;

		int s1 = 0;
		int s2 = 0;

		for (int i = 0; i < source.length(); i++) {
			s1 = (int) source.charAt(i) + s1;
			s2 = (int) target.charAt(i) + s2;
		}

		return s1 == s2;
	}

	private int transform(String source, String target) {
		
		int count = target.length() - 1;
		
		StringBuffer stringBuffer = new StringBuffer(source);
		StringBuffer matched = new StringBuffer();

		for (int i = source.length() - 1; i >= 0; i--) {
			if(stringBuffer.charAt(i) == target.charAt(count)) {
				matched.append(stringBuffer.charAt(i));
				count--;
			}
		}
		
		System.out.println(matched.reverse());
		
		return count + 1;
		
	}
	

	public static void main(String[] args) {

		LittleElephantAndString les = new LittleElephantAndString();

		String source = "IUTGZPQALYMYNSMKPPMNUVEKNPLXHSECDWEROVASCGFMZKJGIP";
		String target = "PZSQMETOGEPSPXNVJIUPALYYNMKMNUVKLHSECDWRACGFMZKGIP";
	
		if (!les.isTransformable(source, target)) {
			System.out.println("-1");
			return;
		}

		int count = les.transform(source, target);
		System.out.println(count);

	}

}
