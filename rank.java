
/**
 * this class is for ranks
 */

public enum rank {
	Ten(10), Jack(11), Queen(12), King(13), Ace(14);
	
	private int num;

	rank(int num) {
		this.num = num;
	} // constructor

	public char rankAbbrev() {
		return toString().charAt(0);
	} // get first character

	public int getNum() {
		return num;
	} // get number

	// following method is used to transform arguments to numbers
	public static int toNum(char num) {
		for (rank r : values()) {
			if (r.rankAbbrev() == num)
				return r.getNum();
		}
		int n = Integer.parseInt(num + "");
		if (Character.isDigit(num) && n > 1 && n < 10) {
			return n;
		}
		return 0; // "0" for invalid input
	}

	// following method is used to transform numbers to print form
	public static String toRank(int num) {
		switch (num) {
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		case 14:
			return "Ace";
		default:
			return num + "";
		}
	}

	// following method is used to determine if there is a straight
	public static boolean findStr(int[] a) {
		int count = 1;
		for (int i = 1; i < 5; i++) {
			if (a[i] - a[i - 1] == 1)
				count++;
		}
		return count == 5;
	}

	// following method is used to find the mode of ranks
	// referring to an algorithm
	// taught in <Algorithms and Complexity> lecture 14
	public static int[] findMode(int[] a) {
		int i = 0;
		int maxfreq = 0;
		int mode = a[0];
		while (i < 5) {
			int run = 1;
			while (i + run < 5 && a[i + run] == a[i]) {
				run++;
			}
			if (run > maxfreq) {
				maxfreq = run;
				mode = a[i];
			}
			i += run;
		}
		int[] result = new int[2];
		result[0] = maxfreq;
		result[1] = mode;
		return result; // result includes the frequency and mode
	}

	// following method is used to find another pair if exist
	public static int findAnotherPair(int[] a) {
		int maxfreq = rank.findMode(a)[0];
		int mode = rank.findMode(a)[1];
		if (maxfreq == 3 && mode == a[0] && a[3] == a[4])
			return a[4];
		if (maxfreq == 3 && mode == a[4] && a[0] == a[1])
			return a[0];
		if (maxfreq == 2 && mode == a[0] && a[2] == a[3])
			return a[2];
		if (maxfreq == 2 && mode == a[0] && a[3] == a[4])
			return a[4];
		if (maxfreq == 2 && mode == a[1] && a[3] == a[4])
			return a[4];
		return 0; // "0" for no other pair
	}
}
