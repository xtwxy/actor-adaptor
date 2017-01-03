package com.wincom.actor.adaptor.component;

import java.util.List;

public interface ActorFactory {
	public Actor create(String typeId);
	public ActorMetaData getMetaData(String typeId);
	public List<ActorMetaData> getMetaData();
}
