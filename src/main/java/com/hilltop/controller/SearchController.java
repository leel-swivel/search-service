package com.hilltop.controller;

import com.hilltop.configuration.Translator;
import com.hilltop.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Search Controller
 */
@RestController
@RequestMapping("/api/v1/search")
@Slf4j
public class SearchController extends Controller {


    public SearchController(Translator translator) {
        super(translator);
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> saveBooking() {
        System.out.println("CAME !!!!!!!!!!!!!!!!!11");
        return null;
    }
}
