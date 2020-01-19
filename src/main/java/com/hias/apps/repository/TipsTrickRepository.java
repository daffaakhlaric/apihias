package com.hias.apps.repository;

import com.hias.apps.domain.InspirationProduct;
import com.hias.apps.domain.TipsProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public interface TipsTrickRepository extends JpaRepository<TipsProduct, Long> {

    List<TipsProduct> findAll();


    @Query("Select pw from TipsProduct pw where tips_id = :id")
    List<TipsProduct> findByTipsId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into tips_related_product (tips_id, product_id) values (:tipsId, :productId)",
            nativeQuery = true)

    public void insertDiscussion(Long tipsId, Long productId);
}
