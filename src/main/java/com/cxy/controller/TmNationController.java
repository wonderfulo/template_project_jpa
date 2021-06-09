package com.cxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.cxy.annonation.MyLog;
import com.cxy.common.JsonResponse;
import com.cxy.entity.TmNation;
import com.cxy.entity.TmSysUser;
import com.cxy.service.ITmNationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 民族表 前端控制器
 * </p>
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
@RestController
@RequestMapping("api/nation")
@Api(value = "nationAPI", description = "民族API接口")
public class TmNationController {

    @Autowired
    private ITmNationService tmNationService;

    @PostMapping("")
    @ApiOperation("添加民族")
    @Transactional
    public JsonResponse<TmNation> save(@RequestParam(value = "accessToken", required = true) String accessToken, TmNation tmNation) {
        if (StringUtils.isEmpty(tmNation.getNationName())) {
            return JsonResponse.fail("nationName: 必要参数");
        }

        TmSysUser tmSysUser = new TmSysUser();
        tmSysUser.setSysUserId(123L);
        tmNation.createBuild(tmSysUser);

        TmNation result = tmNationService.saveAndFlush(tmNation);
        return JsonResponse.success(result);
    }



    @DeleteMapping("/{nationId}")
    @ApiOperation("删除民族")
    @Transactional
    public JsonResponse<String> del(@RequestParam(value = "accessToken", required = true) String accessToken, @PathVariable("nationId") Long nationId) {
        if (nationId == null) {
            return JsonResponse.fail("nationId: 必要参数");
        }
        //由于不允许更新已删除的数据，故要先进行查询
        TmNation oldTmNation = tmNationService.findByNationId(nationId);
        if (oldTmNation == null) {
            return JsonResponse.fail("待删除的数据不存在");
        }

        TmSysUser TmSysUser = new TmSysUser();
        TmSysUser.setSysUserId(888L);
        oldTmNation.delBuild(TmSysUser);
        tmNationService.saveAndFlush(oldTmNation);
        return JsonResponse.success("success");
    }

    @PutMapping("")
    @ApiOperation("修改民族")
    @Transactional
    @MyLog
    public JsonResponse<TmNation> update(@RequestParam(value = "accessToken", required = true) String accessToken, TmNation tmNation) {
        if (tmNation.getNationId() == null) {
            return JsonResponse.fail("nationId: 必要参数");
        }
        //由于不允许更新已删除的数据，故要先进行查询
        TmNation oldTmNation = tmNationService.findByNationId(tmNation.getNationId());
        if (oldTmNation == null) {
            return JsonResponse.fail("待更新数据不存在");
        }

        BeanUtil.copyProperties(tmNation, oldTmNation, CopyOptions.create().setIgnoreNullValue(true));

        TmSysUser TmSysUser = new TmSysUser();
        TmSysUser.setSysUserId(888L);
        oldTmNation.updateBuild(TmSysUser);
        TmNation result = tmNationService.saveAndFlush(oldTmNation);
        return JsonResponse.success(result);
    }

    @GetMapping("/{nationId}")
    @ApiOperation(
            value = "获取民族对象",
            notes = "未被删除的",
            httpMethod = "GET",
            response = TmNation.class,
            responseContainer = "Object")
    public JsonResponse<TmNation> find(@RequestParam(value = "accessToken", required = true) String accessToken, @PathVariable("nationId") Long nationId) {
        if (nationId == null) {
            return JsonResponse.fail("nationId: 必要参数");
        }
        TmNation tmNations = tmNationService.findByNationId(nationId);
        return JsonResponse.success(tmNations);
    }


    @GetMapping("/list")
    @ApiOperation(
            value = "获取民族对象列表",
            notes = "参数查询，分页获取",
            httpMethod = "GET",
            response = TmNation.class,
            responseContainer = "Object")
    public JsonResponse<Page<TmNation>> list(@RequestParam(value = "accessToken", required = true) String accessToken, TmNation tmNation, Integer pageNumber, Integer pageSize) {
        if (pageNumber <= 1) {
            pageNumber = 0;
        }else {
            pageNumber = pageNumber - 1;
        }

        Page<TmNation> tmNationPage = tmNationService.findPage(tmNation.getIsDelete(), PageRequest.of(pageNumber, pageSize));
        return JsonResponse.success(tmNationPage);
    }

    @GetMapping("/listTest")
    @ApiOperation(
            value = "获取民族对象列表",
            notes = "参数查询，分页获取",
            httpMethod = "GET",
            response = TmNation.class,
            responseContainer = "Object")
    public JsonResponse<Page<TmNation>> listTest(@RequestParam(value = "accessToken", required = true) String accessToken, TmNation tmNation, Integer pageNumber, Integer pageSize) {
        if (pageNumber <= 1) {
            pageNumber = 0;
        }else {
            pageNumber = pageNumber - 1;
        }

        Page<TmNation> tmNationPage = tmNationService.findByIsDelete(tmNation.getIsDelete(), PageRequest.of(pageNumber, pageSize));
        return JsonResponse.success(tmNationPage);
    }
}
