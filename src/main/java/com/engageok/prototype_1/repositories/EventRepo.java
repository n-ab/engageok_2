package com.engageok.prototype_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.engageok.prototype_1.models.Event;

public interface EventRepo extends CrudRepository<Event, Long> {
	public List<Event> findAll();
	public Event save(Event e);
	public Event findOne(Long id);
}