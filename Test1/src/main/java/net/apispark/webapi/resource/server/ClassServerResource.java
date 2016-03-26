package net.apispark.webapi.resource.server;

import net.apispark.webapi.representation.Classes;
import net.apispark.webapi.representation.Keywords;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import net.apispark.webapi.resource.ClassResource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ClassServerResource extends AbstractServerResource implements ClassResource {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    // Define allowed roles for the method "post".
    private static final String[] post1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post1DeniedGroups = new String[] {};

    public String getClassName(Representation r) throws IOException {
        checkGroups(post1AllowedGroups, post1DeniedGroups);
        JSONObject jsonObject = new JSONObject();
        try {
            String s = r.getText();
            Keywords keywords = findId(s);
            Classes classes =  findName(keywords.getId());
            jsonObject.put("classname", classes.getClassname());
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
        return jsonObject.toString();
    }

    @Override
    public String getArrayName() throws IOException {
        checkGroups(post1AllowedGroups, post1DeniedGroups);
        JSONArray list = fillArrayJson();
        return list.toString();
    }

    public Classes findName(int id){
    TypedQuery<Classes> namedQuery= em.createNamedQuery("findName", Classes.class);
        namedQuery.setParameter("id", id);
    return namedQuery.getSingleResult();
    }

    public Keywords findId(String keyword){
        TypedQuery<Keywords> typedQuery = em.createNamedQuery("findId", Keywords.class);
        typedQuery.setParameter("keyword", keyword);
        return typedQuery.getSingleResult();
    }

    public JSONArray fillArrayJson(){
        TypedQuery<Classes> list = em.createNamedQuery("getAll", Classes.class);
        List<Classes> cl = list.getResultList();
       JSONArray array  = new JSONArray();
        JSONObject obj = null;
        for(Classes classes: cl){
            obj = new JSONObject();
            obj.put("classname",classes.getClassname());
            array.put(obj);
        }
        return array;
    }
}

