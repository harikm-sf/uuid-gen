package io.digicom.core.uuid.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;

@Service
public interface UUIDListManager extends Serializable{

	Future<List<UUIDModel>> addUUIDs(int num) throws UnsupportedEncodingException;
	void addUUIDsSync (int num) throws UnsupportedEncodingException;
	

}