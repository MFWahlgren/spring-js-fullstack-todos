package ek.osnb.demo.todosapp.user;

public record UserView(
        Long id,
        String name,
        String username,
        String email,
        AddressView address
) {
    public static UserView from(User user) {
        return new UserView(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                AddressView.from(user.getAddress())
        );
    }
}
