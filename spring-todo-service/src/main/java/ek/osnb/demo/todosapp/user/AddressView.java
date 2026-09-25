package ek.osnb.demo.todosapp.user;

public record AddressView(
        String street,
        String city,
        String zipCode,
        String country
) {

    public static AddressView from(Address address) {
        return new AddressView(
                address.street(),
                address.city(),
                address.zipCode(),
                address.country()
        );
    }
}
