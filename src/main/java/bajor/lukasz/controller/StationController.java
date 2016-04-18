package bajor.lukasz.controller;

import bajor.lukasz.model.Station;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lbajor on 2016-04-19.
 */
@RestController
@RequestMapping("/stations")
public class StationController {
    @RequestMapping("/search/{name}")
    public Station searchStation(@PathVariable String name) {
        return new Station(1, "Test");
    }
}
