package org.example.Controllers;

import org.example.json.Time;
import org.example.model.Team;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class ApiController {
    @PostMapping("/timesCity")
    String timeByCity(@RequestBody String city) {
        Date date = new Date();
        final String uri = "http://worldtimeapi.org/api/timezone/Europe/Moscow";

        RestTemplate restTemplate = new RestTemplate();

        Time result = restTemplate.getForObject(uri, Time.class);

       String time="Time by location "+ city+ result.toString();
        return time;
    }
}
