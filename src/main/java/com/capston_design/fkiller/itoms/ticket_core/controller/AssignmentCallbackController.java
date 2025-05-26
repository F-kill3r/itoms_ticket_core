package com.capston_design.fkiller.itoms.ticket_core.controller;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignmentCallbackDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/callback")
@RequiredArgsConstructor
public class AssignmentCallbackController
{
    private final TicketAssignmentService ticketAssignmentService;

    @PostMapping("/assign-handler")
    public ResponseEntity<Void> handleAssigneeUpdate(@RequestBody AssignmentCallbackDTO dto) {
        ticketAssignmentService.assignHandler(dto);
        return ResponseEntity.ok().build();
    }
}
