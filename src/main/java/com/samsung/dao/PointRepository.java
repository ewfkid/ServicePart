package com.samsung.dao;

import com.samsung.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    Optional<Point> findByLatitudeAndLongitude(double latitude, double longitude);

    List<Point> findByUserId(long id);

    Optional<Point> findByName(String name);
}
