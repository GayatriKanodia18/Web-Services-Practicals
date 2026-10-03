// EventController.java
package com.example.eventmgmt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final List<Event> events = new ArrayList<>();

    public EventController() {
        events.add(new Event(
            1L,
            "Tech Conference",
            "Technology event",
            "2026-10-15",
            "Mumbai"
        ));

        events.add(new Event(
            2L,
            "Music Festival",
            "Live music event",
            "2026-11-20",
            "Pune"
        ));
    }

    // GET /api/events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(events);
    }

    // GET /api/events/2
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return ResponseEntity.ok(event);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // POST /api/events
    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        long newId = events.stream()
                .mapToLong(Event::getId)
                .max()
                .orElse(0) + 1;

        event.setId(newId);
        events.add(event);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(event);
    }

    // PUT /api/events/2
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long id,
            @RequestBody Event updatedEvent) {

        for (Event event : events) {
            if (event.getId().equals(id)) {

                event.setName(updatedEvent.getName());
                event.setDescription(updatedEvent.getDescription());
                event.setDate(updatedEvent.getDate());
                event.setLocation(updatedEvent.getLocation());

                return ResponseEntity.ok(event);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE /api/events/4
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {

        for (Event event : events) {
            if (event.getId().equals(id)) {
                events.remove(event);

                return ResponseEntity.ok(
                        "Event record deleted successfully"
                );
            }
        }

        return ResponseEntity.notFound().build();
    }
}
