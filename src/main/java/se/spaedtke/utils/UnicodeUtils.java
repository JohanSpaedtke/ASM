package se.spaedtke.utils;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Range;

public class UnicodeUtils {

	public static final Range<Character> ASCII = Range.closed('\u0000', '\u007F');
	
	private static final Map<Character, String> unicodeToAscii;

	static {
		unicodeToAscii= new HashMap<>();
		unicodeToAscii.put('\u00A0', " "); //No-Break Space
		unicodeToAscii.put('\u00A1', "!"); //Inverted Exclamation Mark
		unicodeToAscii.put('\u00A2', "c"); //Cent Sign
		unicodeToAscii.put('\u00A3', "L"); //Pound Sign
		unicodeToAscii.put('\u00A4', "o"); //Currency Sign
		unicodeToAscii.put('\u00A5', "Y"); //Yen Sign
		unicodeToAscii.put('\u00A6', "|"); //Broken Bar
		unicodeToAscii.put('\u00A7', "S"); //Section Sign
		unicodeToAscii.put('\u00A9', "C"); //Currency Sign
		unicodeToAscii.put('\u00AA', "a"); //Feminine Ordinal Indicator
		unicodeToAscii.put('\u00AC', "-"); //Not Sign
		unicodeToAscii.put('\u00AE', "R"); //Registered Sign
		unicodeToAscii.put('\u00AF', "-"); //Macron
		unicodeToAscii.put('\u00B0', "o"); //Degree Sign
		unicodeToAscii.put('\u00B1', "+-"); //Plus-Minus Sign
		unicodeToAscii.put('\u00B2', "2"); //Superscript Two
		unicodeToAscii.put('\u00B3', "3"); //Superscript Three
		unicodeToAscii.put('\u00B5', "u"); //Micro Sign
		unicodeToAscii.put('\u00B6', "P"); //Pilcrow Sign
		unicodeToAscii.put('\u00B7', "."); //Middle Dot
		unicodeToAscii.put('\u00B9', "1"); //Superscript One
		unicodeToAscii.put('\u00BA', "o"); //Masculine Ordinal Indicator
		unicodeToAscii.put('\u00BC', "1/4"); //Vulgar Fraction One Quarter
		unicodeToAscii.put('\u00BD', "1/2"); //Vulgar Fraction One Half
		unicodeToAscii.put('\u00BE', "3/4"); //Vulgar Fraction Three Quarters
		unicodeToAscii.put('\u00BF', "?"); //Inverted Question Mark
		unicodeToAscii.put('\u00C6', "AE"); //Latin Capital Letter Ae
		unicodeToAscii.put('\u00D0', "D"); //Latin Capital Letter Eth
		unicodeToAscii.put('\u00D7', "x"); //Multiplication Sign
		unicodeToAscii.put('\u00D8', "O"); //Latin Capital Letter O with Stroke
		unicodeToAscii.put('\u00DE', "Y"); //Latin Capital Letter Thorn
		unicodeToAscii.put('\u00DF', "ss"); //Latin Small Letter Sharp S
		unicodeToAscii.put('\u00E6', "ae"); //Latin Small Letter Ae
		unicodeToAscii.put('\u00F0', "d"); //Latin Small Letter Eth
		unicodeToAscii.put('\u00F7', "/"); //Division Sign
		unicodeToAscii.put('\u00F8', "o"); //Latin Small Letter O with Stroke
		unicodeToAscii.put('\u00FE', "y"); //Latin Small Letter Thorn
		unicodeToAscii.put('\u0110', "D"); //Latin Capital Letter D with Stroke
		unicodeToAscii.put('\u0111', "d"); //Latin Small Letter D with Stroke
		unicodeToAscii.put('\u0126', "H"); //Latin Capital Letter H with Stroke
		unicodeToAscii.put('\u0127', "h"); //Latin Small Letter h with Stroke
		unicodeToAscii.put('\u0131', "i"); //Latin Small Letter Dotless I
		unicodeToAscii.put('\u0132', "IJ"); //Latin Capital Ligature Ij
		unicodeToAscii.put('\u0133', "ij"); //Latin Small Ligature Ij
		unicodeToAscii.put('\u0138', "k"); //Latin Small Letter Kra
		unicodeToAscii.put('\u013F', "L"); //Latin Capital Letter L with Middle Dot
		unicodeToAscii.put('\u0140', "l"); //Latin Small Letter L with Middle Dot
		unicodeToAscii.put('\u0141', "L"); //Latin Capital Letter L with Stroke
		unicodeToAscii.put('\u0142', "l"); //Latin Small Letter L with Stroke
		unicodeToAscii.put('\u0149', "n"); //Latin Small Letter N Preceded By Apostrophe
		unicodeToAscii.put('\u014B', "n"); //Latin Small Letter Eng
		unicodeToAscii.put('\u014A', "N"); //Latin Capital Letter Eng
		unicodeToAscii.put('\u0152', "OE"); //Latin Capital Ligature Oe
		unicodeToAscii.put('\u0153', "oe"); //Latin Small Ligature Oe
		unicodeToAscii.put('\u0166', "T"); //Latin Capital Letter T with Stroke
		unicodeToAscii.put('\u0167', "t"); //Latin Small Letter T with Stroke
		unicodeToAscii.put('\u017F', "s"); //Latin Small Letter Long S
		unicodeToAscii.put('\u0180', "b"); //Latin Small Letter B with Stroke
		unicodeToAscii.put('\u0181', "B"); //Latin Capital Letter B with Hook
		unicodeToAscii.put('\u0182', "b"); //Latin Capital Letter B with Topbar
		unicodeToAscii.put('\u0183', "b"); //Latin Small Letter B with Topbar
		unicodeToAscii.put('\u0184', "B"); //Latin Capital Letter Tone Six
		unicodeToAscii.put('\u0185', "b"); //Latin Small Letter Tone Six
		unicodeToAscii.put('\u0186', "O"); //Latin Capital Letter Open O
		unicodeToAscii.put('\u0187', "C"); //Latin Capital Letter C with Hook
		unicodeToAscii.put('\u0188', "c"); //Latin Small Letter C with Hook
		unicodeToAscii.put('\u0189', "D"); //Latin Capital Letter African D
		unicodeToAscii.put('\u018A', "D"); //Latin Capital Letter D with Hook
		unicodeToAscii.put('\u018B', "D"); //Latin Capital Letter D with Topbar
		unicodeToAscii.put('\u018C', "d"); //Latin Small Letter D with Topbar
		unicodeToAscii.put('\u018D', "d"); //Latin Small Letter Turned Delta
		unicodeToAscii.put('\u018E', "E"); //Latin Capital Letter Reversed E
		unicodeToAscii.put('\u018F', "e"); //Latin Capital Letter Schwa
		unicodeToAscii.put('\u0190', "E"); //Latin Capital Letter Open E
		unicodeToAscii.put('\u0191', "F"); //Latin Capital Letter F with Hook
		unicodeToAscii.put('\u0192', "f"); //Latin Small Letter F with Hook
		unicodeToAscii.put('\u0193', "G"); //Latin Capital Letter G with Hook
		unicodeToAscii.put('\u0194', "Y"); //Latin Capital Letter Gamma
		unicodeToAscii.put('\u0195', "hv"); //Latin Small Letter Hv
		unicodeToAscii.put('\u0196', "I"); //Latin Capital Letter Iota
		unicodeToAscii.put('\u0197', "I"); //Latin Capital Letter I with Stroke
		unicodeToAscii.put('\u0198', "K"); //Latin Capital Letter K with Hook
		unicodeToAscii.put('\u0199', "k"); //Latin Small Letter K with Hook
		unicodeToAscii.put('\u019A', "l"); //Latin Small Letter L with Bar
		unicodeToAscii.put('\u019B', "l"); //Latin Small Letter Lambda with Stroke
		unicodeToAscii.put('\u019C', "M"); //Latin Capital Letter Turned M
		unicodeToAscii.put('\u019D', "N"); //Latin Capital Letter N with Left Hook
		unicodeToAscii.put('\u019E', "n"); //Latin Small Letter N with Long Right Leg
		unicodeToAscii.put('\u019F', "O"); //Latin Capital Letter O with Middle Tilde
		unicodeToAscii.put('\u01A2', "OI"); //Latin Capital Letter Oi
		unicodeToAscii.put('\u01A3', "oi"); //Latin Small Letter Oi
		unicodeToAscii.put('\u01A4', "P"); //Latin Capital Letter P with Hook
		unicodeToAscii.put('\u01A5', "p"); //Latin Small Letter P with Hook
		unicodeToAscii.put('\u01A6', "R"); //Latin Letter Yr
		unicodeToAscii.put('\u01A7', "S"); //Latin Capital Letter Tone Two
		unicodeToAscii.put('\u01A8', "s"); //Latin Small Letter Tone Two
		unicodeToAscii.put('\u01A9', "S"); //Latin Capital Letter Esh
		unicodeToAscii.put('\u01AA', "s"); //Latin Letter Reversed Esh Loop
		unicodeToAscii.put('\u01AB', "t"); //Latin Small Letter T with Palatal Hook
		unicodeToAscii.put('\u01AC', "T"); //Latin Capital Letter T with Hook
		unicodeToAscii.put('\u01AD', "t"); //Latin Small Letter T with Hook
		unicodeToAscii.put('\u01AE', "T"); //Latin Capital Letter T with Retroflex Hook
		unicodeToAscii.put('\u01B1', "U"); //Latin Capital Letter Upsilon
		unicodeToAscii.put('\u01B2', "V"); //Latin Capital Letter V with Hook
		unicodeToAscii.put('\u01B3', "Y"); //Latin Capital Letter Y with Hook
		unicodeToAscii.put('\u01B4', "y"); //Latin Small Letter Y with Hook
		unicodeToAscii.put('\u01B5', "Z"); //Latin Capital Letter Z with Stroke
		unicodeToAscii.put('\u01B6', "z"); //Latin Small Letter Z with Stroke
		unicodeToAscii.put('\u01B7', "Z"); //Latin Capital Letter Ezh
		unicodeToAscii.put('\u01B8', "Z"); //Latin Capital Letter Ezh Reversed
		unicodeToAscii.put('\u01B9', "z"); //Latin Small Letter Ezh Reversed
		unicodeToAscii.put('\u01BA', "z"); //Latin Small Letter Ezh with Tail
		unicodeToAscii.put('\u01BB', "2"); //Latin Letter Two with Stroke
		unicodeToAscii.put('\u01BC', "5"); //Latin Capital Letter Tone Five
		unicodeToAscii.put('\u01BD', "5"); //Latin Small Letter Tone Five
		unicodeToAscii.put('\u01BE', "t"); //Latin Letter Inverted Glottal Stop with Stroke
		unicodeToAscii.put('\u01BF', "y"); //Latin Letter Wynn
		unicodeToAscii.put('\u01C0', "|"); //Latin Letter Dental Click
		unicodeToAscii.put('\u01C1', "||"); //Latin Letter Lateral Click
		unicodeToAscii.put('\u01C2', "+"); //Latin Letter Alveolar Click
		unicodeToAscii.put('\u01C3', "!"); //Latin Letter Retroflex Click
		unicodeToAscii.put('\u01C4', "DZ"); //Latin Capital Letter Dz with Caron
		unicodeToAscii.put('\u01C5', "Dz"); //Latin Capital Letter D with Small Letter Z with Caron
		unicodeToAscii.put('\u01C6', "dz"); //Latin Small Letter Dz with Caron
		unicodeToAscii.put('\u01C7', "LJ"); //Latin Capital Letter Lj
		unicodeToAscii.put('\u01C8', "Lj"); //Latin Capital Letter L with Small Letter J
		unicodeToAscii.put('\u01C9', "lj"); //Latin Small Letter Lj
		unicodeToAscii.put('\u01CA', "NJ"); //Latin Capital Letter Nj
		unicodeToAscii.put('\u01CB', "Nj"); //Latin Capital Letter N with Small Letter J
		unicodeToAscii.put('\u01CC', "nj"); //Latin Small Letter Nj
		unicodeToAscii.put('\u01DD', "e"); //Latin Small Letter Turned E
		unicodeToAscii.put('\u01E4', "G"); //Latin Capital Letter G with Stroke
		unicodeToAscii.put('\u01E5', "g"); //Latin Small Letter G with Stroke
		unicodeToAscii.put('\u01F1', "DZ"); //Latin Capital Letter Dz
		unicodeToAscii.put('\u01F2', "Dz"); //Latin Capital Letter D with Small Letter Z
		unicodeToAscii.put('\u01F3', "dz"); //Latin Small Letter Dz
		unicodeToAscii.put('\u01F6', "Hv"); //Latin Capital Letter Hwair
		unicodeToAscii.put('\u01F7', "Y"); //Latin Capital Letter Wynn
		unicodeToAscii.put('\u021C', "Z"); //Latin Capital Letter Yogh
		unicodeToAscii.put('\u021D', "z"); //Latin Small Letter Yogh
		unicodeToAscii.put('\u0220', "N"); //Latin Capital Letter N with Long Right Leg
		unicodeToAscii.put('\u0221', "d"); //Latin Small Letter D with Curl
		unicodeToAscii.put('\u0222', "8"); //Latin Capital Letter Ou
		unicodeToAscii.put('\u0223', "8"); //Latin Small Letter Ou
		unicodeToAscii.put('\u0224', "Z"); //Latin Capital Letter Z with Hook
		unicodeToAscii.put('\u0225', "z"); //Latin Small Letter Z with Hook
		unicodeToAscii.put('\u0234', "l"); //Latin Small Letter L with Curl
		unicodeToAscii.put('\u0235', "n"); //Latin Small Letter N with Curl
		unicodeToAscii.put('\u0236', "t"); //Latin Small Letter T with Curl
		unicodeToAscii.put('\u0237', "j"); //Latin Small Letter Dotless J
		unicodeToAscii.put('\u0238', "db"); //Latin Small Letter Db Digraph
		unicodeToAscii.put('\u0239', "qp"); //Latin Small Letter Qp Digraph
		unicodeToAscii.put('\u023A', "A"); //Latin Capital Letter a with Stroke
		unicodeToAscii.put('\u023B', "C"); //Latin Capital Letter C with Stroke
		unicodeToAscii.put('\u023C', "c"); //Latin Small Letter C with Stroke
		unicodeToAscii.put('\u023D', "L"); //Latin Capital Letter L with Bar
		unicodeToAscii.put('\u023E', "T"); //Latin Capital Letter T with Diagonal Stroke
		unicodeToAscii.put('\u023F', "s"); //Latin Small Letter S with Swash Tail
		unicodeToAscii.put('\u0240', "z"); //Latin Small Letter Z with Swash Tail
		unicodeToAscii.put('\u0241', "?"); //Latin Capital Letter Glottal Stop
		unicodeToAscii.put('\u0242', "?"); //Latin Small Letter Glottal Stop
		unicodeToAscii.put('\u0243', "B"); //Latin Capital Letter B with Stroke (Bitcoin)
		unicodeToAscii.put('\u0244', "U"); //Latin Capital Letter U Bar
		unicodeToAscii.put('\u0245', "V"); //Latin Capital Letter Turned V
		unicodeToAscii.put('\u0246', "E"); //Latin Capital Letter E with Stroke
		unicodeToAscii.put('\u0247', "e"); //Latin Small Letter E with Stroke
		unicodeToAscii.put('\u0248', "J"); //Latin Capital Letter J with Stroke
		unicodeToAscii.put('\u0249', "j"); //Latin Small Letter J with Stroke
		unicodeToAscii.put('\u024A', "Q"); //Latin Capital Letter Small Q with Hook Tail
		unicodeToAscii.put('\u024B', "q"); //Latin Small Letter Q with Hook Tail
		unicodeToAscii.put('\u024C', "R"); //Latin Capital Letter R with Stroke
		unicodeToAscii.put('\u024D', "r"); //Latin Small Letter R with Stroke
		unicodeToAscii.put('\u024E', "Y"); //Latin Capital Letter Y with Stroke
		unicodeToAscii.put('\u024F', "y"); //Latin Small Letter Y with Stroke
		unicodeToAscii.put('\u0292', "z"); //Latin Small Letter Ezh
	}

	/**
	 * 
	 * @return a copy of the default normalization map for 
	 */
	public static Map<Character, String> defaultNormalization(){
		Map<Character, String> copy = new HashMap<Character, String>();
		unicodeToAscii.keySet().stream().forEach(ch -> copy.put(ch, unicodeToAscii.get(ch)));
		return copy;
	}	
	
	/**
	 * 
	 * @param additions
	 * @returna copy of the default normalization map for with the additions added
	 */
	@SafeVarargs
	public static Map<Character, String> defaultNormalizationWithAdditions(Pair<Character, String>... additions){
		Map<Character, String> copy = defaultNormalization();
		Arrays.asList(additions).forEach(p -> copy.put(p.key(), p.value()));
		return copy;
	}
	
	/**
	 * Maps all code points in the range \u0000 - \u024F to the graphically most similar character in the range \u0000 - \u007F </br>
	 * Code points in the original string that already are < \u007F are not touched. </br>
	 * Its a best effort and is based primarily on the similarity of the glyph with no regard taken to pronunciation
	 * but this of course has excpetions... (eg.\u00DF Latin Small Letter Sharp S is mapped to 'ss' instead of only an 's')
	 * Controll chars in the range \u0080 - \u009F are not handled at all. They are simply dropped. </br>
	 * This method gives no guarantees for code points above \u024F they will probably be dropped but maybe there is
	 * some code point out there that will be mapped. 
	 * @param string 
	 * @return a string containing only code points < \u007F
	 */
	public static String toAscii(String string){
		return toAscii(string, unicodeToAscii);
	}

	/**
	 * Uses the supplied normalization map to map code points > \007F into the range \u0000 - \u007F. </br> 
	 * Code points in the original string that already are < \u007F are not touched. </br>
	 * An effort will be made to strip combining diacritics from code points in the range \u009F - \u024F
	 * @param string 
	 * @param normalizations A map containing normalizations from Unicode code points to some string representation of code points below \u007F
	 * @return a string containing only code points < \u007F
	 */
	public static String toAscii(String string, Map<Character, String> normalizations){
		return filterRange(Normalizer.normalize(string, Normalizer.Form.NFD), ASCII, normalizations);
	}
	
	/**
	 * Strips all characters not in the <b>range</b>
	 * @param string 
	 * @param range 
	 * @return a string containing only code points in the <b>range</b>
	 */
	public static String filterRange(String string, Range<Character> range) {
		return filterRange(string, range, new HashMap<Character, String>());
	}
	
	/**
	 * Uses the supplied map to map code points into the <b>range</b> </br> 
	 * Code points in the original string that already are in the <b>range</b> are not touched. </br>
	 * @param string 
	 * @param range the range of allowed Unicode code points
	 * @param map mappings from any Unicode code point to some representation of that code point expressed as code points inside the <b>range</b>
	 * @return a string containing only code points in the <b>range</b>
	 */
	public static String filterRange(String string, Range<Character> range, Map<Character, String> map) {
		if(string == null){
			return "";
		}
		map = validateMappingIsIntoRange(map, range);
		StringBuilder sb = new StringBuilder();
		for(Character c : string.toCharArray()){
			if(range.contains(c)){
				sb.append(c);
			}
			else if(map.containsKey(c)){
				sb.append(map.get(c));
			}
		}
		return sb.toString();
	}
	
	private static Map<Character, String> validateMappingIsIntoRange(Map<Character, String> map, Range<Character> range) {
		if(map == null){
			return new HashMap<>();
		}
		for(Character key : map.keySet()){
			for(Character c : map.get(key).toCharArray()){
				if(!range.contains(c)){
					throw new IllegalArgumentException(String.format("The mapping for the character \\u%04X contains the character \\u%04X which is outside the range \\u%04X - \\u%04X", (int)key, (int)c, (int)range.lowerEndpoint(), (int)range.upperEndpoint()));
				}
			}
		}
		return map;
	}
	
}
