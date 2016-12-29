package com.wincom.actor.adaptor.compmgr;

public interface Queue {
	public <T> void enqueue(Port sender, T msg);
	
	public void subscribe(Subscriber subscriber);
	public void unsubscribe(Subscriber subscriber);
}
