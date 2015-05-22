package obj;

import javax.persistence.*;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */
@Entity
@Table(name = "permission")
@Inheritance(strategy = InheritanceType.JOINED)
public class Permission {

    private int permissionID;
    private int logcode;

    @Id
    @GeneratedValue
    @Column(name = "permissionid")
    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
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
        if (!(o instanceof Permission)) return false;

        Permission that = (Permission) o;

        if (permissionID != that.permissionID) return false;
        return logcode == that.logcode;

    }

    @Override
    public int hashCode() {
        int result = permissionID;
        result = 31 * result + logcode;
        return result;
    }
}
