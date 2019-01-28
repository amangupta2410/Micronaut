package micro.naut.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
@Entity(name = "role")
@Table(name="role")
public class Role extends AbstractEntity<Long> {

	private static final long serialVersionUID = -6702147773381635593L;

	@Column(name="role_name")
	private String name;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean enabled;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean editable;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean deleted;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean expired;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

	@Override
	public String toString() {
		return "Role{" +
				"name='" + name + '\'' +
				", enabled=" + enabled +
				", editable=" + editable +
				", deleted=" + deleted +
				", expired=" + expired +
				'}';
	}
}