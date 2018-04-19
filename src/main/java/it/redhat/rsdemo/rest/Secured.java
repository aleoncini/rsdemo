package it.redhat.rsdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("/secure")
public class Secured {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response info(){
        return Response.status(200).entity("{\"info\":\"[Secured] REsT Service - ver 1.0\"}").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("headers")
    public Response headOfRequest(@Context HttpHeaders requestHeaders){
        return Response.status(200).entity(formatRequest(requestHeaders)).build();
    }

    private String formatRequest(HttpHeaders requestHeaders){
        boolean isFirstIteration = true;
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"HEADERS\": {");
        for (String key : requestHeaders.getRequestHeaders().keySet()) {
            String value = requestHeaders.getHeaderString(key);
            if (isFirstIteration){
                isFirstIteration = false;
            } else {
                sb.append(", ");
            }
            sb.append("\"").append(key).append("\":\"").append(value).append("\"");
        }
        sb.append("}, \"COOKIES\": {");
        isFirstIteration = true;
        for (String cookiename : requestHeaders.getCookies().keySet()) {
            Cookie cookie = requestHeaders.getCookies().get(cookiename);
            if (isFirstIteration){
                isFirstIteration = false;
            } else {
                sb.append(", ");
            }
            sb.append("\"").append(cookiename).append("\":\"").append(cookie.getValue()).append("\"");
        }
        sb.append("} }");
        return sb.toString();
    }
}
