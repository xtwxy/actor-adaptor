package com.wincom.actor.adaptor.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wincom.actor.adaptor.messages.ActorType;
import com.wincom.actor.adaptor.messages.Components;
import com.wincom.actor.adaptor.messages.PortNameList;

@Path("components")
public class ComponentsResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{aggregateId}")
    public Response get(@PathParam("aggregateId") String aggregateId) {
    	Components c = new Components();
    	for(int i = 0; i < 5; ++i) {
    		ActorType e = new ActorType();
    		e.setInput("input");
    		e.setName("TestComponent-" + i);
    		e.setTypeid("com.wincom.actor.authorization_1.0" + i);
    		
    		PortNameList pnl = new PortNameList();
    		pnl.getPort().add("output-1");
    		pnl.getPort().add("output-2");
			e.setOutput(pnl);
    		
			c.getActorTypes().getActorType().add(e);
    	}
        return Response.ok().entity(c).build();
    }
}
