package net.apispark.webapi.test;

import net.apispark.webapi.representation.Classes;
import net.apispark.webapi.representation.Keywords;
import net.apispark.webapi.resource.server.ClassServerResource;
import org.json.JSONArray;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexandra on 23.3.16.
 */
public class ClassesResourceTest {
////    @Test
//    public void select() {
//        ClassServerResource cr = new ClassServerResource();
//        List<Classes> list = cr.getAll();
//        for(Classes c : list){
//            System.out.println(c);
//        }
//    }

    @Test
    public void setRequest() {
        ClassServerResource cr = new ClassServerResource();
        JSONArray array = cr.fillArrayJson();
        System.out.println(array.toString());
    }
    }
