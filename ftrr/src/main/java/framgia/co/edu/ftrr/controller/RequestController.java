package framgia.co.edu.ftrr.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import framgia.co.edu.ftrr.common.Roles;
import framgia.co.edu.ftrr.dto.request.RequestDTO;
import framgia.co.edu.ftrr.dto.request.UserDTO;
import framgia.co.edu.ftrr.service.RequestService;
import framgia.co.edu.ftrr.service.UserService;
import framgia.co.edu.ftrr.util.ExcelUtils;

@RestController()
@RequestMapping("/requests")
public class RequestController {

	@Autowired
	private RequestService requestService;
	@Autowired
	private UserService userService;
	@Autowired
	private ExcelUtils excelUtils;

	@GetMapping
	public ResponseEntity showRequests(Authentication authentication,
									   @RequestParam(value = "division", required = false) String division,
									   @RequestParam(value = "from", required = false) String from,
									   @RequestParam(value = "to", required = false) String to) {
		UserDTO userDTO = userService.findByEmail(authentication.getName());
		boolean isManager = Roles.M.getValue().equals(userDTO.getRole()) || Roles.SM.getValue().equals(userDTO.getRole());
		boolean isCoordinator = Roles.EC.getValue().equals(userDTO.getRole());

		// Is manager div
		if (isManager)
			return ResponseEntity.status(HttpStatus.OK).body(requestService.findByDivision(userDTO.getDivision().getValue()));

		// Is coordinator
		if (isCoordinator)
			return ResponseEntity.status(HttpStatus.OK).body(requestService.search(division, from, to));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND);
	}

    @PostMapping("/import")
    public ResponseEntity importRequestTrainees(@RequestParam("multipartFile") MultipartFile multipartFile,
                                                HttpServletRequest request) {
        try {
            String uploadRootPath = request.getServletContext().getRealPath("upload");
            JSONObject errors = excelUtils.checkImportRequestTrainees(multipartFile, uploadRootPath);

            // If file import has errors
            if (errors != null && !errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errors);
            }

            requestService.insertListRequest(excelUtils.listRequestFromExcel(multipartFile, uploadRootPath));
            return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

	@PutMapping("/{id}/edit")
	public ResponseEntity<RequestDTO> editRequest(@PathVariable("id") Integer id, @RequestBody RequestDTO requestDTO) {
		RequestDTO requestDTOResult = requestService.editRequest(id, requestDTO);
		if (requestDTOResult == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<RequestDTO>(requestDTOResult, HttpStatus.OK);
		}
	}
	
	@PutMapping("/{id}/confirm")
	public ResponseEntity<RequestDTO> editRequest(@PathVariable("id") Integer id){
		RequestDTO requestDTOResult = requestService.confirmRequest(id);
		if (requestDTOResult == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<RequestDTO>(requestDTOResult, HttpStatus.OK);
		}
	}

}
