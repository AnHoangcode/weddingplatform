package com.fu.weddingplatform.controller;

import com.fu.weddingplatform.constant.Account.AccountSuccessMessage;
import com.fu.weddingplatform.constant.response.ResponseStatusDTO;
import com.fu.weddingplatform.constant.role.RolePreAuthorize;
import com.fu.weddingplatform.response.Account.AccountResponse;
import com.fu.weddingplatform.response.ListResponseDTO;
import com.fu.weddingplatform.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("getAllAccountByAdmin")
    @PreAuthorize(RolePreAuthorize.ROLE_ADMIN)
    public ResponseEntity<ListResponseDTO> getAllAccountByAdmin(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        ListResponseDTO<AccountResponse> responseDTO = new ListResponseDTO();
        List<AccountResponse> list = accountService.getAllUsersByAdmin(pageNo, pageSize);
        responseDTO.setData(list);
        responseDTO.setMessage(AccountSuccessMessage.GET_ALL_ACCOUNT);
        responseDTO.setStatus(ResponseStatusDTO.SUCCESS);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("getAllActivateUsersByAdmin")
    @PreAuthorize(RolePreAuthorize.ROLE_ADMIN)
    public ResponseEntity<ListResponseDTO> getAllActivateUsersByAdmin(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        ListResponseDTO<AccountResponse> responseDTO = new ListResponseDTO();
        List<AccountResponse> list = accountService.getAllActivateUsersByAdmin(pageNo, pageSize);
        responseDTO.setData(list);
        responseDTO.setMessage(AccountSuccessMessage.GET_ALL_ACTIVATE_ACCOUNT);
        responseDTO.setStatus(ResponseStatusDTO.SUCCESS);
        return ResponseEntity.ok().body(responseDTO);
    }

}
