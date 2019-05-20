package com.quartz.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * <p>
 * 定时任务调度表
 * </p>
 *
 * @author wangph
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_job")
public class SysJob implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 任务ID
     */
    private Long jobId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务组名
     */
    private String jobGroup;
    /**
     * 任务方法
     */
    private String methodName;
    /**
     * 方法参数
     */
    private String methodParams;
    /**
     * cron执行表达式
     */
    private String cronExpression;
    /**
     * 计划执行错误策略（1继续 2等待 3放弃）
     */
    private String misfirePolicy;
    /**
     * 状态（0正常 1暂停）
     */
    private String status;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注信息
     */
    private String remark;

}
