package com.wincom.actor.adaptor.component;

import java.util.ArrayList;
import java.util.List;

public class Aggregate {
	protected List<Actor> actors = new ArrayList<>();
	protected List<Connection> connections = new ArrayList<>();
	protected List<Queue> queues = new ArrayList<>();
	protected List<Aggregate> aggregates = new ArrayList<>();
	protected List<OutputPort> outputs = new ArrayList<>();
	protected String aggregateId;
	protected String name;

	/**
	 * Dispose this aggregate.
	 * Nested {@link Actor} is also disposed.
	 * Referenced {@link Aggregate}s and {@link Queue}s not disposed, 
	 * since it is not belong to this {@link Aggregate} or maybe a shared object.
	 */
	public void dispose() {
		// dispose actors
		for(Actor a : actors) {
			a.dispose();
		}
		actors.clear();
		
		// dispose connections
		for(Connection c : connections) {
			c.dispose();
		}
		connections.clear();
	}

	public List<OutputPort> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<OutputPort> outputs) {
		this.outputs = outputs;
	}

	public Aggregate(String id, String name) {
		this.aggregateId = id;
		this.name = name;
	}
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public List<Queue> getQueues() {
		return queues;
	}

	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}

	public List<Aggregate> getAggregates() {
		return aggregates;
	}

	public void setAggregates(List<Aggregate> aggregates) {
		this.aggregates = aggregates;
	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggregateId == null) ? 0 : aggregateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aggregate other = (Aggregate) obj;
		if (aggregateId == null) {
			if (other.aggregateId != null)
				return false;
		} else if (!aggregateId.equals(other.aggregateId))
			return false;
		return true;
	}
}
