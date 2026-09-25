package ek.osnb.demo.todosapp.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(
            String resource,
            String field,
            Object value
    ) {
        super("%s with %s '%s' already exists"
                .formatted(resource, field, value));
    }
}
