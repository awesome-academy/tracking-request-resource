package framgia.co.edu.ftrr.controller.edu;

import framgia.co.edu.ftrr.dto.request.TraineeForRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("EcTraineeForRequestController")
@RequestMapping("/edu/traineeforrequests")
public class TraineeForRequestController extends EduController {
    private static final Logger logger = LoggerFactory.getLogger(TraineeForRequestController.class);

    @PostMapping
    @PreAuthorize("@roleServiceImpl.isEc()")
    public ResponseEntity<TraineeForRequestDTO> createTraineeForRequest(@RequestBody TraineeForRequestDTO traineeForRequest) {
        try {
            TraineeForRequestDTO traineeForRequestDTO = getTraineeForRequestService().saveTraineeForRequest(traineeForRequest);
            return traineeForRequestDTO == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                    : new ResponseEntity<>(traineeForRequestDTO, HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //EC get list trainee added to review by trainer and waiting confirm
    @GetMapping("/waiting")
    @PreAuthorize("hasRole('EC')")
    public ResponseEntity<List<TraineeForRequestDTO>> getWaitingConfirmTraineeForRequests() {
        try {
            return new ResponseEntity<>(getTraineeForRequestService().getWaitingTraineeForRequests(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //EC confirm only trainee for request by request id form waiting confirm to processing
    @PutMapping("/{requestId}/confirm")
    @PreAuthorize("hasRole('EC')")
    public ResponseEntity<List<TraineeForRequestDTO>> confirmTraineeForRequest(@PathVariable("requestId") Integer requestId) {
        try {
            return new ResponseEntity<>(getTraineeForRequestService()
                    .confirmTraineeForRequestsByRequestId(requestId), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
