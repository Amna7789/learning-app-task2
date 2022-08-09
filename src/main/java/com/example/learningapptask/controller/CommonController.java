package com.example.learningapptask.controller;

import com.example.learningapptask.configuration.Trigger;
import com.example.learningapptask.datamodel.Course;
import com.example.learningapptask.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommonController {
    @Autowired
    CommonService commonService;

  /* @RequestMapping(value = "/{name}", method = RequestMethod.GET)
   public Optional<Course> getCourseName(@RequestParam(value="name") String name) {
       return commonService.searchingCourseName(name);
   }*/

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @Trigger(data = "error")
    public Optional<Course> getCourseName(@RequestParam(value="name", required = false) String name,
                                         @RequestParam(value = "id",required = false) String id){
       return null;
   }
}