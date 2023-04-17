package com.hilltop.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSearchResponseDto extends ResponseDto {

    private String hotelId;
    private List<RoomResponseDto> rooms;

}