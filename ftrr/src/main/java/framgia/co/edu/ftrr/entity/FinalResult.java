package framgia.co.edu.ftrr.entity;
// Generated Feb 12, 2019 2:57:27 PM by Hibernate Tools 5.1.10.Final

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

/**
 * FinalResults generated by hbm2java
 */
@Entity
@Table(name = "final_results", catalog = "FTRR")
public class FinalResult implements java.io.Serializable {

	private int traineeForRequestId;
	private TraineeForRequest traineeForRequest;
	private User user;
	private String result;
	private Date createdAt;
	private Date updatedAt;
	private PlanResource planResource;

	public FinalResult() {
	}

	public FinalResult(TraineeForRequest traineeForRequest) {
		this.traineeForRequest = traineeForRequest;
	}

	public FinalResult(TraineeForRequest traineeForRequest, User user, String result, Date createdAt,
			Date updatedAt, PlanResource planResource) {
		this.traineeForRequest = traineeForRequest;
		this.user = user;
		this.result = result;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.planResource = planResource;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "traineeForRequests"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "trainee_for_request_id", unique = true, nullable = false)
	public int getTraineeForRequestId() {
		return this.traineeForRequestId;
	}

	public void setTraineeForRequestId(int traineeForRequestId) {
		this.traineeForRequestId = traineeForRequestId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public TraineeForRequest getTraineeForRequests() {
		return this.traineeForRequest;
	}

	public void setTraineeForRequests(TraineeForRequest traineeForRequest) {
		this.traineeForRequest = traineeForRequest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	public User getUsers() {
		return this.user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

	@Column(name = "result")
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 19)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "finalResults")
	public PlanResource getPlanResources() {
		return this.planResource;
	}

	public void setPlanResources(PlanResource planResource) {
		this.planResource = planResource;
	}

}