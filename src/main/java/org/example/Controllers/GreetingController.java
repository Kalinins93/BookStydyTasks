package org.example.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.services.ServicePlayer;
import org.example.services.ServicePlayerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(ServicePlayer.class);
    @Autowired
    private ServicePlayer servicePlayer;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="dsfsdf") String name, Model model) {

        model.addAttribute("name",name);
        return "greeting";
    }
    @GetMapping("/test")
    public String test(@RequestParam(name="name", required=false, defaultValue="dsfsdf") String name, Model model) {
      //  try{
        name=this.servicePlayer.findPlayerByID(1).getName();
        logger.info("Runtume"+this.servicePlayer);
        logger.info("Runtume"+name);
        model.addAttribute("name",name);
        return "greeting";
     /*   }
        catch (Exception e){
            model.addAttribute("name","Error invoke DB"+e.toString());
            return "greeting";
        }*/
    }

}
