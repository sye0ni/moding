package com.ssafy.reservation.dto.response;

import com.ssafy.reservation.domain.Reservation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfoResponse {

    @Schema(description = "좌석 정보")
    private List<String> seats;

    @Schema(description = "영화 포스터")
    private String poster;

    @Schema(description = "영화 관람 등급")
    private String age;

    @Schema(description = "영화 제목")
    private String title;

    @Schema(description = "재상영 날짜")
    private LocalDate date;

    @Schema(description = "시작 시간")
    private String startTime;

    @Schema(description = "러닝 타임")
    private Integer runningTime;

    @Schema(description = "수량")
    private Integer count;

    @Schema(description = "영화관 지점명")
    private String name;

    @Schema(description = "상영관")
    private Integer number;

    public static TicketInfoResponse of(
            List<String> seats, FundingInfoResponse fundingInfoResponse, Reservation reservation) {
        TicketInfoResponse ticketInfoResponse =
                TicketInfoResponse.builder()
                        .seats(seats)
                        .poster(fundingInfoResponse.getPoster())
                        .age(fundingInfoResponse.getAge())
                        .title(fundingInfoResponse.getTitle())
                        .date(fundingInfoResponse.getDate())
                        .startTime(fundingInfoResponse.getStartTime())
                        .runningTime(fundingInfoResponse.getRunningTime())
                        .count(fundingInfoResponse.getCount())
                        .name(fundingInfoResponse.getName())
                        .number(fundingInfoResponse.getNumber())
                        .build();
        return ticketInfoResponse;
    }
}
