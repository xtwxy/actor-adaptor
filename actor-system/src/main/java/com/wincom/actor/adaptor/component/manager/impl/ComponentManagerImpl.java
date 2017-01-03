package com.wincom.actor.adaptor.component.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wincom.actor.adaptor.component.Actor;
import com.wincom.actor.adaptor.component.ActorFactory;
import com.wincom.actor.adaptor.component.ActorMetaData;
import com.wincom.actor.adaptor.component.Connection;
import com.wincom.actor.adaptor.component.Queue;
import com.wincom.actor.adaptor.component.manager.ComponentManager;

public class ComponentManagerImpl implements ComponentManager {

	public Map<String, ActorFactory> actorFactories = new HashMap<>();

	@Override
	public void bind(String name, ActorFactory factory) {
		ActorFactory o = actorFactories.get(name);
		if (o != null) {
			throw new RuntimeException("name alread bound: " + name);
		}
		actorFactories.put(name, factory);
	}

	@Override
	public void unbind(String name) {
		actorFactories.remove(name);
	}

	@Override
	public Actor createActor(String typeId) {
		for (Map.Entry<String, ActorFactory> e : actorFactories.entrySet()) {
			ActorFactory factory = (ActorFactory) e.getValue();
			Actor actor = factory.create(typeId);
			if (actor != null) {
				return actor;
			}
		}
		return null;
	}

	@Override
	public Connection createConnection(Queue src, Queue dest) {
		return new ConnectionImpl(src, dest);
	}

	@Override
	public List<ActorMetaData> getActorMetaData() {
		List<ActorMetaData> meta = new ArrayList<>();
		for(ActorFactory f: actorFactories.values()) {
			List<ActorMetaData> m = f.getMetaData();
			if(m != null) {
				meta.addAll(m);
			}
		}
		return meta;
	}

}
