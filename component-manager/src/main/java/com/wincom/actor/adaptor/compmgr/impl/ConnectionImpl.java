package com.wincom.actor.adaptor.compmgr.impl;

import com.wincom.actor.adaptor.compmgr.Connection;
import com.wincom.actor.adaptor.compmgr.Port;
import com.wincom.actor.adaptor.compmgr.Queue;

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
}
