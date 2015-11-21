package com.jcze.uxpointer.api;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.jcze.uxpointer.models.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/document")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DocumentResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Document sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Document(counter.incrementAndGet(), value);
    }
}