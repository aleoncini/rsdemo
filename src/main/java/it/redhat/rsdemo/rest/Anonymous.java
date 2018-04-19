package it.redhat.rsdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/free")
public class Anonymous {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response info(@Context HttpHeaders requestHeaders){
        return Response.status(200).entity(headersList(requestHeaders).toString()).build();
    }

    private String headersList(HttpHeaders requestHeaders){
        boolean isFirstIteration = true;
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"request headers\": {");
        for (String key : requestHeaders.getRequestHeaders().keySet()) {
            String value = requestHeaders.getHeaderString(key);
            if (isFirstIteration){
                isFirstIteration = false;
            } else {
                sb.append(", ");
            }
            sb.append("\"").append(key).append("\":\"").append(value).append("\"");
        }
        sb.append("} }");
        return sb.toString();
    }

}
