package ek.osnb.demo.todosapp.user;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
        String street,
        String city,
        String zipCode,
        String country
) {
    public Address {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be blank");
        }

        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be blank");
        }
    }

    public static Address of(
            String street,
            String city,
            String zipCode,
            String country
    ) {
        return new Address(street, city, zipCode, country);
    }
}
