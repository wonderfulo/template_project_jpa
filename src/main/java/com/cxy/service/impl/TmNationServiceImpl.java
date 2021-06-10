package com.cxy.service.impl;

import com.cxy.constant.IsDeleteEnum;
import com.cxy.entity.TmNation;
import com.cxy.repository.TmNationRepository;
import com.cxy.service.ITmNationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Page<TmNation> findPageByEntity(TmNation tmNation, Pageable pageable) {
        return tmNationRepository.findPageByEntity(tmNation, pageable);
    }

    @Override
    public Page<TmNation> findPageByExample(TmNation tmNation, Pageable pageable) {
        //包含
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("nationName", ExampleMatcher.GenericPropertyMatchers.contains());
//        //开头
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("nationName", ExampleMatcher.GenericPropertyMatchers.startsWith());
//        //结尾
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("nationName", ExampleMatcher.GenericPropertyMatchers.endsWith());

        Example<TmNation> example = Example.of(tmNation,matcher);
//        List<TmNation> all = tmNationRepository.findAll(example);
        return tmNationRepository.findAll(example, pageable);
//        return null;
    }
}
