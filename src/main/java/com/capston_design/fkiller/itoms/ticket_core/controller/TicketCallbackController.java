package com.capston_design.fkiller.itoms.ticket_core.controller;
import com.capston_design.fkiller.itoms.ticket_core.common.service.ClockHolder;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignmentCallbackDTO;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.completeTaskRequestDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
        ticketService.completeTask(taskId, request, clockHolder.now());
        return ResponseEntity.ok().build();
    }
}
