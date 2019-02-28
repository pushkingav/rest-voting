package ru.restaurants.restvoting.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {
    //TODO - migrate "name" to "email"
    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty
    protected String name;

    @Column(name = "email", nullable = false, unique = false)
    @NotEmpty
    protected String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Size(min = 5, max = 100)
    protected String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    protected List<Vote> votes;

    public User() {
    }

    public User(String name, String password, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = EnumSet.of(role, roles);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password=<PROTECTED>" +
                ", id=" + id +
                "} " + super.toString();
    }
}
