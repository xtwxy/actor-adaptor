package com.wincom.actor.adaptor.aggregate.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wincom.actor.adaptor.aggregate.AggregrateManager;
import com.wincom.actor.adaptor.component.Aggregate;

public class AggregrateManagerImpl implements AggregrateManager {

	private Map<String, Aggregate> aggregates = new HashMap<>();

	@Override
	public void create(String id, String name) {
		Aggregate theAggregate = aggregates.get(id);
		if (theAggregate != null) {
			throw new RuntimeException("already exists.");
		}
		aggregates.put(id, new Aggregate(id, name));
	}

	@Override
	public void delete(String id) {
		Aggregate theAggregate = aggregates.get(id);
		if (theAggregate == null) {
			throw new RuntimeException("not exists.");
		}
		aggregates.remove(id);
		theAggregate.dispose();
	}

	@Override
	public Aggregate retrieve(String id) {
		return aggregates.get(id);
	}

	@Override
	public List<String> getAllAggregateIds() {
		List<String> l = new ArrayList<>();
		l.addAll(aggregates.keySet());

		return l;
	}
}
