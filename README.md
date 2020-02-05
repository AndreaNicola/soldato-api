# soldato-api

This is a simple Springboot project for a REST API

In this application you can find examples of:
1. A simple CRUD Rest Spring Controller
2. Incapsulated business logic (a little anemic in this case) in service classes, decoupled from controllers using Inversion Of Control
3. JPA Entities
4. Springdata JPA Repositories
5. Validation of request bodies using Hibernate Validator
6. H2 on memory/file database for fast develop!
7. A simple markdown file!

## Controllers

A controller is implemented (here, in this project) in 2 Java files:
* The interface
* The concrete class

### The interface

In this project i used the interface only to define the paths of my API. It's really easy to start a new project just by shaping the endpoints of the API. Try to keep i'n mind that often you're not the only one consuming it! Keep it predictable and use conventional paths and http methods!

```Java
@RequestMapping("corsi")
public interface CorsoController {

  @GetMapping
  Collection<Corso> list();

  @GetMapping("{id}")
  ResponseEntity<Corso> findById(@PathVariable UUID id);
  
  ...
  
}
```

Map a rest controller using plural nouns of the entities you're going to expose and be coherent with HTTP methods. i.e.:
* GET - return a list or a single entity
* POST - create a new entity
* DELETE - delete an entity
* PUT - rewrite an existing entity


### The concrete rest controller!

I usually use this tier of the application to:
* validate request bodies
* decouple service from controllers using dependency injection
* manipulate service results to produce a better output for the consumer of the service (eventually)

## Services

## Entities

## Repositories

## Validations
