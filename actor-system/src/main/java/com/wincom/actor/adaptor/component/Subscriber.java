package com.wincom.actor.adaptor.component;

public interface Subscriber {
	public <T> void onMessage(Port sender, T msg);
}
