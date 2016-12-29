package interfaces;

public interface GenericMethod {
	public <T extends Comparable<T> > int test1(T l, T r);
}
