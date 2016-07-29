package se.spaedtke.editdistance;

import org.junit.Test;

public class HammeingdistanceTest {

	@Test
	public void shouldCalculateHammingDistance(){
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.calculate("sotting", "johan"));
		System.out.println(hd.calculate("sitting", "kitten"));
		System.out.println(hd.calculate("kitten", "mitten"));
		System.out.println(hd.calculate("sat", "cat"));
	}
}
