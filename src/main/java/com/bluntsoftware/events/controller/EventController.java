package com.bluntsoftware.events.controller;

import com.bluntsoftware.events.model.Event;
import com.bluntsoftware.events.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

  private final EventService service;

  public EventController(EventService service) {
    this.service = service;
  }

  @PostMapping(value="/event",produces = MediaType.APPLICATION_JSON_VALUE)
  public Event save(@RequestBody Map<String,Object> dto){
    var mapper = new ObjectMapper();
    return this.service.save(mapper.convertValue(dto,Event.class));
  }

  @GetMapping(value = "/event/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Event> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id));
  }

  @GetMapping(value = "/event",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Event> findAll(){
    return this.service.findAll();
  }

  @DeleteMapping(value = "/event/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(String.valueOf(id));
  }
}
