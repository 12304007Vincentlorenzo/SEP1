package obj;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */
@Entity
@Table(name = "permissionindividual")
@PrimaryKeyJoinColumn(name = "permissionid")
public class PermissionIndividual extends Permission {

    private int employeeID;
    private Date startTime;
    private Date endTime;

    @Basic
    @Column(name = "employeeid")
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "starttime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endtime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissionIndividual)) return false;
        if (!super.equals(o)) return false;

        PermissionIndividual that = (PermissionIndividual) o;

        if (employeeID != that.employeeID) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        return !(endTime != null ? !endTime.equals(that.endTime) : that.endTime != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + employeeID;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
