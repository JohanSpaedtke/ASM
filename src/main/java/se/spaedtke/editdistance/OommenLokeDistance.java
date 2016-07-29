package se.spaedtke.editdistance;

import java.text.DecimalFormat;

/**
 * Oommen, B. J.; Loke, R. K. S.
 * "Pattern recognition of strings with substitutions, insertions, deletions and generalized transpositions"
 * . doi:10.1016/S0031-3203(96)00101-X. CiteSeerX: 10.1.1.50.1459.
 * 
 * @author johan
 *
 */
public class OommenLokeDistance implements EditDistance {

	@Override
	public double calculate(String s1, String s2){
		return ((double)calculateAbsolute(s1, s2))/((double)Math.max(s1.length(), s2.length()));
	}
	
	@Override
	public int calculateAbsolute(String s1, String s2){
		int[][] Z = new int[s1.length()][s2.length()];
		for(int i = 1; i < s1.length(); i++){
			Z[i][0] = Z[i-1][0] + erase(s1.charAt(i-1));
		}
		for(int j = 1; j < s2.length(); j++){
			Z[0][j] = Z[0][j-1] + insert(s2.charAt(j-1));
		}
		for(int i = 1; i < s1.length(); i++){
			Z[i][1] = Math.min(Z[i-1][1] + erase(s1.charAt(i-1)), 
					Math.min(Z[i][0] + insert(s1.charAt(i-1)), 
							Z[i-1][0] + substitute(s1.charAt(i-1), s2.charAt(0))));
		}
		for(int j = 2; j < s2.length(); j++){
			Z[1][j] = Math.min(Z[1][j-1] + insert(s2.charAt(j-1)), 
					Math.min(Z[0][j] + erase(s2.charAt(j-1)), 
							Z[0][j-1]+substitute(s1.charAt(0), s2.charAt(j-1))));
		}
		for(int i = 2; i < s1.length(); i++){
			for(int j = 2; j < s2.length(); j++){
				Z[i][j] = Math.min(Z[i-1][j] + erase(s1.charAt(i-1)), 
						Math.min(Z[i][j-1] + insert(s2.charAt(j-1)), 
								Math.min(Z[i-1][j-1] + substitute(s1.charAt(i-1), s2.charAt(j-1)), 
								Z[i-2][j-2] + transpose(s1.substring(i-2, i), s2.substring(j-2, j)))));
			}
		}
		//System.out.println(interpret(Z, s1, s2));
		return Z[s1.length()-1][s2.length()-1];
	}

	private String interpret(int[][] Z, String s1, String s2){
		StringBuilder sb =new StringBuilder();
		int i = s1.length()-1; 
		int j = s2.length()-1;
		while(i != 0 || j != 0){
			if(Z[i][j] == Z[i-1][j-1] + substitute(s1.charAt(i), s2.charAt(j))){
				sb.append("Substitute " + s1.charAt(i) + " by " + s2.charAt(j) + "\n");
				i = i -1;
				j = j -1;
			}else{
				if(Z[i][j] == Z[i][j-1] + insert(s2.charAt(j))){
					sb.append("Insert " + s2.charAt(j) + "\n");
					j = j-1;
				}else{
					if(Z[i][j] == Z[i-1][j] + erase(s1.charAt(i))){
						sb.append("Delete " + s1.charAt(i) + "\n");
						i = i-1;
					}
					else{
						if(Z[i][j] == Z[i-2][j-2] + transpose(s1.substring(i-2, i), s2.substring(j-2, j))){
							sb.append("Transpose " + s1.substring(i-2, i) + " into " + s2.substring(j-2, j) + "\n");
							i = i-2;
							j = j-2;
						}
					}
				}
			}
		}
		return sb.toString();
	}
	
	private String asMatrix(int[][] distance, String s1, String s2) {
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
	
	private int transpose(String substring, String substring2) {
		if(substring.equals(substring2)){
			return 0;
		}
		return 1;
	}

	protected int substitute(char charAt, char charAt2) {
		if(charAt == charAt2){
			return 0;
		}
		return 1;
	}

	private int erase(char charAt) {
		return 1;
	}
	
	private int insert(char charAt) {
		return 1;
	}
}
