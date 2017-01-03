package test.component;

import java.util.ArrayList;
import java.util.List;

import com.wincom.actor.adaptor.compmgr.Actor;
import com.wincom.actor.adaptor.compmgr.ActorFactory;
import com.wincom.actor.adaptor.compmgr.ActorMetaData;

import test.component.actors.Test1Actor;
import test.component.actors.Test1ActorMetaData;
import test.component.actors.Test2Actor;
import test.component.actors.Test2ActorMetaData;

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

	@Override
	public ActorMetaData getMetaData(String typeId) {
		if (Test1Actor.ID.equals(typeId)) {
			return new Test1ActorMetaData();
		} else if (Test2Actor.ID.equals(typeId)) {
			return new Test2ActorMetaData();
		}
		return null;
	}

	@Override
	public List<ActorMetaData> getMetaData() {
		List<ActorMetaData> metaData = new ArrayList<>();
		metaData.add(getMetaData(Test1Actor.ID));
		metaData.add(getMetaData(Test2Actor.ID));

		return metaData;
	}
}
