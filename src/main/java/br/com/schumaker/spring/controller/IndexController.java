package br.com.schumaker.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hudsonschumaker
 */
@RestController
public class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getText(){
        return "Endpoint inicial";
    }
}