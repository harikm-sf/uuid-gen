package io.digicom.core.uuid.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public interface UUIDListManager extends Serializable{

	void addUUIDs(int num);
	

}