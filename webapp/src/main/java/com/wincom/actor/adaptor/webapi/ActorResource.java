package com.wincom.actor.adaptor.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wincom.actor.adaptor.messages.Actor;
import com.wincom.actor.adaptor.messages.Connection;
import com.wincom.actor.adaptor.messages.AggregateDiagram;
import com.wincom.actor.adaptor.messages.Port;

@Path("actors")
public class ActorResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getActors() {
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
		
		AggregateDiagram AggregateDiagram = new AggregateDiagram();
		AggregateDiagram.addActor(actor1);
		AggregateDiagram.addActor(actor2);
		AggregateDiagram.addActor(actor3);
		AggregateDiagram.addConnection(new Connection(actor1.getOutput("output1"), actor2.getInput()));
		AggregateDiagram.addConnection(new Connection(actor1.getOutput("output2"), actor3.getInput()));
		AggregateDiagram.addConnection(new Connection(actor2.getOutput("output1"), actor3.getInput()));
		
		return Response.ok().entity(AggregateDiagram).build();
	}
}
