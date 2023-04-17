package com.hilltop.wrapper;

import com.hilltop.domain.BaseDto;
import com.hilltop.domain.response.SearchRoomListResponseDto;
import com.hilltop.enums.ResponseStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomListResponseWrapper implements BaseDto {
    private ResponseStatusType status;
    private String message;
    private SearchRoomListResponseDto data;
    private String displayMessage;

    @Override
    public String toLogJson() {
        return toJson();
    }
}
