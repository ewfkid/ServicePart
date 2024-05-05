package com.samsung.rest.controller;


import com.samsung.domain.Point;
import com.samsung.rest.dto.PointDto;
import com.samsung.service.PointService;
import com.samsung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    private final UserService userService;

    @PostMapping("/point")
    public PointDto savePoint(@RequestBody PointDto pointDto) {
        Point point = PointDto.fromDto(pointDto, userService.findByEmail(pointDto.getUserDto().getEmail()));
        Point savedPoint = pointService.save(point);
        return PointDto.toDto(savedPoint);
    }

    @GetMapping("/point")
    public List<PointDto> getAllPoint() {
        return pointService.getAll().stream().map(PointDto::toDto).collect(Collectors.toList());
    }

   @GetMapping("/point/{id}")
    public PointDto getPointById(@PathVariable long id) {
        return PointDto.toDto(pointService.getById(id));
    }

    @DeleteMapping("/point/{id}")
    public void deletePoint(@PathVariable long id) {
        pointService.deleteById(id);
    }
}
