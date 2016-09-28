package com.ssa.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ComponentScan(basePackages={"com.ssa"})

public class WebsiteController {
	
	ArrayList<String> helpMessages; 
	
	@RequestMapping("/")
    public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
        if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
        }
        mv.setViewName("home");
        return mv;
    }
	@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
//        if(request.getParameter("name") != null){
//          mv.addObject("name", request.getParameter("name"));
//       }
        mv.setViewName("about");
        return mv;
    }
	
	@RequestMapping("/help")
    public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
        if(request.getParameter("id") != null){
            mv.addObject("id", request.getParameter("id"));
            mv.addObject("description", helpMessages.get(Integer.parseInt(request.getParameter("id"))));
        }
        mv.setViewName("help");
        return mv;
	}
	
	public WebsiteController() {
		this.helpMessages = new ArrayList<String>(
				Arrays.asList("Don't stand under trees in a lightning storm! ", 
						"If she asks how much you make on a first date...RUN!", 
						"For actual help contact a psychiatrist!", 
						"Turn it off and turn it back on. For real it always works!", 
						"Don't ask for help!"));
	}
	}	


