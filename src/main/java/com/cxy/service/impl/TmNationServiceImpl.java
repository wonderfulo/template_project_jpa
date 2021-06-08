package com.cxy.service.impl;

import com.cxy.entity.TmNation;
import com.cxy.repository.TmNationRepository;
import com.cxy.service.ITmNationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 民族表 服务实现类
 * </p>
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
@Service
public class TmNationServiceImpl implements ITmNationService {

    public static final Integer isDelete = 0;

    @Autowired
    private TmNationRepository tmNationRepository;

    @Override
    public List<TmNation> findByNationId(Long nationId) {
        return tmNationRepository.findByNationIdAndIsDelete(nationId, isDelete);
    }
}
