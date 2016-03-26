package net.apispark.webapi.resource;

import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.io.IOException;
import java.util.UUID;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface ClassResource {

    @Post()
    public String getClassName(Representation r) throws IOException;

    @Get
    public String getArrayName() throws IOException;
}

