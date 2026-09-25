package ek.osnb.demo.todosapp.user;

public record AddressRequest(
        String street,
        String city,
        String zipCode,
        String country
) {
}
