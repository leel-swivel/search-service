package com.hilltop.service;

import com.hilltop.domain.response.HotelListResponseDto;
import com.hilltop.domain.response.HotelResponseDto;
import com.hilltop.domain.response.RoomSearchResponseDto;
import com.hilltop.domain.response.SearchRoomListResponseDto;
import com.hilltop.exception.SearchServiceException;
import com.hilltop.wrapper.HotelListResponseWrapper;
import com.hilltop.wrapper.RoomListResponseWrapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final RestTemplate restTemplate;

    public SearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * This method used to get search result.
     *
     * @param city     city
     * @param dayCount dayCount
     * @param paxCount paxCount
     * @return List of RoomSearchResponseDto
     */
    public List<RoomSearchResponseDto> getRoomSearch(String city, int dayCount, int paxCount) {
        List<String> hotelsIdByCity = getHotelsIdByCity(city);
        return getRoomsByHotelIdWithPaxCountAndDays(hotelsIdByCity, dayCount, paxCount);
    }


    /**
     * This method used to get hotel ids by city.
     *
     * @param city city
     * @return List of hotel id.
     */
    public List<String> getHotelsIdByCity(String city) {
        try {
            String getHotelIdUrl = "http://localhost:8083/hotel-service/api/v1/hotel/city/" + city;
            ResponseEntity<HotelListResponseWrapper> result =
                    restTemplate.exchange(getHotelIdUrl, HttpMethod.GET, null, HotelListResponseWrapper.class);
            HotelListResponseDto hotelList = Objects.requireNonNull(result.getBody()).getData();
            return hotelList.getHotelList().stream().map(HotelResponseDto::getId).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new SearchServiceException("Getting hotel ids by city was failed.");
        }
    }


    /**
     * This method used to get room search result.
     *
     * @param hotelIds hotelIds
     * @param dayCount dayCount
     * @param paxCount paxCount
     * @return RoomSearchResponseDto List
     */
    public List<RoomSearchResponseDto> getRoomsByHotelIdWithPaxCountAndDays(List<String> hotelIds, int dayCount, int paxCount) {

        try {
            String hotelIdsUrlPrefix = creteHotelIdsUrlPrefix(hotelIds);
            String getRoomsUrl = "http://localhost:8084/room-service/api/v1/room/list-hotel-room-by?count=" + paxCount + "&days=" + dayCount + hotelIdsUrlPrefix;
            ResponseEntity<RoomListResponseWrapper> result =
                    restTemplate.exchange(getRoomsUrl, HttpMethod.GET, null, RoomListResponseWrapper.class);
            SearchRoomListResponseDto data = Objects.requireNonNull(result.getBody()).getData();
            return data.getList();
        } catch (RuntimeException e) {
            throw new SearchServiceException("Getting Search room was failed.", e);
        }
    }


    /**
     * This method used to generate hotel id url prefix.
     *
     * @param hotelIds hotelIds
     * @return String
     */
    public String creteHotelIdsUrlPrefix(List<String> hotelIds) {
        StringBuilder urlBuilder = new StringBuilder();
        for (var id : hotelIds) {
            urlBuilder.append("&hotelIds=").append(id);
        }
        return urlBuilder.toString();
    }

}
