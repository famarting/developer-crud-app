package io.famargon.developer;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 * DeveloperResource
 */
@Timed(unit = MetricUnits.MILLISECONDS)
@Path("/api/developers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeveloperResource {

    @Inject
    DeveloperService developerService;

    @GET
    public List<Developer> listAll() {
        return developerService.listAll();
    }

    @Path("/{name}")
    @GET
    public Developer getDeveloperByName(@PathParam("name") String name) {
        return Developer.find("name", name).firstResult();
    }

    @POST
    public Developer create(Developer dev) {
        return developerService.create(dev);
    }

    @Path("/{name}")
    @DELETE
    public void delete(@PathParam("name") String name) {
        if(Developer.delete("name", name) == 0) {
            throw new IllegalArgumentException("Developer not exists");
        }
    }
}