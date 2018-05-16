package io.digicom.core.uuid.model;

import com.hazelcast.core.IList;

public interface UUIDList<T> extends IList<T>{

	@Override
	public boolean add(T e);

	@Override
	public T get(int index);

}
