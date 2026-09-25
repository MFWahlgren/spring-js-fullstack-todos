package ek.osnb.demo.todosapp.user;

public record CreateUserRequest(
        String name,
        String username,
        String email,
        AddressRequest address
) {
}
