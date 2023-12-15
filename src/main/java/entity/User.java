package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
// @Builder    билдер напишу  сам
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    @Convert(converter = BirthdayConverter.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn (name = "company_id")
    private Company company;

    private User() {
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private User(UserBuilder userBuilder) {
        this.username = userBuilder.username;
        this.firstname = userBuilder.firstname;
        this.lastname = userBuilder.lastname;
        this.birthDate = userBuilder.birthDate;
        this.role = userBuilder.role;
        this.company = userBuilder.company;
    }

    public static class UserBuilder {
        private String username;
        private String firstname;
        private String lastname;
        private Birthday birthDate;
        private Role role;
        private Company company;

        public UserBuilder() {
        }

        public UserBuilder setUserName(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setFirstName(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder setLastName(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder setBirthDate(Birthday birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", role=" + role +
                '}';
    }


}
