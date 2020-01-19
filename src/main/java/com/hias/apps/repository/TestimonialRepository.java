package com.hias.apps.repository;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.hias.apps.domain.ProductDiscussion;
import com.hias.apps.domain.Testimonial;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    Page<Testimonial> findAll(Pageable pageable);

    @Query("Select pw from Testimonial pw where pw.id = :id")
    Optional<Testimonial> findById(@Param("id") Long id);
    //
    @Query("Select pw from Testimonial pw where user_id = :id")
    List<Testimonial> findByUserId(Long id);


    @Modifying
    @Transactional
    @Query(value = "insert into testimonial (user_id, rating, comment) values (:userId, :rating,  :comment)",
            nativeQuery = true)

    public void insertDiscussion(Long userId, Long rating , String comment);

}
