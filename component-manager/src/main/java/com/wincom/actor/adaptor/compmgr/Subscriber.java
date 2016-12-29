package com.wincom.actor.adaptor.compmgr;

public interface Subscriber {
	public <T> void onMessage(Port sender, T msg);
}
