package com.wincom.actor.adaptor.compmgr;

import java.util.List;

public interface Actor extends Subscriber {
	public Port getOutput(String name);
	public List<Port> getOutputs();
}
