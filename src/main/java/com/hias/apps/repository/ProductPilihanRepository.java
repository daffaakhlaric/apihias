package com.hias.apps.repository;

import com.hias.apps.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductPilihanRepository extends JpaRepository<ProductPilihan, Long> {

    Page<ProductPilihan> findAllByOrderByIdDesc(Pageable pageable);

    List<ProductPilihan> findFirst8ByOrderByIdDesc();

    @Modifying
    @Transactional
    @Query(value = "insert into product_pilihan (product_id) values (:productId)",
            nativeQuery = true)

    public void insertProductPilihan(Long productId);

    @Query("Select pw from ProductPilihan pw where pw.id = :id")
    Optional<ProductPilihan> findById(@Param("id") Long id);


    @Query("Select pw from ProductPilihan pw where product_id = :id")
    List<ProductPilihan> findByProductId(Long id);

    List<ProductPilihan> findFirst3ByOrderByIdDesc();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_pilihan WHERE id = :id", nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    public void deleteProductPilihan(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE ProductPilihan SET product_id = :productId  WHERE id = :id")
    public void updateProductPilihan(Long productId, Long id);
}
