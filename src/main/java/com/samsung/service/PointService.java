package com.samsung.service;

import com.samsung.domain.Point;
import java.util.List;


public interface PointService {

    Point findByLatitudeAndLongitude(double latitude, double longitude);

    Point save(Point point);

    List<Point> getAll();

    Point getById(long id);

    void deleteById(long id);
}
