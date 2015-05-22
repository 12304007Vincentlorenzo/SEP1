package obj;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */
@Entity
@Table(name = "employee")
public class Employee {

    private int employeeID;
    private int employeetype;
    private String username;
    private String userpass;
    private String name;
    private int departmentID;
    private char gender;
    private Date DOB;
    private int phone;

    @Id
    @GeneratedValue
    @Column(name = "employeeid")
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "employeetype")
    public int getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(int employeetype) {
        this.employeetype = employeetype;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpass")
    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "departmentid")
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Basic
    @Column(name = "gender")
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "dob")
    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    @Basic
    @Column(name = "phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (employeeID != employee.employeeID) return false;
        if (employeetype != employee.employeetype) return false;
        if (departmentID != employee.departmentID) return false;
        if (gender != employee.gender) return false;
        if (phone != employee.phone) return false;
        if (username != null ? !username.equals(employee.username) : employee.username != null) return false;
        if (userpass != null ? !userpass.equals(employee.userpass) : employee.userpass != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return !(DOB != null ? !DOB.equals(employee.DOB) : employee.DOB != null);

    }

    @Override
    public int hashCode() {
        int result = employeeID;
        result = 31 * result + employeetype;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpass != null ? userpass.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + departmentID;
        result = 31 * result + (int) gender;
        result = 31 * result + (DOB != null ? DOB.hashCode() : 0);
        result = 31 * result + phone;
        return result;
    }
}
