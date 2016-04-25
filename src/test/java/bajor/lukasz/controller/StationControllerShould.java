package bajor.lukasz.controller;

import bajor.lukasz.Application;
import bajor.lukasz.model.Station;
import bajor.lukasz.model.dao.StationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by lbajor on 2016-04-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class StationControllerShould {
    @Value("${local.server.port}")
    int port;

    @Autowired
    StationRepository repository;

    @Before
    public void beforTest() {
        repository.save(new Station("DARTFORD"));
        repository.save(new Station("DARTMOUTH"));
        repository.save(new Station("TOWER HILL"));
        repository.save(new Station("DERBY"));
        repository.save(new Station("LIVERPOOL"));
        repository.save(new Station("LIVERPOOL LIME STREET"));
        repository.save(new Station("PADDINGTON"));
        repository.save(new Station("EUSTON"));
        repository.save(new Station("LONDON BRIDGE"));
        repository.save(new Station("VICTORIA"));
    }

    private final RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void findDartfordAndDartmouthWhenLookingForDart() {
        ResponseEntity<String> response = restTemplate.getForEntity(searchUrl("DART"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody(), containsString(cleanJson("{\n" +
                "\"stations\": [\n" +
                "{\n" +
                "\"name\": \"DARTFORD\"\n" +
                "},\n" +
                "{\n" +
                "\"name\": \"DARTMOUTH\"\n" +
                "}\n" +
                "]\n" +
                "}")));
    }

    @Test
    public void findAllStationsOnSearchAll() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/stations/searchAll", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody(), containsString("DARTFORD"));
        assertThat(response.getBody(), containsString("DARTMOUTH"));
        assertThat(response.getBody(), containsString("TOWER HILL"));
        assertThat(response.getBody(), containsString("DERBY"));
        assertThat(response.getBody(), containsString("LIVERPOOL"));
        assertThat(response.getBody(), containsString("LIVERPOOL LIME STREET"));
        assertThat(response.getBody(), containsString("PADDINGTON"));
        assertThat(response.getBody(), containsString("EUSTON"));
        assertThat(response.getBody(), containsString("LONDON BRIDGE"));
        assertThat(response.getBody(), containsString("VICTORIA"));
    }

    private String cleanJson(String json) {
        return json.replace("\n", "").replace(" ", "");
    }

    private String searchUrl(final String name) {
        return "http://localhost:" + port + "/stations/search/" + name;
    }
}