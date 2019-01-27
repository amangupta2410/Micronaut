package micro.naut.entities;

import javax.persistence.*;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User extends AbstractEntity<Long> {

	/*
     *	@PreUpdate
	 *	@PrePersist
	 * */

	private static final long serialVersionUID = -640903593608209562L;

	@Column(name = "username")
	private String username;

	@Column
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role")
	private Role role;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean enabled;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean verified;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean editable;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean deleted;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean expired;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean locked;

	@Column(name = "check_password_history", nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean checkPasswordHistory;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCheckPasswordHistory() {
		return checkPasswordHistory;
	}

	public void setCheckPasswordHistory(boolean checkPasswordHistory) {
		this.checkPasswordHistory = checkPasswordHistory;
	}
}