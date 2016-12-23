package com.wincom.actor.adaptor.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("aggregates")
public class AggregateResource {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/")
	public Response getRoot() {
		log.info("");
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{parentId}")
	public Response getChildren(@PathParam("parentId") String parentId) {
		log.info(parentId);
		return Response.ok().build();
	}
}
