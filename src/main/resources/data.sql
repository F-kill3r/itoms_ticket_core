INSERT INTO `ticket` (
    is_deleted, ticket_active, ticket_status_code, accepted_at, created_at, modified_at,
    ticket_plan_duration, ticket_plan_end_date, ticket_plan_start_date,
    incident_id, ticket_id,
    acceptor_id, acceptor_name, closed_at, creator_id, creator_name,
    requester_id, requester_name, ticket_content, ticket_name, ticket_status
) VALUES
-- 1 (김민수)
(b'0', b'1', 3, '2025-06-01 10:00:00.000000', '2025-05-30 09:00:00.000000', '2025-06-01 11:00:00.000000',
 null, null, null,
 UUID_TO_BIN('11111111-1111-1111-1111-111111111111'), UUID_TO_BIN('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
 'USR001', '김민수', '2025-06-01 14:00:00', 'CRT001', '이정훈',
 'REQ001', '정현우', '서버 재시작 요청', '서버 점검', 'PENDING_EXECUTION'),

-- 2 (박지훈)
(b'0', b'1', 3, '2025-06-01 11:00:00.000000', '2025-05-31 08:00:00.000000', '2025-06-01 12:00:00.000000',
 null, null, null,
 UUID_TO_BIN('22222222-2222-2222-2222-222222222222'), UUID_TO_BIN('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
 'USR002', '박지훈', NULL, 'CRT002', '최유리',
 'REQ002', '김가은', '메일 서버 연결 불가', '메일 장애', 'PENDING_EXECUTION'),

-- 3 (최지우)
(b'0', b'1', 3, '2025-06-02 09:30:00.000000', '2025-06-01 07:30:00.000000', NULL,
 null, null, null,
 UUID_TO_BIN('33333333-3333-3333-3333-333333333333'), UUID_TO_BIN('cccccccc-cccc-cccc-cccc-cccccccccccc'),
 'USR003', '최지우', NULL, 'CRT003', '남도현',
 'REQ003', '이채연', '프린터가 작동하지 않음', '프린터 고장', 'PENDING_EXECUTION'),

-- 4 (김민수 again)
(b'0', b'1', 3, NULL, '2025-06-01 08:15:00.000000', NULL,
 null, null, null,
 UUID_TO_BIN('44444444-4444-4444-4444-444444444444'), UUID_TO_BIN('dddddddd-dddd-dddd-dddd-dddddddddddd'),
 'USR001', '김민수', NULL, 'CRT004', '박성민',
 'REQ004', '문서진', 'PC 교체 요청', '장비 변경', 'PENDING_EXECUTION'),

-- 5 (박지훈 again)
(b'0', b'1', 3, '2025-06-03 09:00:00.000000', '2025-06-02 08:00:00.000000', NULL,
 null, null, null,
 UUID_TO_BIN('55555555-5555-5555-5555-555555555555'), UUID_TO_BIN('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee'),
 'USR002', '박지훈', NULL, 'CRT005', '이현수',
 'REQ005', '최나영', '전산실 온도 비정상', '냉방 장치 점검', 'PENDING_EXECUTION'),

-- 6 (이시은)
(b'0', b'1', 3, '2025-06-03 13:00:00.000000', '2025-06-02 12:00:00.000000', NULL,
 null, null, null,
 UUID_TO_BIN('66666666-6666-6666-6666-666666666666'), UUID_TO_BIN('ffffffff-ffff-ffff-ffff-ffffffffffff'),
 'USR004', '이시은', NULL, 'CRT006', '정영훈',
 'REQ006', '한지은', '비밀번호 재설정 요청', '계정 문제', 'PENDING_EXECUTION'),

-- 7 (김민수 again)
(b'0', b'1', 3, '2025-06-04 10:30:00.000000', '2025-06-03 09:00:00.000000', NULL,
 null, null, null,
  UUID_TO_BIN('77777777-7777-7777-7777-777777777777'), UUID_TO_BIN('12345678-aaaa-bbbb-cccc-123456789abc'),
 'USR001', '김민수', NULL, 'CRT007', '양예진',
 'REQ007', '홍지윤', '화상 회의 오류', '회의 시스템', 'PENDING_EXECUTION'),

-- 8 (null)
(b'0', b'1', 1008, NULL, '2025-06-04 08:00:00.000000', NULL,
 null, null, null,
  UUID_TO_BIN('88888888-8888-8888-8888-888888888888'), UUID_TO_BIN('23456789-bbbb-cccc-dddd-23456789abcd'),
 NULL, NULL, NULL, 'CRT008', '조민재',
 'REQ008', '신유정', '웹메일 로그인 문제', '로그인 장애', 'PENDING_EXECUTION'),

-- 9 (유진우)
(b'0', b'1', 1009, '2025-06-05 09:15:00.000000', '2025-06-04 07:00:00.000000', NULL,
 null, null, null,
  UUID_TO_BIN('99999999-9999-9999-9999-999999999999'), UUID_TO_BIN('34567890-cccc-dddd-eeee-34567890abcd'),
 'USR005', '유진우', NULL, 'CRT009', '하선영',
 'REQ009', '한세린', '라이센스 갱신 요청', '소프트웨어 요청', 'PENDING_EXECUTION'),

-- 10 (오수빈)
(b'0', b'1', 1010, '2025-06-06 11:00:00.000000', '2025-06-05 09:00:00.000000', NULL,
 null, null, null,
  UUID_TO_BIN('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'), UUID_TO_BIN('45678901-dddd-eeee-ffff-45678901abcd'),
 'USR006', '오수빈', '2025-06-06 15:00:00', 'CRT010', '이세영',
 'REQ010', '최지원', '업무 포털 접근 불가', '포털 장애', 'PENDING_EXECUTION');