package com.capston_design.fkiller.itoms.ticket_core.controller;
import com.capston_design.fkiller.itoms.ticket_core.common.service.ClockHolder;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignmentCallbackDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.completeTaskRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/callback")
@RequiredArgsConstructor
public class TicketCallbackController
{
    private final TicketService ticketService;
    private final ClockHolder clockHolder;

    @PostMapping("/assign-handler")
    public ResponseEntity<Void> handleAssigneeUpdate(@RequestBody AssignmentCallbackDTO dto) {
        ticketService.assignHandler(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/task/{taskId}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable UUID taskId, @RequestBody completeTaskRequestDTO request) {
        log.info("[태스크 완료 요청] - taskId={}, taskId={}, taskName={} [request time] - {}", request.getTicketId(),
                taskId, request.getTaskName(), request.getCompletionTime());
        return ResponseEntity.noContent().build();
    }
}
