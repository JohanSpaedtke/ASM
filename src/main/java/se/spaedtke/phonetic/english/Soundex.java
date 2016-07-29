package se.spaedtke.phonetic.english;

import java.util.HashMap;
import java.util.Map;

import se.spaedtke.utils.StringUtils;
import se.spaedtke.utils.UnicodeUtils;

/**
 * http://www.archives.gov/publications/general-info-leaflets/55-census.html
 * 
 * @author johan
 *
 */
public class Soundex {

	private final static Map<Character, Character> mapping = new HashMap<>();
	static {
		mapping.put('b', '1');
		mapping.put('f', '1');
		mapping.put('p', '1');
		mapping.put('v', '1');

		mapping.put('c', '2');
		mapping.put('g', '2');
		mapping.put('j', '2');
		mapping.put('k', '2');
		mapping.put('q', '2');
		mapping.put('s', '2');
		mapping.put('x', '2');
		mapping.put('z', '2');

		mapping.put('d', '3');
		mapping.put('t', '3');

		mapping.put('l', '4');

		mapping.put('m', '5');
		mapping.put('n', '5');

		mapping.put('r', '6');

		mapping.put('a', 'V');
		mapping.put('e', 'V');
		mapping.put('i', 'V');
		mapping.put('o', 'V');
		mapping.put('u', 'V');
		mapping.put('y', 'V');
		
		mapping.put('h', 'S');
		mapping.put('w', 'S');
	}

	public String encode(String string) {
		return string.substring(0, 1).concat("-")
				.concat(
						StringUtils.makeOfLength(3, '0',						
							StringUtils.removeAll("V|S",
									removeSpecialDuplicates(
											StringUtils.removeFirst(1, 
													StringUtils.removeDuplicates(
															turnIntoNumbers(
																	UnicodeUtils.toAscii(string.toLowerCase())
																	)
															)
													)
											)
									)
							)
						);
	}


	private String removeSpecialDuplicates(String string) {
		StringBuilder sb = new StringBuilder();
		sb.append(string.substring(0,2));
		for(int i = 2; i < string.length(); i++){
			if(!(string.charAt(i-1) == 'S' && string.charAt(i-2) == string.charAt(i))){
				sb.append(string.charAt(i));
			}
		}
		return sb.toString();
	}

	private String turnIntoNumbers(String string) {
		StringBuilder sb = new StringBuilder();
		for (char c : string.toCharArray()) {
			sb.append(mapping.get(c));
		}
		return sb.toString();
	}
}
