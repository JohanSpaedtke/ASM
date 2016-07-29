package se.spaedtke.editdistance.phonetic.english;

import org.junit.Assert;
import org.junit.Test;

import se.spaedtke.phonetic.english.Soundex;

public class SoundexTest {

	@Test
	public void foo() {
		Soundex s = new Soundex();
		System.out.println(s.encode("Gutierrez"));
		System.out.println(s.encode("Pfister"));
		System.out.println(s.encode("Jackson"));
		System.out.println(s.encode("Tymczak"));
		System.out.println(s.encode("Ashcraft"));
		Assert.assertEquals("G-362", s.encode("Gutierrez"));
		Assert.assertEquals("P-236", s.encode("Pfister"));
		Assert.assertEquals("J-250", s.encode("Jackson"));
		Assert.assertEquals("T-522", s.encode("Tymczak"));
		Assert.assertEquals("A-261", s.encode("Ashcraft"));
	}
}
