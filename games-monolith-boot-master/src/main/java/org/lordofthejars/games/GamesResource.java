package org.lordofthejars.games;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesResource {

    @RequestMapping
    public String getGame() {
       return "Monkey Island"; 
    }

}