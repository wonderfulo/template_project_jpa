package com.cxy.service.impl;

import com.cxy.constant.IsDeleteEnum;
import com.cxy.entity.TmNation;
import com.cxy.repository.TmNationRepository;
import com.cxy.service.ITmNationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private EntityManager entityManager;

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
        return tmNationRepository.findAll(example, pageable);
    }

    @Override
    public Page<TmNation> findPageByDynamicSql(TmNation tmNation, Pageable pageable) {
        StringBuilder sb = new StringBuilder("select * from tm_nation  where 1 = 1 ");
        StringBuilder countSql = new StringBuilder("select count(*)  from tm_nation  where 1 = 1");
        List<Object> params = new ArrayList<>();
        if (tmNation.getIsDelete() != null){
            sb.append(" and is_delete = ?");
            params.add(tmNation.getIsDelete());
        }
        Query query = entityManager.createNativeQuery(sb.toString());

        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        List resultList = query.getResultList();

        Example<TmNation> example = Example.of(tmNation);
       return tmNationRepository.findAll(example, pageable);
    }

    @Override
    public List<TmNation> findByNationIdIn(List<Long> nationIds) {
        return tmNationRepository.findByNationIdIn(nationIds);
    }

//
//        public List<Object[]> findByPcardCardOrder(TmNation tmNation ,String applyInstName2,Integer page, Integer rows) {
//            Map<String, Object> map = new HashMap<String, Object>();
//
////            Query nativeQuery = entityManager.createNativeQuery(sql.toString());
//
//            Query query = entityManager.createNativeQuery(sql.toString());
////            for (String key : map.keySet()) {
////                Query.setParameter(key, map.get(key));
////            }
////            if (page != null && rows != null) {
////                Query.setFirstResult(rows * (page - 1));
////                Query.setMaxResults(rows);
////            }
//            return query.getResultList();
//        }
}
