package com.cxy.service;

import com.cxy.entity.TmNation;

import java.util.List;

/**
 * <p>
 * 民族表 服务类
 * </p>
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
public interface ITmNationService{
    /**
     * 根据 ID 查询 未被删除的对象
     * @param nationId
     * @return
     */
    List<TmNation> findByNationId(Long nationId);

}
