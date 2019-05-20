package com.quartz.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * <p>
 * 定时任务调度日志表
 * </p>
 *
 * @author wangph
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_job_log")
public class SysJobLog implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 任务日志ID
     */
    private Long jobLogId;
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
     * 日志信息
     */
    private String jobMessage;
    /**
     * 执行状态（0正常 1失败）
     */
    private String status;
    /**
     * 异常信息
     */
    private String exceptionInfo;
    /**
     * 创建时间
     */
    private Date createTime;

}
