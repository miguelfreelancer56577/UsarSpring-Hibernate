/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.packt.Spring.chapter7.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SPPDF
 */
@Controller
@RequestMapping("/")
public class Login {
    @RequestMapping(method = RequestMethod.GET)
    public String pageIndex(){
        return "index";
    }
}
