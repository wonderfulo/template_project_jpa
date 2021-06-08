package com.cxy.repository;

import com.cxy.entity.TmNation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 陈翔宇
 * @since 2020-12-10
 */
@Repository
public interface TmNationRepository extends JpaRepository<TmNation, Long> {
    List<TmNation> findByNationIdAndIsDelete(Long nationId,Integer isDelete);
}