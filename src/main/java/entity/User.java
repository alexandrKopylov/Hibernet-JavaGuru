package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name ="users")
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;


    @Convert (converter = BirthdayConverter.class)
    @Column (name = "birth_date")
    private Birthday birthDate;

    @Enumerated (EnumType.STRING)
    private Role role;
}
