package io.digicom.core.uuid.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

@Service
public interface UUIDListManager extends Serializable{

	void addUUIDs(int num) throws UnsupportedEncodingException;
	void addUUIDsSync (int num) throws UnsupportedEncodingException;
	

}