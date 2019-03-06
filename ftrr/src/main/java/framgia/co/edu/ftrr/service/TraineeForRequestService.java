package framgia.co.edu.ftrr.service;

import framgia.co.edu.ftrr.dto.request.TraineeForRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TraineeForRequestService {
    TraineeForRequestDTO saveTraineeForRequest(TraineeForRequestDTO traineeForRequest);

    List<TraineeForRequestDTO> getWaitingTraineeForRequests();

    List<TraineeForRequestDTO> confirmTraineeForRequestsByRequestId(Integer requestId);
}
