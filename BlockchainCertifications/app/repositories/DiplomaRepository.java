package repositories;

import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;

import it.unifi.cerm.playmorphia.PlayMorphia;
import models.Diploma;
//import org.hibernate.query.Query;

public class DiplomaRepository {
	private final PlayMorphia morphia;

    @Inject
    public DiplomaRepository(PlayMorphia morphia) {
        this.morphia = morphia;
    }

    /*
     * read form DB
     */
	public Diploma findById(String id) {
        Diploma diploma = morphia.
                datastore().
                createQuery(Diploma.class).
                field("_id").
                equal(new ObjectId(id)).get();
//       List <Diploma> diploma2 = morphia.datastore().createQuery(Diploma.class)
//							        .field("_id").equal(new ObjectId(id))
//							        .find()
//							        .toList();
//        return diploma2.get(0);
        return diploma;
    }

	/*
	 * insert in DB
	 */
    public void save(Diploma d) {
        morphia.datastore().save(d);
    }
}
