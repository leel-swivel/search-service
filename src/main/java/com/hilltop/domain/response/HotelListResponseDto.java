package com.hilltop.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelListResponseDto extends ResponseDto {

    private List<HotelResponseDto> hotelList;

    @Override
    public String toLogJson() {
        return toJson();
    }
}