package io.digicom.core.uuid.config;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.ItemListenerConfig;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ListConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

import io.digicom.core.uuid.handlers.ListEventHandler;

@Configuration
public class HazelcastConfig {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${digicom.cache.list}")
	private String cacheList;
	@Value("${digicom.cache.multicast.group}")
	private String multicastGroup;
	
	private HazelcastInstance instance;

	@Bean
	public CacheManager cacheManager() {
		// HazelcastInstance instance =
		// Hazelcast.newHazelcastInstance(getConfig());
		return new HazelcastCacheManager(instance);
	}

	// @Bean
	public Config getConfig() {
		Config config = new Config();
		List<String> cachesList = Arrays.asList(cacheList.split("\\s*,\\s*"));
		for (String cache : cachesList) {
			logger.debug("Adding cache config for : " + cache);
			MapConfig mapConfig = new MapConfig();
			config.getMapConfigs().put(cache, mapConfig);

		}
		
		ItemListenerConfig itemListenerConfig = new ItemListenerConfig();
		itemListenerConfig.setImplementation(new ListEventHandler());
		
		ListConfig listConfig = new ListConfig();
		listConfig.setBackupCount(1);
		listConfig.addItemListenerConfig(itemListenerConfig);
		config.getListConfigs().put("UUIDLIST", listConfig);
		
		/*MapConfig mapConfig = new MapConfig();
		mapConfig.setBackupCount(1);
		config.getMapConfigs().put("responseMap", mapConfig);*/
		
		NetworkConfig networkConfig = config.getNetworkConfig();
		JoinConfig join = networkConfig.getJoin();
		join.getMulticastConfig().setMulticastGroup(multicastGroup);
		join.getMulticastConfig().setEnabled(true);
		join.getTcpIpConfig().setEnabled(false);
		networkConfig.getInterfaces().setEnabled(false);
		//config.getManagementCenterConfig().setEnabled(true).setUrl("http://localhost:8082/mancenter")
				//.setUpdateInterval(3);
		config.getServicesConfig().setEnableDefaults(true);
		return config;
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		// return Hazelcast.newHazelcastInstance(getConfig());
		return instance;
	}

	@PostConstruct
	protected void init() {
		instance = Hazelcast.newHazelcastInstance(getConfig());
	}
}