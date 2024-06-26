package com.samsung.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointDto {

    private long id;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    private UserProfileDto userDto;
}
