
/**
 * this is a simple version of the project
 * which is about poker game
 * this program is used to characterise a poker hand
 * by taking 5 command line arguments then print a description
 */

import java.util.Arrays;
//for sorting arrays

public class Poker {
	public static void main(String[] args) {
		if (args.length > 5) {
			System.out.println("NOT UNDERTAKEN");
			System.exit(0);
		} // this program cannot handle more than 5 arguments
		
		if (args.length < 5) {
			System.out.println("Error: wrong number of arguments; "
					+ "must be a multiple of 5");
			System.exit(0);
		} // only 5 cards can form a poker hand
		
		int[] ranks = new int[5];
		// this array is for the rank of each card
		char[] suits = new char[5];
		// this array is for the suit of each card
		
		for (int i = 0; i < 5; i++) {
			if (args[i].length() != 2) {
				System.out.println("Error: invalid card name '" 
						+ args[i] + "'");
				System.exit(0);
			}
			// if an argument doesn't contain 2 characters
			// it's not a valid card
			ranks[i] = rank.toNum(args[i].toUpperCase().charAt(0));
			suits[i] = suit.toSuit(args[i].toUpperCase().charAt(1));
			if (ranks[i] == 0 || suits[i] == 'A') {
				System.out.println("Error: invalid card name '" 
						+ args[i] + "'");
				System.exit(0);
			} // output "0" and "A" represent invalid card

			// System.out.println(ranks[i] + "" + suits[i]
			// + " " + rank.toRank(ranks[i]));
			// documents above are for test during coding
		}
		
		Arrays.sort(ranks); // sorting array
		
		boolean str = rank.findStr(ranks); // if there is a straight
		boolean flu = suit.findFlu(suits); // if there is a flush
		int maxfreq = rank.findMode(ranks)[0];
		// highest frequency of a rank in ranks
		int mode = rank.findMode(ranks)[1]; 
		// mode of ranks
		int anotherpair = rank.findAnotherPair(ranks);
		// if there is another pair, what it is
		
		String maxrank = rank.toRank(ranks[4]);
		String modeforprint = rank.toRank(mode);
		String pairforprint = rank.toRank(anotherpair);
		// these three lines above are data for print

		// System.out.println(str + " " + flu);
		// System.out.println(maxfreq + " " + mode + " " + anotherpair);
		// documents above are for test during coding

		if (str && flu) {
			System.out.println("Player 1: " + maxrank 
					+ "-high straight flush");
		} else if (maxfreq >= 4) {
			System.out.println("Player 1: Four " + modeforprint + "s");
		} else if (maxfreq == 3 && anotherpair != 0) {
			System.out.println("Player 1: " + modeforprint + "s full of "
					+ pairforprint + "s");
		} else if (flu) {
			System.out.println("Player 1: " + maxrank + "-high flush");
		} else if (str) {
			System.out.println("Player 1: " + maxrank + "-high straight");
		} else if (maxfreq == 3 && anotherpair == 0) {
			System.out.println("Player 1: Three " + modeforprint + "s");
		} else if (maxfreq == 2 && anotherpair != 0) {
			System.out.println("Player 1: " + pairforprint + "s over "
					+ modeforprint + "s");
		} else if (maxfreq == 2 && anotherpair == 0) {
			System.out.println("Player 1: Pair of " + modeforprint + "s");
		} else {
			System.out.println("Player 1: " + maxrank + "-high");
		} // classifying
	}
}
