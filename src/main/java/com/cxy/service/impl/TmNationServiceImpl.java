package com.cxy.service.impl;

import com.cxy.constant.IsDeleteEnum;
import com.cxy.entity.TmNation;
import com.cxy.repository.TmNationRepository;
import com.cxy.service.ITmNationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private TmNationRepository tmNationRepository;

    @Override
    public TmNation findByNationId(Long nationId) {
        return tmNationRepository.findFirstByNationIdAndIsDelete(nationId, IsDeleteEnum.FALSE.getValue());
    }

    @Override
    public TmNation saveAndFlush(TmNation tmNation) {
        return tmNationRepository.saveAndFlush(tmNation);
    }


    @Override
    public Page<TmNation> findByIsDelete(Integer isDelete, Pageable pageable) {
        return tmNationRepository.findByIsDelete(isDelete, pageable);
    }

    @Override
    public Page<TmNation> findPageByAttr(Integer isDelete, Pageable pageable) {
        return tmNationRepository.findPageByAttr(isDelete, pageable);
    }

    @Override
    public Page<TmNation> findPageEntity(TmNation tmNation, Pageable pageable) {
        return tmNationRepository.findPageEntity(tmNation, pageable);
    }
}
