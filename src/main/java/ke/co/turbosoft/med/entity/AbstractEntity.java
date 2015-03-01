package ke.co.turbosoft.med.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by akipkoech on 12/8/14.
 */

public abstract class AbstractEntity implements JsonItem,Serializable{

    @Override
    public JsonObject toJson(){
        JsonObjectBuilder builder = Json.createObjectBuilder();
        addJson(builder);
        return builder.build();
    }


}
