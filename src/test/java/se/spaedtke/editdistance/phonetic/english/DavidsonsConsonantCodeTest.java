package se.spaedtke.editdistance.phonetic.english;

import org.junit.Test;

import se.spaedtke.phonetic.english.DavidsonsConsonantCode;
import se.spaedtke.utils.UnicodeUtils;

public class DavidsonsConsonantCodeTest {

	@Test
	public void foo(){
		DavidsonsConsonantCode dcc = new DavidsonsConsonantCode();
		System.out.println(dcc.encode("Spaedtke"));
		System.out.println(dcc.encode("Spädtke"));
		System.out.println(dcc.encode("Spedtke"));
		System.out.println(dcc.encode("alm"));
		System.out.println(UnicodeUtils.toAscii("åäö"));
	}
}
