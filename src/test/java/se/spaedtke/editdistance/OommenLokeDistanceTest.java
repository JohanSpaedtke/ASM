package se.spaedtke.editdistance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class OommenLokeDistanceTest {

	@Test
	public void distance(){
		System.out.println("All");
		List<EditDistance> ds = Arrays.asList(new OommenLokeDistance(), new LevenshteinDistance(), new HammingDistance());
		List<List<String>> pairs = Arrays.asList(
				Arrays.asList("anything", "vtyhinh"), 
				Arrays.asList("altogether", "akvotbterdhoanuxker"),
				Arrays.asList("account", "awocnt"),
				Arrays.asList("andersson", "johansson"),
				Arrays.asList("nilsson", "tulldahl"),
		Arrays.asList("spaedtke", "spädtke"),
		Arrays.asList("spädtke", "spedtke"),
		Arrays.asList("spaedtke", "spetke"));
		Map<String, Double> distances = new HashMap<>();
		for(EditDistance d : ds){
			for(List<String> p : pairs){
				distances.compute(p.get(0).concat("-").concat(p.get(1)), (k,v) -> v == null ? d.calculate(p.get(0), p.get(1)) : v + d.calculate(p.get(0), p.get(1)));
			}
		}
		distances.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()/ds.size()));		
	}
	
	@Test
	public void shouldCalculateance(){
		System.out.println("Oommen");
		OommenLokeDistance od = new OommenLokeDistance();
		System.out.println(od.calculate("anything", "vtyhinh"));
		System.out.println(od.calculate("altogether", "akvotbterdhoanuxker"));
		System.out.println(od.calculate("account", "awocnt"));
		System.out.println(od.calculate("sat", "cat"));
		System.out.println(od.calculate("sat", "ast"));
	}
	
	@Test
	public void shouldCalculateLevenshteinDistance(){
		System.out.println("Leven");
		LevenshteinDistance ld = new LevenshteinDistance();
		System.out.println(ld.calculate("anything", "vtyhinh"));
		System.out.println(ld.calculate("altogether", "akvotbterdhoanuxker"));
		System.out.println(ld.calculate("account", "awocnt"));
		System.out.println(ld.calculate("sat", "cat"));
		System.out.println(ld.calculate("sat", "ast"));
	}
	
	@Test
	public void shouldCalculateHammingDistance(){
		System.out.println("Hamming");
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.calculate("anything", "vtyhinh"));
		System.out.println(hd.calculate("altogether", "akvotbterdhoanuxker"));
		System.out.println(hd.calculate("account", "awocnt"));
		System.out.println(hd.calculate("sat", "cat"));
		System.out.println(hd.calculate("sat", "ast"));
	}
}
