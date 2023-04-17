package com.hilltop.controller;

import com.hilltop.configuration.Translator;
import com.hilltop.domain.response.RoomListResponseDto;
import com.hilltop.domain.response.RoomSearchResponseDto;
import com.hilltop.enums.SuccessResponseStatusType;
import com.hilltop.exception.SearchServiceException;
import com.hilltop.service.SearchService;
import com.hilltop.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Search Controller
 */
@RestController
@RequestMapping("/api/v1/search")
@Slf4j
public class SearchController extends Controller {

    private final SearchService searchService;

    public SearchController(Translator translator, SearchService searchService) {
        super(translator);
        this.searchService = searchService;
    }

    /**
     * This endpoint used to get  search result.
     *
     * @param days   day count
     * @param count pax count
     * @param city  city
     * @return RoomListResponseDto
     */
    @GetMapping("")
    public ResponseEntity<ResponseWrapper> getSearchRoom(@RequestParam int days,
                                                         @RequestParam int count,
                                                         @RequestParam String city) {
        try {
            List<RoomSearchResponseDto> roomSearch = searchService.getRoomSearch(city, count, days);
            RoomListResponseDto roomListResponseDto = new RoomListResponseDto(roomSearch);
            return getSuccessResponse(roomListResponseDto, SuccessResponseStatusType.SEARCH_ROOM, HttpStatus.OK);
        } catch (SearchServiceException e) {
            log.error("Getting rooms pax count : {}, day count: {} and city: {} was failed", count, days, city, e);
            return getInternalServerError();
        }
    }
}
