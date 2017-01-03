package test.component.actors;

import java.util.ArrayList;
import java.util.List;

import com.wincom.actor.adaptor.compmgr.ActorMetaData;

public class Test1ActorMetaData implements ActorMetaData {

	@Override
	public String getTypeId() {
		return Test1Actor.ID;
	}

	@Override
	public String getTypeName() {
		return Test1Actor.ID;
	}

	@Override
	public List<String> getOutputNames() {
		List<String> names = new ArrayList<>();
		names.add(Test1Actor.OUTPUT_1);
		names.add(Test1Actor.OUTPUT_2);
		return names;
	}

}
