package com.wincom.actor.adaptor.component.manager.impl;

import com.wincom.actor.adaptor.component.Connection;
import com.wincom.actor.adaptor.component.Port;
import com.wincom.actor.adaptor.component.Queue;

public class ConnectionImpl implements Connection {
	private Queue source;
	private Queue destination;
	
	public ConnectionImpl(Queue src, Queue dest) {
		this.source = src;
		this.destination = dest;
		this.source.subscribe(this);
	}
	
	@Override
	public <T> void onMessage(Port sender, T msg) {
		this.destination.enqueue(sender, msg);
	}

	@Override
	public void dispose() {
		this.source.unsubscribe(this);
	}
}
