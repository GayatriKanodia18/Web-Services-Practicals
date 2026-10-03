# Web Services – Practical 10

**Name:** Gayatri Kanodia  
**Roll No.:** 31010924802  
**Class:** TYIT  
**Subject:** Web Services (Practical)

## Practical 10

### Aim
To create an Event Management RESTful Web Service using Spring Boot with CRUD operations.

## 1. Event.java

```java
// Event.java
package com.example.eventmgmt;

public class Event {
    private Long id;
    private String name;
    private String description;
    private String date;
    private String location;

    public Event() {
    }

    public Event(Long id, String name, String description, String date, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
```

## 2. EventController.java

The controller uses the base URL:

```text
/api/events
```

### GET – Get All Events

```text
GET /api/events
```

Returns the list of all events.

### GET – Get Event by ID

```text
GET /api/events/{id}
```

Returns a particular event using its ID. If the event is not found, a `404 Not Found` response is returned.

### POST – Add Event

```text
POST /api/events
```

Adds a new event. The controller automatically generates the next event ID and returns the newly created event with `201 Created`.

### PUT – Update Event

```text
PUT /api/events/{id}
```

Updates the name, description, date, and location of an existing event.

### DELETE – Delete Event

```text
DELETE /api/events/{id}
```

Deletes an event and returns:

```text
Event record deleted successfully
```

if the event exists.

## Initial Events

The application contains these two initial events:

| ID | Name | Description | Date | Location |
|---|---|---|---|---|
| 1 | Tech Conference | Technology event | 2026-10-15 | Mumbai |
| 2 | Music Festival | Live music event | 2026-11-20 | Pune |

## Output

### Postman Output 1

![Practical 10 Output 1](p10_output_1.png)

### Postman Output 2

![Practical 10 Output 2](p10_output_2.png)

## Result

The Event Management REST API was implemented using Spring Boot with GET, POST, PUT, and DELETE operations.
