package ek.osnb.demo.todosapp.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void ofShouldPopulateFields() {
        Address address = Address.of("Main St", "Copenhagen", "2100", "Denmark");

        assertAll(
                () -> assertEquals("Main St", address.street()),
                () -> assertEquals("Copenhagen", address.city()),
                () -> assertEquals("2100", address.zipCode()),
                () -> assertEquals("Denmark", address.country())
        );
    }

    @Test
    void ofShouldRejectBlankStreetOrCity() {
        assertThrows(IllegalArgumentException.class, () -> Address.of(null, "Copenhagen", "2100", "Denmark"));
        assertThrows(IllegalArgumentException.class, () -> Address.of("   ", "Copenhagen", "2100", "Denmark"));
        assertThrows(IllegalArgumentException.class, () -> Address.of("Main St", null, "2100", "Denmark"));
        assertThrows(IllegalArgumentException.class, () -> Address.of("Main St", "   ", "2100", "Denmark"));
    }
}
