package ru.restaurants.restvoting;


import ru.restaurants.restvoting.model.User;
import ru.restaurants.restvoting.to.UserTo;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1234L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getName(), user.getPassword(), true, true, true, true, user.getRoles());
        this.userTo = new UserTo(user.getId(), user.getName(), user.getPassword());
    }

    public int getId() {
        return userTo.getId();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }
}