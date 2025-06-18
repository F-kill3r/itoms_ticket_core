package com.capston_design.fkiller.itoms.ticket_core.client.grpc;

import com.capston_design.fkiller.itoms.user.UserProto;
import com.capston_design.fkiller.itoms.user.UserServiceGrpc;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrpcUserClient {

    private final UserServiceGrpc.UserServiceBlockingStub userClientStub;

    public UserProto.CommonCreatorInfoResponse getRandomCreatorInfo() {
        return userClientStub.getRandomCreatorInfo(Empty.newBuilder().build());
    }
}
