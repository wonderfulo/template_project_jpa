package com.cxy.service;

import com.cxy.entity.TmNation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 民族表 服务类
 * </p>
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
public interface ITmNationService {
    /**
     * 根据 ID 查询 未被删除的对象
     *
     * @param nationId
     * @return
     */
    TmNation findByNationId(Long nationId);

    TmNation saveAndFlush(TmNation tmNation);

    Page<TmNation> findByIsDelete(Integer isDelete, Pageable pageable);

    Page<TmNation> findPageByAttr(Integer isDelete, Pageable pageable);

    Page<TmNation> findPageEntity(TmNation tmNation, Pageable pageable);
}
