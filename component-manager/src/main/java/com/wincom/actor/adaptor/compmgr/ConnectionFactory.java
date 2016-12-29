package com.wincom.actor.adaptor.compmgr;

public interface ConnectionFactory {
	Connection create(Queue src, Queue dest);
}
