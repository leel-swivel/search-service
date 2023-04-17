package com.hilltop.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto extends ResponseDto {
    private String id;
    private int roomNumber;
    private String hotelId;
    private String roomTypeName;
    private int paxCount;
    private List<String> imageUrls;
    private BigDecimal cost;
}
