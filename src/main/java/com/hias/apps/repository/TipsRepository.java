package com.hias.apps.repository;

import com.hias.apps.domain.Inspiration;
import com.hias.apps.domain.TipsTrick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public interface TipsRepository extends JpaRepository<TipsTrick, Long> {

    List<TipsTrick> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into tips (title,description,image_banner) values (:title,:description,:image)",
            nativeQuery = true)

    public void insertTips(String title, String description,String image);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TipsTrick WHERE id = :id", nativeQuery = true)
    public void deleteTips(@Param("id") Long id);



    @Modifying
    @Transactional
    @Query("UPDATE TipsTrick SET title = :title , description = :description , image_banner = :image WHERE id = :id")
    public void updateTips(String title, String description ,String image,Long id);
}
