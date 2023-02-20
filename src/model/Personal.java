package model;
import java.time.LocalDate;
public class Personal {
    private String name;
    private String surname;
    private LocalDate birthday;

    public Personal(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Personal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate  birthday) {
        this.birthday = birthday;
    }
}
