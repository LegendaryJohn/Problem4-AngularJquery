/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.DataFactory;
import model.Member;

/**
 * REST Web Service
 *
 * @author Legendary John
 */
@Path("member")
public class RESTMember
{

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    DataFactory df = new DataFactory();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of webresource
     */
    public RESTMember()
    {
    }

    /**
     * Retrieves representation of an instance of REST.webresource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMembersJson()
    {
        JsonArray jsonArr = new JsonArray();
        List<Member> members = df.getMembers();
            for (Member member : members) {
                 JsonObject obj = new JsonObject();
                 obj.addProperty("id", member.getId());
                 obj.addProperty("age", member.getAge());
                 obj.addProperty("eyeColor", member.getEyeColor());
                 obj.addProperty("name", member.getName());
                 obj.addProperty("email", member.getEmail());

             
            jsonArr.add(obj);
        }
        return gson.toJson(jsonArr);
    }

    /**
     * PUT method for updating or creating an instance of webresource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content)
    {
    }
}
