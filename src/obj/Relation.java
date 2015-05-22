package obj;

import javax.persistence.*;

/**
 * Created by Stephen on 2015/05/19.
 * Ver 1.0
 */

@Entity
@Table(name = "relation")
public class Relation {

    private int relationid;
    private int superiorid;
    private int subordinateid;

    @Id
    @GeneratedValue
    @Column(name = "relationid")
    public int getRelationid() {
        return relationid;
    }

    public void setRelationid(int relationid) {
        this.relationid = relationid;
    }

    @Basic
    @Column(name = "superiorid")
    public int getSuperiorid() {
        return superiorid;
    }

    public void setSuperiorid(int superiorid) {
        this.superiorid = superiorid;
    }

    @Basic
    @Column(name = "subordinateid")
    public int getSubordinateid() {
        return subordinateid;
    }

    public void setSubordinateid(int subordinateid) {
        this.subordinateid = subordinateid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relation)) return false;

        Relation relation = (Relation) o;

        if (relationid != relation.relationid) return false;
        if (superiorid != relation.superiorid) return false;
        return subordinateid == relation.subordinateid;

    }

    @Override
    public int hashCode() {
        int result = relationid;
        result = 31 * result + superiorid;
        result = 31 * result + subordinateid;
        return result;
    }
}
