package com.partkyle.util;

import java.util.Collection;

public abstract class Filter<T> {

	public abstract boolean predicate(T item);

	@SuppressWarnings("unchecked")
	public Collection<T> filter(final Collection<T> collection) {
		Collection<T> result;
		try {
			result = collection.getClass().newInstance();
			for (T t : collection) {
				if (predicate(t)) {
					result.add(t);
				}
			}
			return result;
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return null;
	}

}
