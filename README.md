# Emoji Inclusion

Emoji Inclusion is a simple Spring Boot application that can be used to demonstrate the behavior of an in-memory vs a persistence database with multiple stateless application instances.
It especially works well with ServiceBindings for [Kubernetes](https://servicebinding.io) or [CloudFoundry](https://docs.cloudfoundry.org/devguide/services/application-binding.html).

If you refresh the page with the default in-memory database and multiple running instances, you will see that the emoji is changing, as every instance has its own state.
![](docs/images/in-memory.png)
With an external configured database, you should be able to see multiple emojis, which will stay the same, as all instances share the same state.
![](docs/images/external-db.png)