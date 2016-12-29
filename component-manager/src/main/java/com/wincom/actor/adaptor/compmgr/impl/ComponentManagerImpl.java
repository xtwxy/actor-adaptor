package com.wincom.actor.adaptor.compmgr.impl;

import java.util.HashMap;
import java.util.Map;

import com.wincom.actor.adaptor.compmgr.Actor;
import com.wincom.actor.adaptor.compmgr.ActorFactory;
import com.wincom.actor.adaptor.compmgr.ComponentManager;
import com.wincom.actor.adaptor.compmgr.Connection;
import com.wincom.actor.adaptor.compmgr.Queue;

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

}
