package ah224uq_assign4.Time;

public class String_timeMeasurement {
	/*-Xmx6144m -Xms6144m*/
	public static void main(String[] args) {
		

		// for (int i = 1; i <= 5; i++) {
		//	 System.out.println(i);
		 //shortString();
		 //longString();
		 //ShortStringBuilder(); 
		 //longStringBuilder();
		// }

		 shortString();
		 longString();
		 ShortStringBuilder(); 
		 longStringBuilder();


	}

	public static void shortString() {
		String str = "";
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str = str + "a";
		}
		long end = System.currentTimeMillis();
		int estimation = (int) (end - start);
		System.out.println("The Short String ");
		System.out.println("milliseconds: " + estimation);
		System.out.println("Concatenations: " + str.length());
		System.out.println("Length: " + str.length() + "\n");

	}

	public static void longString() {
		String str = "";
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str =str + ("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzab");
		}
		
		long end = System.currentTimeMillis();
		int estimation = (int) (end - start);
		System.out.println("The long String");
		System.out.println("milliseconds: " + estimation);
		System.out.println("Concatenations: " + (str.length() / 80));
		System.out.println("length: " + str.length() + "\n");
		

	}

	public static void ShortStringBuilder() {
		StringBuilder str = new StringBuilder();
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str.append("a");
		}
		long end = System.currentTimeMillis();
		int estimation = (int) (end - start);

		long startToString = System.currentTimeMillis();
		str.toString();
		long endToString = System.currentTimeMillis();
		int toStringEstimation = (int) (endToString - startToString);

		StringBuilder sb = new StringBuilder();
		long start_sb = System.currentTimeMillis();
		while (System.currentTimeMillis() - start_sb < 1000 - toStringEstimation) {
			sb.append("a");

		}
		long end_sb = System.currentTimeMillis();
		int newEstimation = (int) (end_sb - start_sb);

		System.out.println("The Short StringBuilder");
		System.out.println("start ToString in milliseconds: " + estimation);
		System.out.println("Concatenations : " + str.length());
		System.out.println("length: " + str.length());
		System.out.println("ToString in milliseconds: " + toStringEstimation);
		System.out.println("end ToString in milliseconds: " + (newEstimation + toStringEstimation));
		System.out.println("Concatenations: " + sb.length());
		System.out.println("Length: " + sb.length() + "\n");
	}

	public static void longStringBuilder() {
		StringBuilder str = new StringBuilder();
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1000) {
			str.append("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzab");
		}
		long end = System.currentTimeMillis();
		int estimation = (int) (end - start);

		long startToString = System.currentTimeMillis();
		str.toString();
		long endToString = System.currentTimeMillis();
		int toStringEstimation = (int) (endToString - startToString);

		StringBuilder sb = new StringBuilder();
		long start_sb = System.currentTimeMillis();
		while (System.currentTimeMillis() - start_sb < 1000 - toStringEstimation) {
			str.append("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzab");
		}
		long end_sb = System.currentTimeMillis();
		int newEstimatedTime = (int) (end_sb - start_sb);

		System.out.println("The longStringBuilder");
		System.out.println("start ToString in milliseconds: " + estimation);
		System.out.println("Concatenations: " + str.length());
		System.out.println("Total length: " + str.length());
		System.out.println("ToString in milliseconds: " + toStringEstimation);
		System.out.println("end ToString in milliseconds: " + (newEstimatedTime + toStringEstimation));
		System.out.println("Concatenations: " + (sb.length() / 80));
		System.out.println("Length: " + sb.length() + "\n");
	
	}

}
