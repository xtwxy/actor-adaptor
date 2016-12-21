package messages;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wincom.actor.adaptor.messages.Actor;
import com.wincom.actor.adaptor.messages.Connection;
import com.wincom.actor.adaptor.messages.Diagram;
import com.wincom.actor.adaptor.messages.JaxbContextUtil;
import com.wincom.actor.adaptor.messages.Port;

public class DiagramMarshalTest {

	@Test
	public void test() throws JAXBException {
		Actor actor1 = new Actor("actor1", "actor1");
		Port actor1out1 = new Port(actor1.getId(), "output1");
		Port actor1out2 = new Port(actor1.getId(), "output2");
		actor1.addOutput(actor1out1);
		actor1.addOutput(actor1out2);
		
		Actor actor2 = new Actor("actor2", "actor2");
		Port actor2out1 = new Port(actor2.getId(), "output1");
		actor2.addOutput(actor2out1);
		
		Actor actor3 = new Actor("actor3", "actor3");
		Port actor3out1 = new Port(actor3.getId(), "output1");
		actor3.addOutput(actor3out1);
		
		Diagram diagram = new Diagram();
		diagram.addActor(actor1);
		diagram.addActor(actor2);
		diagram.addActor(actor3);
		diagram.addConnection(new Connection(actor1.getOutput("output1"), actor2.getInput()));
		diagram.addConnection(new Connection(actor1.getOutput("output2"), actor3.getInput()));
		diagram.addConnection(new Connection(actor2.getOutput("output1"), actor3.getInput()));
		
		Marshaller m = JaxbContextUtil.getContext().createMarshaller();
		m.marshal(diagram, System.out);
	}
	
	@Before
	public void setUp() {
		
	}
	@After
	public void tearDown() {
		
	}
}
