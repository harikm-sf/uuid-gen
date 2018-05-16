package io.digicom.core.uuid.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;

@Service
public interface UUIDFactory extends Serializable {
	
	public List<UUIDModel> getOne() throws UnsupportedEncodingException;

	public List<UUIDModel> getMany(int num) throws UnsupportedEncodingException;
	
}
