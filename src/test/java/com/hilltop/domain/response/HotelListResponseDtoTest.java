package com.hilltop.domain.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HotelListResponseDtoTest {
    @Test
    void testConstructorAndGetters() {
        HotelResponseDto hotel1 = new HotelResponseDto("1234", "Example Hotel 1", "This is an example hotel 1.", "Example City 1", "123-456-7890", "hotel1@example.com", Arrays.asList("https://example.com/hotel1/image1.png", "https://example.com/hotel1/image2.png"));
        HotelResponseDto hotel2 = new HotelResponseDto("5678", "Example Hotel 2", "This is an example hotel 2.", "Example City 2", "123-456-7890", "hotel2@example.com", Arrays.asList("https://example.com/hotel2/image1.png", "https://example.com/hotel2/image2.png"));

        List<HotelResponseDto> hotelList = Arrays.asList(hotel1, hotel2);

        HotelListResponseDto hotelListResponseDto = new HotelListResponseDto(hotelList);

        Assertions.assertThat(hotelListResponseDto.getHotelList()).isEqualTo(hotelList);
    }

    @Test
    void testToLogJson() {
        HotelResponseDto hotel1 = new HotelResponseDto("1234", "Example Hotel 1", "This is an example hotel 1.", "Example City 1", "123-456-7890", "hotel1@example.com", Arrays.asList("https://example.com/hotel1/image1.png", "https://example.com/hotel1/image2.png"));
        HotelResponseDto hotel2 = new HotelResponseDto("5678", "Example Hotel 2", "This is an example hotel 2.", "Example City 2", "123-456-7890", "hotel2@example.com", Arrays.asList("https://example.com/hotel2/image1.png", "https://example.com/hotel2/image2.png"));

        List<HotelResponseDto> hotelList = Arrays.asList(hotel1, hotel2);

        HotelListResponseDto hotelListResponseDto = new HotelListResponseDto(hotelList);

        String expectedJson = "{\"hotelList\":[{\"id\":\"1234\",\"name\":\"Example Hotel 1\",\"description\":\"This is an example hotel 1.\",\"city\":\"Example City 1\",\"telephone\":\"123-456-7890\",\"email\":\"hotel1@example.com\",\"imageUrl\":[\"https://example.com/hotel1/image1.png\",\"https://example.com/hotel1/image2.png\"]},{\"id\":\"5678\",\"name\":\"Example Hotel 2\",\"description\":\"This is an example hotel 2.\",\"city\":\"Example City 2\",\"telephone\":\"123-456-7890\",\"email\":\"hotel2@example.com\",\"imageUrl\":[\"https://example.com/hotel2/image1.png\",\"https://example.com/hotel2/image2.png\"]}]}";

        Assertions.assertThat(hotelListResponseDto.toLogJson()).isEqualTo(expectedJson);
    }

}