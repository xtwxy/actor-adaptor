package test.component.actors;

import java.util.ArrayList;
import java.util.List;

import com.wincom.actor.adaptor.compmgr.ActorMetaData;

public class Test2ActorMetaData implements ActorMetaData {

	@Override
	public String getTypeId() {
		return Test2Actor.ID;
	}

	@Override
	public String getTypeName() {
		return Test2Actor.ID;
	}

	@Override
	public List<String> getOutputNames() {
		List<String> names = new ArrayList<>();
		names.add(Test2Actor.DATA_OUTPUT);
		names.add(Test2Actor.ERROR_OUTPUT);
		return names;
	}

}
