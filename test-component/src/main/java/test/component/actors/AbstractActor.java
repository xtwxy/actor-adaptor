package test.component.actors;

import com.wincom.actor.adaptor.compmgr.Actor;
import com.wincom.actor.adaptor.compmgr.Port;

public abstract class AbstractActor implements Actor {
	protected Port input;

	@Override
	public <T> void onMessage(Port sender, T msg) {
		input.enqueue(sender, msg);
	}

}
