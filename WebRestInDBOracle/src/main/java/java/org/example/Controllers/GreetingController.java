package org.example.Controllers;

import org.example.model.Player;
import org.example.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.services.ServicePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(ServicePlayer.class);
    @Autowired
    private ServicePlayer servicePlayer;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="empty") String name, Model model) {
        name="";
        List<Player> players= this.servicePlayer.listPlayers();
        for(Player player:players){
            name+="Player-"+player.getName()+" Number-"+player.getNum().toString()+" ";
        }
        logger.info("Runtume"+name);
        model.addAttribute("name",name);
        return "greeting";
    }
    @GetMapping("/test")
    public String test(@RequestParam(name="name", required=false, defaultValue="dsfsdf") String name, Model model) {
        try{

        Team team= this.servicePlayer.findTeamByID(Integer.parseInt(name));
        List<Player> playerList=this.servicePlayer.findPlayersByTeam(team);
            for (Player player:playerList
                 ) {
                name+="Player-"+player.getName()+" Number-"+player.getNum().toString()+" ";

            }
        name="FC- " +team.getName()+": "+name;

        logger.info("Runtume"+name);
        model.addAttribute("name",name);
        return "greeting";
       }
        catch (Exception e){
            model.addAttribute("name","Error invoke DB"+e.toString());
            return "greeting";
        }
    }

}
