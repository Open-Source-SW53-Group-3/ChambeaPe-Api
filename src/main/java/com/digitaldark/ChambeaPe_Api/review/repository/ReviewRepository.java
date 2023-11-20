package com.digitaldark.ChambeaPe_Api.review.repository;

import com.digitaldark.ChambeaPe_Api.review.model.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewsEntity, Integer> {
    List<ReviewsEntity> findAllByWorkerId(int id);

}
