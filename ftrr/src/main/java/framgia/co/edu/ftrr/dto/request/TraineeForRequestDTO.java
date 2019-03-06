package framgia.co.edu.ftrr.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import framgia.co.edu.ftrr.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TraineeForRequestDTO implements Serializable {
    private Integer id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "updatedBy", "createdBy", "traineeForRequests"})
    private Request request;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user", "traineeForRequests", "resultTrainings",
            "trainer", "level"})
    private Trainee trainee;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "encryptedPassword", "resetPasswordToken",
            "resetPasswordSentAt", "rememberCreatedAt", "confirmationToken", "confirmationAt", "confirmationSentAt"})
    private User updatedBy;
    @JsonIgnore
    private List<ResultInterview> resultInterviews;
    @JsonIgnore
    private FinalResult finalResult;
}
