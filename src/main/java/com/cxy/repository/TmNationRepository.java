package com.cxy.repository;

import com.cxy.entity.TmNation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 陈翔宇
 * @since 2020-12-10
 */
@Repository
public interface TmNationRepository extends JpaRepository<TmNation, Long> {
    TmNation findFirstByNationIdAndIsDelete(Long nationId, Integer isDelete);

    Page<TmNation> findByIsDelete(Integer isDelete, Pageable pageable);

    @Query(value = "select * from tm_nation  where is_delete = :isDelete",
            countQuery = "select count(*) from tm_nation  where is_delete = :isDelete",
            nativeQuery = true)
    Page<TmNation> findPageByAttr(@Param("isDelete") Integer isDelete, Pageable pageable);

    @Query(value = "select * from tm_nation  where is_delete = :#{#tmNation.isDelete}",
            countQuery = "select count(*) from tm_nation  where is_delete = :#{#tmNation.isDelete}",
            nativeQuery = true)
    Page<TmNation> findPageEntity(@Param("tmNation") TmNation tmNation, Pageable pageable);

}