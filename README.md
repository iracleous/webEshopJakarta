recods

builder

asynchronous and concurrent


dto <-> domain <-> model

mapping
crud

Domain
        persons
            *person
                personal
                addresses
                    *address
                projects
                    ^project



@Stateless (EJB Context) is an annotation from the Enterprise Java Beans (EJB) specification.
@RequestScoped (CDI Context) is an annotation from the Contexts and Dependency Injection (CDI) specification.

Key Differences

Contexts
Servlet Context, Servlet Request Context, Session Context,  Application Context
Transaction Context, Conversation Context, WebSocket Context
 Request-Scoped and Application-Scoped Annotations