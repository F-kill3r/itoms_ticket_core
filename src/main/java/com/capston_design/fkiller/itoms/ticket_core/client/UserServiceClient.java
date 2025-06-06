package com.capston_design.fkiller.itoms.ticket_core.client;

import com.capston_design.fkiller.itoms.ticket_core.client.dto.response.CommonResponse;
import com.capston_design.fkiller.itoms.ticket_core.client.dto.response.CreatorInfoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", url = "http://localhost:8083/api/user")
public interface UserServiceClient {

    @GetMapping("/randomCreator")
    CommonResponse<CreatorInfoResponseDTO> getRandomCreatorInfo();
}
