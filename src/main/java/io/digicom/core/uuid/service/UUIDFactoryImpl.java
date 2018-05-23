package io.digicom.core.uuid.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<UUIDModel> getOne() throws UnsupportedEncodingException {
		List<UUIDModel> uuidList =  hci.getList("UUIDLIST");
		UUIDModel model = uuidList.get(0);
		uuidList.remove(0);
		uuidListManager.addUUIDs(ONE);
		List<UUIDModel> retVal = new ArrayList<UUIDModel>();
		retVal.add(model);
		return retVal;
	}

	@Override
	public List<UUIDModel> getMany(int num) throws UnsupportedEncodingException {
		List<UUIDModel> uuidList =  hci.getList("UUIDLIST");
		int initSize = uuidList.size();
		
		if(num > initSize) {
			logger.debug("Have to add more to the list right now");
			uuidListManager.addUUIDs(num - initSize);
		}
		
		List<UUIDModel> retVal = new ArrayList<UUIDModel>();
		
		for(int i = 0; i< num; i++) {
			retVal.add(uuidList.get(0));
			uuidList.remove(0);
		}
		
		Future<List<UUIDModel>> updatedList = uuidListManager.addUUIDs(num);
		
		logger.debug("List size before/after :" + initSize + "/"+uuidList.size());
		return retVal;
		
	}

	
	

}
