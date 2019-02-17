package framgia.co.edu.ftrr.entity;
// Generated Feb 12, 2019 2:57:27 PM by Hibernate Tools 5.1.10.Final

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Users generated by hbm2java
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users", catalog = "FTRR")
public class User implements java.io.Serializable {

	private Integer id;
	private String email;
	private String code;
	private String name;
	private String division;
	private String phone;
	private String gender;
	private String role;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String encryptedPassword;
	private String resetPasswordToken;
	private Timestamp resetPasswordSentAt;
	private Timestamp rememberCreatedAt;
	private String confirmationToken;
	private Timestamp confirmationAt;
	private Timestamp confirmationSentAt;

	public User() {
	}

	public User(String email, String code, String name, String division, String phone, String gender, String role, Timestamp createdAt, Timestamp updatedAt,
			String encryptedPassword, String resetPasswordToken, Timestamp resetPasswordSentAt, Timestamp rememberCreatedAt,
			String confirmationToken, Timestamp confirmationAt, Timestamp confirmationSentAt) {
		this.email = email;
		this.code = code;
		this.name = name;
		this.division = division;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.encryptedPassword = encryptedPassword;
		this.resetPasswordToken = resetPasswordToken;
		this.resetPasswordSentAt = resetPasswordSentAt;
		this.rememberCreatedAt = rememberCreatedAt;
		this.confirmationToken = confirmationToken;
		this.confirmationAt = confirmationAt;
		this.confirmationSentAt = confirmationSentAt;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email", length = 225)
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email) {
		this.email= email;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "division", length = 45)
	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "gender", length = 6)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "role", length = 2)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "created_at", length = 19)
	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updated_at", length = 19)
	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "encrypted_password", length = 45)
	public String getEncryptedPassword() {
		return this.encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	@Column(name = "reset_password_token", length = 45)
	public String getResetPasswordToken() {
		return this.resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Column(name = "reset_password_sent_at", length = 19)
	public Timestamp getResetPasswordSentAt() {
		return this.resetPasswordSentAt;
	}

	public void setResetPasswordSentAt(Timestamp resetPasswordSentAt) {
		this.resetPasswordSentAt = resetPasswordSentAt;
	}

	@Column(name = "remember_created_at", length = 19)
	public Timestamp getRememberCreatedAt() {
		return this.rememberCreatedAt;
	}

	public void setRememberCreatedAt(Timestamp rememberCreatedAt) {
		this.rememberCreatedAt = rememberCreatedAt;
	}

	@Column(name = "confirmation_token", length = 45)
	public String getConfirmationToken() {
		return this.confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	@Column(name = "confirmation_at", length = 19)
	public Timestamp getConfirmationAt() {
		return this.confirmationAt;
	}

	public void setConfirmationAt(Timestamp confirmationAt) {
		this.confirmationAt = confirmationAt;
	}

	@Column(name = "confirmation_sent_at", length = 19)
	public Timestamp getConfirmationSentAt() {
		return this.confirmationSentAt;
	}

	public void setConfirmationSentAt(Timestamp confirmationSentAt) {
		this.confirmationSentAt = confirmationSentAt;
	}

}
