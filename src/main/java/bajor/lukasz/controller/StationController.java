package bajor.lukasz.controller;

import bajor.lukasz.model.Station;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lbajor on 2016-04-19.
 */
@RestController
public class StationController {
    @RequestMapping("/stations")
    public Station station(@RequestParam(value="name") String name) {
        return new Station(1, "Test");
    }
}
