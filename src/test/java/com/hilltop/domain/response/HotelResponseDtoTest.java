package com.hilltop.domain.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HotelResponseDtoTest {
    @Test
    public void testConstructorAndGetters() {
        String id = "1234";
        String name = "Example Hotel";
        String description = "This is an example hotel.";
        String city = "Example City";
        String telephone = "123-456-7890";
        String email = "hotel@example.com";
        List<String> imageUrl = Arrays.asList("https://example.com/image1.png", "https://example.com/image2.png");

        HotelResponseDto hotelResponseDto = new HotelResponseDto(id, name, description, city, telephone, email, imageUrl);

        Assertions.assertThat(hotelResponseDto.getId()).isEqualTo(id);
        Assertions.assertThat(hotelResponseDto.getName()).isEqualTo(name);
        Assertions.assertThat(hotelResponseDto.getDescription()).isEqualTo(description);
        Assertions.assertThat(hotelResponseDto.getCity()).isEqualTo(city);
        Assertions.assertThat(hotelResponseDto.getTelephone()).isEqualTo(telephone);
        Assertions.assertThat(hotelResponseDto.getEmail()).isEqualTo(email);
        Assertions.assertThat(hotelResponseDto.getImageUrl()).isEqualTo(imageUrl);
    }
}