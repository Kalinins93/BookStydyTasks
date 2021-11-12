package org.example;

import org.example.services.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication  implements CommandLineRunner {

        @Autowired
        SoccerService soccerService;
        public static void main(String[] args) {
                SpringApplication.run(ServingWebContentApplication.class, args);
        }
        @Override
        public void run(String... arg0) throws Exception {

                soccerService.addBarcelonaPlayer("Xavi Hernandez", "Midfielder", 6);

                List<String> players = soccerService.getAllTeamPlayers(1);
                for(String player : players)
                {
                        System.out.println("Introducing Barca player => " + player);
                }
        }
}