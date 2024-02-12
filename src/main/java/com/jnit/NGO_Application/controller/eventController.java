
package com.jnit.NGO_Application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jnit.NGO_Application.model.event;
import com.jnit.NGO_Application.repository.eventRepository;

import com.jnit.NGO_Application.service.eventService;


public class eventController implements eventService {
 private eventRepository eventRepository;

 public eventController(eventRepository eventRepository) {
     this.eventRepository = eventRepository;
 }

 public event createEvent(String username, String email, String password) {
     event newEvent = new event();
     return eventRepository.save(newEvent);
 }

 public event getEventById(int eventId) {
     return eventRepository.findById(eventId);
 }

// public void updateEvent(event event) {
//     eventRepository.update(event);
// }
//
// public void deleteEvent(int eventId) {
//     eventRepository.delete(eventId);
// }
 @GetMapping("/event")
 public List<event> getEvent() {
 	return eventRepository.findAll();
 }
 @PostMapping("/Event")
 public ResponseEntity<event> createEvent(@RequestBody event newEvent) {
     event createdEvent = eventRepository.save(newEvent);
     return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
 }
}
