package com.samsung.rest.controller;

import com.samsung.domain.Point;
import com.samsung.rest.dto.PointDto;
import com.samsung.service.PointService;
import lombok.RequiredArgsConstructor;
import com.samsung.mapper.PointMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping("/point")
    public PointDto savePoint(@RequestBody PointDto pointDto) {
        Point point = PointMapper.fromDto(pointDto);
        Point savedPoint = pointService.save(point);
        return PointMapper.toDto(savedPoint);
    }

    @GetMapping("/point/{id}")
    public PointDto getPointById(@PathVariable long id) {
        return PointMapper.toDto(pointService.getById(id));
    }

    @DeleteMapping("/point/{id}")
    public void deletePoint(@PathVariable long id) {
        pointService.deleteById(id);
    }

    @GetMapping("/point/{latitude}/{longitude}")
    public PointDto findPointByLatitudeAndLongitude(
            @PathVariable("latitude") double latitude,
            @PathVariable("longitude") double longitude) {
        return PointMapper.toDto(pointService.findByLatitudeAndLongitude(latitude, longitude));
    }

    @PutMapping("/point/{id}")
    public PointDto updatePoint(@PathVariable long id,
                                @RequestParam String name) {
        return PointMapper.toDto(pointService.update(id, name));
    }

    @GetMapping("/point")
    public List<PointDto> findPointByUserId(@RequestParam long userId) {
        return pointService.findByUserId(userId)
                .stream()
                .map(PointMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/point/{name}")
    public PointDto findPointByName(@PathVariable String name){
        return  PointMapper.toDto(pointService.findByName(name));
    }
}
