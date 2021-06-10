package com.cxy.entity;

import com.cxy.constant.IsDeleteEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 民族表
 * </p>
 *
 * @author 陈翔宇
 * @since 2020-12-10
 */
@Data
@Entity(name = "tm_nation")
public class TmNation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nation_id")
    private Long nationId;

    @Column(name="nation_name")
    private String nationName;

    /**
     * 企业Id
     */
    @Column(name="app_id")
    private String appId;

    /**
     * 0: 可用, 1: 删除
     */
    @Column(name="is_delete")
    private Integer isDelete;

    /**
     * 创建者ID
     */
    @Column(name="create_user")
    private Long createUser;

    /**
     * 创建时间
     * * @JsonFormat: 返回数据时，格式转换
     * * @DateTimeFormat: 请求数据时，格式转换
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="create_time")
    private Date createTime;

    /**
     * 修改者ID
     */
    @Column(name="update_user")
    private Long updateUser;

    /**
     * 修改时间
     * * @JsonFormat: 返回数据时，格式转换
     * * @DateTimeFormat: 请求数据时，格式转换
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="update_time")
    private Date updateTime;


    @Transient
    private String test;


    /**
     * 对象公用参数基础构建
     *
     * @param tmSysUser
     */
    public void baseBuild(TmSysUser tmSysUser) {
        if (this.createUser == null) {
            this.createUser = tmSysUser.getSysUserId();
            this.createTime = new Date();
        }
        this.updateUser = tmSysUser.getSysUserId();
        this.updateTime = new Date();
    }

    /**
     * 对象公用参数创建构建
     *
     * @param tmSysUser
     */
    public void createBuild(TmSysUser tmSysUser) {
        this.appId = tmSysUser.getAppId();
        this.isDelete = IsDeleteEnum.FALSE.getValue();
        this.createUser = tmSysUser.getSysUserId();
        this.createTime = new Date();
        this.updateUser = tmSysUser.getSysUserId();
        this.updateTime = new Date();
    }

    /**
     * 对象公用参数修改构建
     *
     * @param tmSysUser
     */
    public void updateBuild(TmSysUser tmSysUser) {
        this.updateUser = tmSysUser.getSysUserId();
        this.updateTime = new Date();
    }


    /**
     * 对象公用参数删除构建
     *
     * @param tmSysUser
     */
    public void delBuild(TmSysUser tmSysUser) {
        this.isDelete = IsDeleteEnum.TRUE.getValue();
        this.updateUser = tmSysUser.getSysUserId();
        this.updateTime = new Date();
    }
}
