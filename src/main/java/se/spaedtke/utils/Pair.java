package se.spaedtke.utils;

public class Pair<L, R> {

	private final L l;
	private final R r;

	private Pair(L l, R r){
		this.l = l;
		this.r = r;
	}

	public static <L,R> Pair<L,R> of(L l, R r){
		if(l == null){
			throw new IllegalArgumentException("The left element of the pair was null");
		}
		if(r == null){
			throw new IllegalArgumentException("The right element of the pair was null");
		}
		return new Pair<L, R>(l, r);
	}

	public static <L,R> Pair<L,R> ofNullable(L l, R r){
		return new Pair<L, R>(l, r);
	}

	/**
	 * 
	 * @return true if either one of the elements that make up the pair is null
	 */
	public boolean containsNull(){
		return l == null || r == null;
	}

	public L key(){
		return l;
	}

	public L left(){
		return l;
	}

	public R value(){
		return r;
	}

	public R right(){
		return r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((l == null) ? 0 : l.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (l == null) {
			if (other.l != null)
				return false;
		} else if (!l.equals(other.l))
			return false;
		if (r == null) {
			if (other.r != null)
				return false;
		} else if (!r.equals(other.r))
			return false;
		return true;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(l != null ? l.toString() : "null");
		sb.append(" - ");
		sb.append(r != null ? r.toString() : "null");
		return sb.toString();
	}
}