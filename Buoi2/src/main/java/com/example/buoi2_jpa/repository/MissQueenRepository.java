package com.example.buoi2_jpa.repository;

import com.example.buoi2_jpa.model.MissQueen;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissQueenRepository extends JpaRepository<MissQueen, Integer> {

    List<MissQueen> findAllByNameOrHeight(String name, double height);
    @Query(value = "select * from miss_queen where height=?1 and weight=?2", nativeQuery = true)
    List<MissQueen> findByHeightAndWe(double height, double weight);
    @Query(value = "select m from MissQueen m where m.height=:height and m.name=:name")
    List<MissQueen> findAllByNameAndHeight(@Param(value = "height") double height, @Param(value = "name") String name);
}
