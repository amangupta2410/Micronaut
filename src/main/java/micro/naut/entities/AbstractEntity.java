package micro.naut.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Karanbir Singh on 1/27/2019.
**/
@MappedSuperclass()
public class AbstractEntity<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 139815697954615644L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private T id;

    @Column(name="created_on",columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="updated_by", referencedColumnName = "id", columnDefinition = "BIGINT(20)")
    private User updatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="editable_by", referencedColumnName = "id", columnDefinition = "BIGINT(20)")
    private User editableBy;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public User getEditable_by() {
        return editableBy;
    }

    public void setEditable_by(User editableBy) {
        this.editableBy = editableBy;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", editableBy=" + editableBy +
                '}';
    }
}