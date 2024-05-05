package com.samsung.service;

import com.samsung.domain.Point;

import java.util.List;


public interface PointService {

    Point findByLatitudeAndLongitude(double latitude, double longitude);

    Point save(Point point);

    Point getById(long id);

    Point update(long id, String name);

    void deleteById(long id);

    List<Point> findByUserId(long userId);
}
