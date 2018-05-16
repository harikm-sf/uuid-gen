package io.digicom.core.uuid.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDList;
import io.digicom.core.uuid.model.UUIDModel;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;



@Service
public class UUIDListManagerImpl extends BaseService implements UUIDListManager {
	
	@Autowired
	HazelcastInstance hci;
	
	@Autowired
	UUIDModelGenerator modelGenerator;
	
	@Override
	@Async
	public void addUUIDs(int num) {
		IList<UUIDModel> list = hci.getList("UUIDLIST");
		for(int i = 0; i < num ; i++) {
			list.add(modelGenerator.getUUIDModel());
		}
	}
	
	@PostConstruct
	public void init() {
		IList<UUIDModel> list = hci.getList("UUIDLIST");
		if(list.isEmpty()) {
			addUUIDs(100);
		}else if(list.size() < 100) {
			addUUIDs(100-list.size());
		}
	}

}
