package se.spaedtke.editdistance;

/**
 * Binary codes capable of correcting deletions, insertions, and reversals.
 * Levenshtein, Vladimir I. 12, 1966, Soviet Physics Doklady, Vol. 10, ss.
 * 707-710.
 * 
 * https://en.wikipedia.org/wiki/Levenshtein_distance
 *
 */
public class LevenshteinDistance extends GeneralisedLevenshteinDistance implements EditDistance {
	private static final double SUBSTITUTION_COST = 1;
	private static final double DELETE_COST = 1;
	private static final double INSERT_COST = 1;

	public LevenshteinDistance() {
		super(SUBSTITUTION_COST, DELETE_COST, INSERT_COST);
	}

	/**
	 * Calculates the relative Levenshtein distance between two strings. This is
	 * defined as the number of substitutions, insertions or deletions needed to
	 * transform the string s1 into the string s2 divided by the maximum number
	 * of operations that could be needed which just is the number of letters in
	 * the longest of the strings.
	 * 
	 * @param s1
	 *            the first string
	 * @param s2
	 *            the second string
	 * @return the normalized hamming distance between two strings
	 */
	@Override
	public double calculate(String s1, String s2) {
		return ((double) calculateAbsolute(s1, s2)) / ((double) Math.max(s1.length(), s2.length()));
	}

	/**
	 * Calculates the absolute Levenshtein distance between two strings. This is
	 * defined as the number of substitutions, insertions or deletions needed to
	 * transform the string s1 into the string s2. </br>
	 * 
	 * @param s1
	 *            the first string
	 * @param s2
	 *            the second string
	 * @return the Levenshtein distance between two strings
	 */
	@Override
	public int calculateAbsolute(String s1, String s2) {
		return (int) super.calculate(s1, s2);
	}
}
