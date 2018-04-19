package it.redhat.rsdemo.rest;

import it.redhat.rsdemo.model.ResponseInfo;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class Resource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("public")
    public Response getPublic(@Context HttpHeaders header, @Context HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return Response.status(200).entity(new ResponseInfo().setMessage("PUBLIC").toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("secured")
    public Response getSecured() {
        return Response.status(200).entity(new ResponseInfo().setMessage("SECURED").toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    public Response getAdmin() {
        return Response.status(200).entity(new ResponseInfo().setMessage("ADMIN").toString()).build();
    }

}
