package test.component.actors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wincom.actor.adaptor.compmgr.OutputPort;
import com.wincom.actor.adaptor.compmgr.Port;

public class Test1Actor extends AbstractActor {
	public static String ID = "test.component.actors.test1";

	private Map<String, Port> outputs = new HashMap<String, Port>();

	public Test1Actor() {
		outputs.put("output-1", new OutputPort());
		outputs.put("output-2", new OutputPort());
	}
	@Override
	public Port getOutput(String name) {
		return outputs.get(name);
	}

	@Override
	public List<Port> getOutputs() {
		List<Port> ports = new ArrayList<>();
		ports.addAll(outputs.values());
		
		return ports;
	}

}
