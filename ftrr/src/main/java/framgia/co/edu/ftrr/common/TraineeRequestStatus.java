package framgia.co.edu.ftrr.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TraineeRequestStatus {
    REJECT(1, "Reject"),
    WAITING_CONFIRM(2, "Waiting confirm"),
    PROCESSING(3, "Processing"),
    FINISH(4, "Finish"),
    OTHER(5, "Other");

    private Integer code;
    private String value;

    TraineeRequestStatus(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonValue
    public Integer getCode() {
        return this.code;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }
}
