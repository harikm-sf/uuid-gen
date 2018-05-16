package io.digicom.core.uuid.handlers;

import org.springframework.scheduling.annotation.Async;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

import io.digicom.core.uuid.model.UUIDModel;


public class ListEventHandler extends BaseHandler implements ItemListener<UUIDModel> {
	
	
	@Override
	public void itemAdded(ItemEvent<UUIDModel> model) {
		String source  =(String) model.getSource();
		logger.trace("Item added :" + model.toString() + " to " + source);
		logsize();
	}

	@Override
	public void itemRemoved(ItemEvent<UUIDModel> itemEvent) {
		String source  =(String) itemEvent.getSource();
		logger.trace("Item removed :" + itemEvent.getItem() + " from " + source);
		logsize();
	}
	
	private void logsize() {
		HazelcastInstance h = Hazelcast.getHazelcastInstanceByName("UUIDGEN");
		logger.debug("Size of the list : "+h.getList("UUIDLIST").size());
	}



}
