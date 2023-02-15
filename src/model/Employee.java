package model;

import java.time.LocalDate;

public class Employee extends Personal{
    private long id;
    private String department;
    private String position;
    private long salary;
    private String createDate;
    private String updateDate;

    public Employee(long id ,String name, String surname, LocalDate  birthday,String department, String position, long salary,String createDate ,String updateDate )
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


    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSurname: " + getSurname() +
                "\nBirthday :" + getBirthday() +
                "\nDepartment: " + getDepartment() +
                "\nPosition: " + getPosition() +
                "\nSalary: " + getSalary() +
                "\n" + getCreateDate() +
                "\nUpdate Date: " + getUpdateDate() ;

    }
}
