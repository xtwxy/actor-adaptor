package com.wincom.actor.adaptor.component;

import java.util.ArrayList;
import java.util.List;

public class OutputPort implements Port {
	private List<Subscriber> subscribers = new ArrayList<>();

	@Override
	public <T> void enqueue(Port sender, T msg) {
		for (Subscriber s : subscribers) {
			s.onMessage(sender, msg);
		}
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void dispose() {
		subscribers.clear();
	}

}
