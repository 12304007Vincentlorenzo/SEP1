package obj;

import javax.persistence.*;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */
@Entity
@Table(name = "permissionglobal")
@PrimaryKeyJoinColumn(name = "permissionid")
public class PermissionGlobal extends Permission {

    private String repeatDays;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    @Basic
    @Column(name = "repeatdays")
    public String getRepeatDays() {
        return repeatDays;
    }

    public void setRepeatDays(String repeatDays) {
        this.repeatDays = repeatDays;
    }

    @Basic
    @Column(name = "starthour")
    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    @Basic
    @Column(name = "startminute")
    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    @Basic
    @Column(name = "endhour")
    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    @Basic
    @Column(name = "endminute")
    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissionGlobal)) return false;
        if (!super.equals(o)) return false;

        PermissionGlobal that = (PermissionGlobal) o;

        if (startHour != that.startHour) return false;
        if (startMinute != that.startMinute) return false;
        if (endHour != that.endHour) return false;
        if (endMinute != that.endMinute) return false;
        return !(repeatDays != null ? !repeatDays.equals(that.repeatDays) : that.repeatDays != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (repeatDays != null ? repeatDays.hashCode() : 0);
        result = 31 * result + startHour;
        result = 31 * result + startMinute;
        result = 31 * result + endHour;
        result = 31 * result + endMinute;
        return result;
    }
}
