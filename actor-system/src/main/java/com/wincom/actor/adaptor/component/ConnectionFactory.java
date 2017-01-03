package com.wincom.actor.adaptor.component;

public interface ConnectionFactory {
	Connection create(Queue src, Queue dest);
}
