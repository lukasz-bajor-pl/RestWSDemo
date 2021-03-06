package bajor.lukasz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lbajor on 2016-04-19.
 */
@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    protected Station() {}

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
