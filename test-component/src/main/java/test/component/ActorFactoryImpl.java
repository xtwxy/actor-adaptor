package test.component;

import com.wincom.actor.adaptor.compmgr.Actor;
import com.wincom.actor.adaptor.compmgr.ActorFactory;

import test.component.actors.Test1Actor;
import test.component.actors.Test2Actor;

public class ActorFactoryImpl implements ActorFactory {

	@Override
	public Actor create(String typeId) {
		if (Test1Actor.ID.equals(typeId)) {
			return new Test1Actor();
		} else if (Test2Actor.ID.equals(typeId)) {
			return new Test2Actor();
		}
		return null;
	}

}
