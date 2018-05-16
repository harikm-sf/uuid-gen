package io.digicom.core.uuid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;

import io.digicom.core.uuid.model.UUIDModel;

@Service
public class UUIDFactoryImpl extends BaseService implements UUIDFactory {

	private static final long serialVersionUID = -4260825536667726610L;
	
	private static final int ONE = 1;
	
	@Autowired
	UUIDListManager uuidListManager;
	
	@Autowired
	HazelcastInstance hci;
	
	
	@Override
	public UUIDModel getOne() {
		List<UUIDModel> uuidList =  hci.getList("UUIDLIST");
		UUIDModel model = uuidList.get(0)
				.setDateTime(new Date());

		uuidList.remove(0);
		return model;
	}

	@Override
	public List<UUIDModel> getMany(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
