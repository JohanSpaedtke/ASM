package se.spaedtke.editdistance;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Error Detecting and Error Correcting Codes. Hamming, Richard. [red.] J. O.
 * Perrine. 2, USA : American Telephone and Telegraph Company, April 1950, The
 * Bell System Technical Journal, Vol. XXIX, ss. 147-160
 *
 * https://en.wikipedia.org/wiki/Hamming_distance
 */
public class HammingDistance implements EditDistance {

	/**
	 * Calculates the relative Hamming distance between two strings. This is
	 * defined as the number of substitutions needed to transform the string s1
	 * into the string s2 divided by the maximum number of substitiutions that
	 * could be needed. For strings of different length changing the
	 * "whitespace" character at the end of the shorter string into a letter in
	 * the longer is simply treated as a substitution. </br>
	 * E.g. </br>
	 * calculate("sat", "hatter") = 4/6 = 2/3 </br>
	 * first the s is substituted for a h then the three non-existent letters at
	 * the end of sat are substituted for the letters t, e and r. finally the
	 * number of substitutions are normalized by simply dividing by the maximum
	 * number of substitutions required to turn any string of length <=
	 * max(s1.length(), s2.length) into any string of length = max(s1.length(),
	 * s2.length()) which just is the number of letters in the longest of the
	 * strings.
	 * 
	 * @param s1
	 *            the first string
	 * @param s2
	 *            the second string
	 * @return the normalized Hamming distance between two strings
	 */
	@Override
	public double calculate(String s1, String s2) {
		String paddedS1 = pad(s1, s2.length());
		String paddedS2 = pad(s2, s1.length());
		return ((double) calculateAbsolute(paddedS1, paddedS2)) / ((double) Math.max(s1.length(), s2.length()));
	}

	private String pad(String string, int length) {
		if (string.length() >= length) {
			return string;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(string);
		int paddingLength = length - string.length();
		for (int i = 0; i < paddingLength; i++) {
			sb.append("\u001A");
		}
		return sb.toString();
	}

	/**
	 * Calculates the absolute Hamming distance between two strings. This is
	 * defined as the number of substitutions needed to transform the string s1
	 * into the string s2. </br>
	 * NB! This method only accepts strings of equal length
	 * 
	 * @param s1
	 *            the first string
	 * @param s2
	 *            the second string
	 * @return the Hamming distance between two strings
	 */
	@Override
	public int calculateAbsolute(String s1, String s2) {
		if (s1.length() != s2.length()) {
			throw new IllegalArgumentException("The strings >" + s1 + "< and >" + s2 + "< are of different length");
		}
		return zip(s1.chars().mapToObj(c -> (char) c), s2.chars().mapToObj(c -> (char) c),
				(c1, c2) -> c1.equals(c2) ? 0 : 1).mapToInt(i -> i).sum();
	}

	public static <A, B, C> Stream<C> zip(Stream<A> streamA, Stream<B> streamB, BiFunction<A, B, C> zipper) {
		final Iterator<A> iteratorA = streamA.iterator();
		final Iterator<B> iteratorB = streamB.iterator();
		final Iterator<C> iteratorC = new Iterator<C>() {
			@Override
			public boolean hasNext() {
				return iteratorA.hasNext() && iteratorB.hasNext();
			}

			@Override
			public C next() {
				return zipper.apply(iteratorA.next(), iteratorB.next());
			}
		};
		final boolean parallel = streamA.isParallel() && streamB.isParallel();
		return iteratorToStream(iteratorC, parallel);
	}

	public static <T> Stream<T> iteratorToStream(Iterator<T> iterator, boolean parallel) {
		final Iterable<T> iterable = () -> iterator;
		return StreamSupport.stream(iterable.spliterator(), parallel);
	}
}
