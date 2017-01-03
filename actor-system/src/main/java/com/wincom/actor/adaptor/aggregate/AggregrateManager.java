package com.wincom.actor.adaptor.aggregate;

import java.util.List;

import com.wincom.actor.adaptor.component.Aggregate;

public interface AggregrateManager {
	public void create(String id, String name);
	public void delete(String id);
	public Aggregate retrieve(String id);
	public List<String> getAllAggregateIds();
}
