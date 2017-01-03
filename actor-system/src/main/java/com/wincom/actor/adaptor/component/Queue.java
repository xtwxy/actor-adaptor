package com.wincom.actor.adaptor.component;

public interface Queue {
	/**
	 * Enqueue a message.
	 * 
	 * @param sender the sender of the message
	 * @param msg the message
	 */
	public <T> void enqueue(Port sender, T msg);

	/**
	 * Subscribe messages from this queue.
	 * 
	 * @param subscriber the subscriber
	 */
	public void subscribe(Subscriber subscriber);

	/**
	 * Unsubscribe message by disconnect the subscriber.
	 * 
	 * @param subscriber the subscriber
	 */
	public void unsubscribe(Subscriber subscriber);
}
