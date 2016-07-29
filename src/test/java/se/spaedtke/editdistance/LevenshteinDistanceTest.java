package se.spaedtke.editdistance;

import org.junit.Test;

public class LevenshteinDistanceTest {
	@Test
	public void shouldCalculateLevenshteinDistance(){
		LevenshteinDistance ld = new LevenshteinDistance();
		System.out.println(ld.calculate("sotting", "johan"));
		System.out.println(ld.calculate("sitting", "kitten"));
		System.out.println(ld.calculate("kitten", "mitten"));
		System.out.println(ld.calculate("sat", "cat"));
	}
}