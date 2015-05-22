package obj;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */
@Entity
@Table(name = "attendancelog")
public class AttendanceLog {

    private int logid;
    private int employeeid;
    private Date entrydate;
    private int logcode;

    @Id
    @GeneratedValue
    @Column(name = "logid")
    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    @Basic
    @Column(name = "employeeid")
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "entrydate")
    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    @Basic
    @Column(name = "logcode")
    public int getLogcode() {
        return logcode;
    }

    public void setLogcode(int logcode) {

        this.logcode = logcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceLog)) return false;

        AttendanceLog that = (AttendanceLog) o;

        if (logid != that.logid) return false;
        if (employeeid != that.employeeid) return false;
        if (logcode != that.logcode) return false;
        return !(entrydate != null ? !entrydate.equals(that.entrydate) : that.entrydate != null);

    }

    @Override
    public int hashCode() {
        int result = logid;
        result = 31 * result + employeeid;
        result = 31 * result + (entrydate != null ? entrydate.hashCode() : 0);
        result = 31 * result + logcode;
        return result;
    }
}
