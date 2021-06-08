package com.cxy.entity;

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

}
