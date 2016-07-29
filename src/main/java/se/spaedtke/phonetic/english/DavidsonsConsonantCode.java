package se.spaedtke.phonetic.english;

import se.spaedtke.utils.StringUtils;
import se.spaedtke.utils.UnicodeUtils;

/**
 * https://books.google.se/books?id=vg_QRDVR7hgC&pg=PA137&lpg=PA137&dq=Davidson%
 * 27s+Consonant+Code&source=bl&ots=5K63p9b7SB&sig=9PadkeKQWu4yI2PSD2aTxZfCZTY&
 * hl=en&sa=X&ved=0ahUKEwixo7HujJfOAhWmYZoKHXVRCH4Q6AEIJDAC#v=onepage&q=Davidson
 * 's%20Consonant%20Code&f=false
 * 
 * @author johan
 *
 */
public class DavidsonsConsonantCode {

	public String encode(String surname) {
		return StringUtils.makeOfLength(4, 
				StringUtils.removeDuplicates(
						StringUtils.removeAll("(?<!^)[aeiouhwy]", 
								UnicodeUtils.toAscii(surname.toLowerCase())
								)
						)
				);
	}
}
