package com.capston_design.fkiller.itoms.ticket_core.controller;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.AssignmentCallbackDTO;
import com.capston_design.fkiller.itoms.ticket_core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/callback")
@RequiredArgsConstructor
public class TicketCallbackController
{
    private final TicketService ticketService;

    @PostMapping("/assign-handler")
    public ResponseEntity<Void> handleAssigneeUpdate(@RequestBody AssignmentCallbackDTO dto) {
        ticketService.assignHandler(dto);
        return ResponseEntity.ok().build();
    }
}
