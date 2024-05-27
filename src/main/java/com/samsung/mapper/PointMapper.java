package com.samsung.mapper;

import com.samsung.domain.Point;
import com.samsung.rest.dto.PointDto;

public class PointMapper {

    public static PointDto toDto(Point point) {
        return new PointDto(
                point.getId(),
                point.getName(),
                point.getLatitude(),
                point.getLongitude(),
                point.getAddress(),
                UserMapper.toUserProfileDto(point.getUser())
        );
    }

    public static Point fromDto(PointDto pointDto) {
        return new Point(
                pointDto.getId(),
                pointDto.getName(),
                pointDto.getLatitude(),
                pointDto.getLongitude(),
                pointDto.getAddress(),
                UserMapper.fromDto(pointDto.getUserDto())
        );
    }
}
