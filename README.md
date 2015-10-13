This sample project shows an incompatibility between Spring LDAP 2.0.4.RELEASE
and Spring Data Rest 2.4.0.RELEASE (Gosling).

To reproduce the error simple clone the project and invoke:

`mvn spring-boot:run`

The application will fail at startup with

`org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.data.rest.core.mapping.ResourceMappings]: Factory method 'resourceMappings' threw exception; nested exception is java.lang.IllegalArgumentException: PersistentEntity must not be null!`

When starting with

`mvn -Pfowler spring-boot:run`

everything is just working as expected.

NOTE: It is not necessary to have a LDAP server running. The exception occurs
before the first connection is made.
