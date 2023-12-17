package entity;

import javax.persistence.*;


@Entity
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

@Column (unique = true, nullable = false)
    private String name;

    public Company() {
    }

    public Company( String name) {
         this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
