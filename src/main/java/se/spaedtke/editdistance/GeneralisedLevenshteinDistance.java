package se.spaedtke.editdistance;

import java.text.DecimalFormat;

public class GeneralisedLevenshteinDistance {
	private final double substitutionCost;
	private final double deleteCost;
	private final double insertCost;
	
	public GeneralisedLevenshteinDistance(double substitutionCost, double deleteCost, double insertCost){
		this.substitutionCost = substitutionCost;
		this.deleteCost = deleteCost;
		this.insertCost = insertCost;
	}
	
	public double calculate(String s1, String s2) {
		return calculateMatrix(s1, s2)[s1.length()][s2.length()];
	}

	public String asMatrix(String s1, String s2) {
		return asMatrix(calculateMatrix(s1, s2), s1, s2);
	}

	private double[][] calculateMatrix(String s1, String s2) {
		double[][] distance = new double[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < s1.length() + 1; i++) {
			distance[i][0] = i;
		}
		for (int j = 1; j < s2.length() + 1; j++) {
			distance[0][j] = j;
		}
		for (int j = 1; j < s2.length() + 1; j++) {
			for (int i = 1; i < s1.length() + 1; i++) {
				distance[i][j] = Math.min(distance[i - 1][j] + deleteCost, Math.min(distance[i][j - 1] + insertCost,
						distance[i - 1][j - 1] + substitutionCost(s1.charAt(i - 1), s2.charAt(j - 1))));
			}
		}
		return distance;
	}

	private double substitutionCost(char c1, char c2) {
		if (c1 == c2) {
			return 0;
		}
		return substitutionCost;
	}

	private String asMatrix(double[][] distance, String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.##");
		sb.append("\t\"\"\t");
		for (int i = 1; i < s2.length() + 1; i++) {
			sb.append(s2.charAt(i - 1) + "\t");
		}
		sb.append("\n");
		for (int i = 0; i < distance.length; i++) {
			if (i == 0) {
				sb.append("\"\"\t");
			} else {
				sb.append(s1.charAt(i - 1) + "\t");
			}
			for (int j = 0; j < distance[i].length; j++) {
				sb.append(df.format(distance[i][j]) + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
