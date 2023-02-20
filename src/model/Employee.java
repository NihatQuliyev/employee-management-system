package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee extends Personal{
    private long id;
    private String department;
    private String position;
    private long salary;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Employee(long id ,String name, String surname, LocalDate  birthday,String department, String position, long salary,LocalDateTime createDate ,LocalDateTime updateDate )
    {
        super(name, surname, birthday);
        this.id=id;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Employee()
    {
        ++this.id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }


    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Name: " + getName()+
                "\nSurname: " + getSurname() +
                "\nBirthday:  " + getBirthday() +
                "\nDepartment: " + getDepartment() +
                "\nPosition: " + getPosition() +
                "\nSalary: " + getSalary() +
                "\nCreate Date: "  + getCreateDate() +
                "\nUpdate Date: " + getUpdateDate() ;
    }
}
