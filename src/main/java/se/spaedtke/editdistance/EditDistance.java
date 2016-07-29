package se.spaedtke.editdistance;

public interface EditDistance {
	public double calculate(String s1, String s2);
	public int calculateAbsolute(String s1, String s2);
}
