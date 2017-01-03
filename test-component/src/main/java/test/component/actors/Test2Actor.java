package test.component.actors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wincom.actor.adaptor.compmgr.OutputPort;
import com.wincom.actor.adaptor.compmgr.Port;

public class Test2Actor extends AbstractActor {

	public static String ID = "test.component.actors.test2";
	public static String DATA_OUTPUT = "data-output";
	public static String ERROR_OUTPUT = "error-output";
	
	private Map<String, Port> outputs = new HashMap<String, Port>();

	public Test2Actor() {
		outputs.put(DATA_OUTPUT, new OutputPort());
		outputs.put(ERROR_OUTPUT, new OutputPort());
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
