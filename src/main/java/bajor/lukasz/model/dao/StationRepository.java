package bajor.lukasz.model.dao;

import bajor.lukasz.model.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lbajor on 2016-04-19.
 */
public interface StationRepository extends CrudRepository<Station, Long> {
    List<Station> findByNameLike(String name);
}
