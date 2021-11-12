package org.example.Controllers;

import org.example.services.SoccerService;
import org.example.services.SoccerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="but not add in db") String name, Model model) {
        model.addAttribute("name", name);

            SoccerService soccerService= new SoccerServiceImpl();
            soccerService.addBarcelonaPlayer(name, "Midfielder", 6);

            List<String> players = soccerService.getAllTeamPlayers(1);
            for(String player : players)
            {
                System.out.println("Introducing Barca player => " + player);
            }
        return "greeting";
    }

}
