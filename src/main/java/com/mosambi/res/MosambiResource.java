package com.mosambi.res;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.mosambi.common.Saying;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vishwanath.s on 10/02/15.
 *
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MosambiResource
{
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MosambiResource(String template, String defaultName)
    {
        this.template = template;
        this.defaultName = defaultName;
        counter = new AtomicLong();
    }

    @GET
    public Saying sayHello(@QueryParam("name") Optional<String> name)
    {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
