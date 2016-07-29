package se.spaedtke.utils;

public class StringUtils {

	public static String removeDuplicates(String string) {
		if(string == null){
			return string;
		}
		if(string.isEmpty()){
			return string;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(string.charAt(0));
		for (int i = 1; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (string.charAt(i-1) != ch) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static String removeAll(String regex, String string) {
		return string.replaceAll(regex, "");
	}
	
	public static String removeFirst(int numChars, String string){
		return string.substring(numChars);
	}
	
	public static String makeOfLength(int desiredLength, String string) {
		return makeOfLength(desiredLength, '\u2205', string);
	}
	
	public static String makeOfLength(int desiredLength, char padding, String string) {
		if (string.length() >= desiredLength) {
			return string.substring(0, desiredLength);
		} else {
			return padWith(padding, desiredLength - string.length(), new StringBuilder().append(string));
		}
	}

	private static String padWith(char padding, int numPaddings, StringBuilder sb) {
		if (numPaddings == 0) {
			return sb.toString();
		} else {
			return padWith(padding, numPaddings - 1, sb.append(padding));
		}
	}

}
