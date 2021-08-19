package com.bluntsoftware.events.service;

import com.bluntsoftware.events.model.Event;
import com.bluntsoftware.events.repository.EventRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EventService{

  private final EventRepo repo;

  public EventService(EventRepo repo) {
    this.repo = repo;
  }

  public  Event save(Event item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Event> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Event> findAll() {
    return repo.findAll();
  }
}
