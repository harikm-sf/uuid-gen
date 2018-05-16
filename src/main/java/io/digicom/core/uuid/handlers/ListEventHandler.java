package io.digicom.core.uuid.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

import io.digicom.core.uuid.model.UUIDModel;
import io.digicom.core.uuid.service.UUIDListManager;

@Component
public class ListEventHandler extends BaseHandler implements ItemListener<UUIDModel> {
	
	@Autowired
	UUIDListManager manager;
	
	
	@Override
	public void itemAdded(ItemEvent<UUIDModel> model) {
		String source  =(String) model.getSource();
		logger.trace("Item added :" + model.toString() + " to " + source);
	}

	@Override
	//@Async
	public void itemRemoved(ItemEvent<UUIDModel> itemEvent) {
		String source  =(String) itemEvent.getSource();
		logger.trace("Item removed :" + itemEvent.getItem() + " from " + source);
		
		manager.addUUIDs(1);
	}



}
