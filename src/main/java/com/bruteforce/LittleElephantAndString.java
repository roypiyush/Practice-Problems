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
		
		int last = target.length() - 1;
	    
	    for (int end = source.length() - 1; end >= 0; end--)
	      if (source.charAt(end) == target.charAt(last))
	        last--;
	 
	    return last+1;
		
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
