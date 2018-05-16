package io.digicom.core.uuid.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;

@Service
public interface UUIDFactory extends Serializable {
	
	public UUIDModel getOne();

	public List<UUIDModel> getMany(int num);
	
}
