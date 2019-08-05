package edu.mum.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Home controller.
 *
 * @author nduwayofabrice
 */
@Controller
public class HomeController {

    /**
     * Home string.
     *
     * @return the string
     */
    @GetMapping(path = {"/", "/e-registrar", "/e-registrar/home"})
    public String home() {
        return "index";
    }

}
