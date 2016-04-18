package bajor.lukasz.model;

/**
 * Created by lbajor on 2016-04-19.
 */
public class Station {
    private final long id;
    private final String name;

    public Station(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
