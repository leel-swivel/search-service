package com.hilltop.controller;

import com.hilltop.configuration.Translator;
import com.hilltop.exception.SearchServiceException;
import com.hilltop.service.SearchService;
import com.hilltop.wrapper.ResponseWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SearchControllerTest {

    private static final String SEARCH_URL = "/api/v1/search?city=Kaluthara&count=2&days=2";

    @Mock
    private SearchService searchService;
    @Mock
    private Translator translator;
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        initMocks(this);
        SearchController searchController = new SearchController(translator, searchService);
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }


    @Test
    void Should_ReturnOk_When_Calling_RoomSearch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(SEARCH_URL)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}