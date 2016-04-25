package bajor.lukasz.controller;

import bajor.lukasz.model.Station;
import bajor.lukasz.model.dao.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lbajor on 2016-04-19.
 */
@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    StationRepository repository;

    @RequestMapping("/search/{name}")
    public List<Station> searchStation(@PathVariable String name) {
        List<Station> result = repository.findByNameLike("%" + name + "%");
        return result;
    }
}
