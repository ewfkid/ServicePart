package com.samsung.rest.dto;


import com.samsung.domain.Point;
import com.samsung.domain.User;
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

    private UserDto userDto;

    public static PointDto toDto(Point point) {
        return new PointDto(
                point.getId(),
                point.getName(),
                point.getLatitude(),
                point.getLongitude(),
                UserDto.toDto(point.getUser())
        );
    }

    public static Point fromDto(PointDto pointDto, User user) {
        return new Point(
                pointDto.getId(),
                pointDto.getName(),
                pointDto.getLatitude(),
                pointDto.getLongitude(),
                UserDto.fromDto(pointDto.getUserDto())
        );
    }
}
