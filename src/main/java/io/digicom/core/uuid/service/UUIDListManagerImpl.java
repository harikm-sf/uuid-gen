package io.digicom.core.uuid.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;

import io.digicom.core.uuid.model.UUIDModel;



@Service
public class UUIDListManagerImpl extends BaseService implements UUIDListManager {
	

	private static final long serialVersionUID = 232240097070121931L;
	
	private static final int INIT_LIST_SIZE=25;
	
	private int listSize = 25;
	
	@Autowired
	HazelcastInstance hci;
	
	@Autowired
	UUIDModelGenerator modelGenerator;
	
	@Override
	@Async
	public void addUUIDs(int num) throws UnsupportedEncodingException {
		IList<UUIDModel> list = hci.getList("UUIDLIST");
		for(int i = 0; i < num ; i++) {
			UUIDModel model = (modelGenerator.getUUIDModel());
			list.add(model);
		}
	}
	
	@Override
	public void addUUIDsSync(int num) throws UnsupportedEncodingException {
		IList<UUIDModel> list = hci.getList("UUIDLIST");
		for(int i = 0; i < num ; i++) {
			UUIDModel model = (modelGenerator.getUUIDModel());
			list.add(model);
		}
		
	}
	
	@PostConstruct
	public void init() throws UnsupportedEncodingException {
		logger.debug("Initializing the list with startup list");
		IList<UUIDModel> list = hci.getList("UUIDLIST");
		if(list.isEmpty()) {
			addUUIDs(INIT_LIST_SIZE);
		}else if(list.size() < INIT_LIST_SIZE) {
			addUUIDs(INIT_LIST_SIZE - list.size());
		}
	}



	

}
