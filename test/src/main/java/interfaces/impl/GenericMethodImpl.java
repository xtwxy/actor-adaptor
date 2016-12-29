package interfaces.impl;

import interfaces.GenericMethod;

public class GenericMethodImpl implements GenericMethod {

	@Override
	public <T extends Comparable<T> > int test1(T l, T r) {
		return l.compareTo(r);
	}

	public static void main(String[] args) {
		GenericMethod gm = new GenericMethodImpl();
		System.out.println(gm.test1("hello", "hello"));
		System.out.println(gm.test1("hello", "world"));
		System.out.println(gm.test1(1, 1));
		System.out.println(gm.test1(1, 3));
	}
}
