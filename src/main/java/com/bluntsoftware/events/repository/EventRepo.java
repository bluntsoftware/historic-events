package com.bluntsoftware.events.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bluntsoftware.events.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {
}