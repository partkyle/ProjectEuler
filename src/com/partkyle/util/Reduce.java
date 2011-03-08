package com.partkyle.util;

import java.util.Collection;
import java.util.Iterator;

public abstract class Reduce<T> {

	public abstract boolean predicate(T left, T right);

	@SuppressWarnings("unchecked")
	public Collection<T> reduce(final Collection<T> collection) {
		Collection<T> result;
		try {
			result = collection.getClass().newInstance();
			
			Iterator<T> iter = collection.iterator();
			
			while (iter.hasNext()) {
			}
			
			return result;
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return null;
	}

}
