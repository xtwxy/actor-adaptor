package com.wincom.actor.adaptor.compmgr;

public interface ComponentManager {
	public void bind(String name, ActorFactory factory);
	public void unbind(String name);
	public Actor createActor(String typeId);
	public Connection createConnection(Queue src, Queue dest);
}
