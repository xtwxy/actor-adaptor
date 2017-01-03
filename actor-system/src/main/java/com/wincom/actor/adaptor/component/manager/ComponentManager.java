package com.wincom.actor.adaptor.component.manager;

import java.util.List;

import com.wincom.actor.adaptor.component.Actor;
import com.wincom.actor.adaptor.component.ActorFactory;
import com.wincom.actor.adaptor.component.ActorMetaData;
import com.wincom.actor.adaptor.component.Connection;
import com.wincom.actor.adaptor.component.Queue;

public interface ComponentManager {
	public void bind(String name, ActorFactory factory);
	public void unbind(String name);
	public Actor createActor(String typeId);
	public Connection createConnection(Queue src, Queue dest);
	public List<ActorMetaData> getActorMetaData();
}
