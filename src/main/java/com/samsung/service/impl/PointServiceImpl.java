package com.samsung.service.impl;

import com.samsung.exeption.PointNotFoundException;
import com.samsung.dao.PointRepository;
import com.samsung.domain.Point;
import com.samsung.exeption.UserAlreadyExistsException;
import com.samsung.service.PointService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    @Override
    @Transactional(readOnly = true)
    public Point findByLatitudeAndLongitude(double latitude, double longitude) {
        return pointRepository.findByLatitudeAndLongitude(latitude, longitude).orElseThrow(() -> new PointNotFoundException(
                "point  with coordinates: latitude " + latitude + " longitude " + longitude + " was not found"));
    }

    @Override
    @Transactional
    public Point save(Point point) {
        if (pointRepository.findByLatitudeAndLongitude(point.getLatitude(), point.getLongitude()).isPresent())
            throw new UserAlreadyExistsException(
                    "point  with coordinates: latitude " + point.getLatitude()
                            + " longitude " + point.getLongitude() + " already exists");
        return pointRepository.save(point);
    }

    @Override
    public List<Point> getAll() {
        return pointRepository.findAll();
    }

    @Override
    public Point getById(long id) {
        return pointRepository.findById(id).orElseThrow(() -> new PointNotFoundException(
                "user  with id " + id + " was not found"));
    }

    @Override
    public void deleteById(long id) {
        if (!pointRepository.existsById(id)) {
            throw new PointNotFoundException("point with id " + id + " was not found");
        }
        pointRepository.deleteById(id);
    }
}
