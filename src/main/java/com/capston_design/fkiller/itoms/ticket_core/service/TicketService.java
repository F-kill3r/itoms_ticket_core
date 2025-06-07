package com.capston_design.fkiller.itoms.ticket_core.service;

import com.capston_design.fkiller.itoms.ticket_core.client.IncidentClient;
import com.capston_design.fkiller.itoms.ticket_core.client.UserServiceClient;
import com.capston_design.fkiller.itoms.ticket_core.client.dto.response.AcceptorInfoResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.client.dto.response.CreatorInfoResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.common.util.ClockUtils;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.request.*;
import com.capston_design.fkiller.itoms.ticket_core.common.ticket_status.annotation.UpdateTicketStatus;
import com.capston_design.fkiller.itoms.ticket_core.controller.dto.response.TicketInfoResponseDTO;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.Ticket;
import com.capston_design.fkiller.itoms.ticket_core.domain.entity.TicketStatus;
import com.capston_design.fkiller.itoms.ticket_core.repository.TicketRepository;
import com.capston_design.fkiller.itoms.ticket_core.service.dto.error.TicketCompletedEvent;
import com.capston_design.fkiller.itoms.ticket_core.service.event.RestTicketEventListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.capston_design.fkiller.itoms.ticket_core.common.exception.BaseException.createBaseExceptionWithoutDetail;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

    private final RestTicketEventListener restTicketEventListener;
    private final TicketRepository ticketRepository;
    private final UserServiceClient userServiceClient;

    @UpdateTicketStatus(ticketStatus = TicketStatus.REQUEST_CREATE_TICKET)
    @Transactional
    public UUID createTicket(CreateTicketRequestDTO request){

        Ticket initTicket = Ticket.ofCreateBaseTicket(request.getIncidentId(),
                request.getRequester().getRequesterId(),
                request.getRequester().getRequesterName());

        // 임시로 담당자 랜덤 할당 -> 이후에 모델에게 요청하는 로직으로 변경
        CreatorInfoResponseDTO randomCreatorInfo = userServiceClient.getRandomCreatorInfo().getResult();
        initTicket.updateCreator(randomCreatorInfo.getId(), randomCreatorInfo.getName());

        return ticketRepository.save(initTicket).getId();
    }
    // 임시로 작업자 랜덤 할당 test code
    @UpdateTicketStatus(ticketStatus = TicketStatus.PENDING_EXECUTION)
    @Transactional
    public void assignAcceptor(UUID ticketId) {
        // 티켓 조회
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST,
                        "유효하지 않은 티켓을 요청하였습니다"));

        // 랜덤 작업자 할당
        AcceptorInfoResponseDTO randomChargerInfo = userServiceClient.getRandomChargerInfo().getResult();
        ticket.updateAcceptor(randomChargerInfo.getId(), randomChargerInfo.getName());

        // 저장
        ticketRepository.save(ticket);
    }

    // 실제 담당자가 작업자 할당 시 사용 코드
    @UpdateTicketStatus(ticketStatus = TicketStatus.PENDING_EXECUTION)
    @Transactional
    public void assignAcceptor(UUID ticketId, AssignAcceptorRequestDTO dto) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST,
                        "유효하지 않은 티켓을 요청하였습니다"));

        ticket.updateAcceptor(dto.getAcceptorId(), dto.getAcceptorName());
        ticketRepository.save(ticket);
    }

    @UpdateTicketStatus(ticketStatus = TicketStatus.COMPLETE_ASSIGN_CREATOR)
    @Transactional
    public void assignHandler(AssignmentCallbackDTO dto) {
        UUID ticketId = dto.getTicketId();

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST,
                        "유효하지 않은 티켓을 요청하였습니다"));
        ticket.updateCreator(dto.getCreatorId(), dto.getCreatorName());
        ticketRepository.save(ticket);
    }

    @Transactional
    public void updateTicketInfo(UUID ticketId, UpdateTicketInfoRequestDTO request) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST,
                        "유효하지 않은 티켓을 요청하였습니다"));
        ticket.updateTicketInfo(request.getTicketName(), request.getTicketContent());
        ticketRepository.save(ticket);
    }

    public List<TicketInfoResponseDTO> findTicketsByAcceptorId(String acceptorId) {
        List<Ticket> tickets = ticketRepository.findTicketsByAcceptorId(acceptorId);
        return tickets.stream()
                .map(TicketInfoResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateTicketStatus(completeTicketRequestDTO request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId())
                .orElseThrow(() -> createBaseExceptionWithoutDetail(
                        HttpStatus.BAD_REQUEST,"유효하지 않은 티켓을 요청하였습니다"));
        ticket.updateTicketStatus(TicketStatus.fromCodeName(request.getTicketStatus()));
        ticket.markClosedAt(ClockUtils.parseToLocalDateTime(request.getCompletionTime()));
        ticketRepository.save(ticket);
        restTicketEventListener.handleTicketCompletedEvent(
                new TicketCompletedEvent(ticket.getId(), ticket.getIncidentId())
        );

        log.info("[티켓 완료 요청] - ticketId={}, ticketName={}, ticketNowStatus={}, [request time] - {}",
                request.getTicketId(), request.getTicketName(), request.getTicketStatus(), request.getCompletionTime());
    }
}
