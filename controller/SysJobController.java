package com.quartz.controller;

import com.htkj.common.model.ResultModel;
import com.htkj.system.quartz.model.SysJob;
import com.htkj.system.quartz.service.ISysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 调度任务信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/job")
public class SysJobController
{
    private String prefix = "monitor/job";

    @Autowired
    private ISysJobService jobService;

    @GetMapping()
    public String job()
    {
        return prefix + "/job";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResultModel list(SysJob job)
    {
        List<SysJob> list = jobService.selectJobList(job);
        return ResultModel.success("成功");
    }

//    @PostMapping("/export")
//    @ResponseBody
//    public ResultModel export(SysJob job)
//    {
//        List<SysJob> list = jobService.selectJobList(job);
//        return util.exportExcel(list, "job");
//    }

    @PostMapping("/remove")
    @ResponseBody
    public ResultModel remove(String ids)
    {
        try
        {
            jobService.deleteJobByIds(ids);
            return ResultModel.success();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResultModel.fail(e.getMessage());
        }
    }

    /**
     * 任务调度状态修改
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public ResultModel changeStatus(SysJob job)
    {
        jobService.changeStatus(job);
        return ResultModel.success("成功");
    }

    /**
     * 任务调度立即执行一次
     */
    @PostMapping("/run")
    @ResponseBody
    public ResultModel run(SysJob job)
    {
        jobService.run(job);
        return ResultModel.success("成功");
    }


    /**
     * 新增保存调度
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultModel addSave(SysJob job)
    {
        jobService.insertJobCron(job);
        return ResultModel.success("成功");
    }

    /**
     * 修改调度
     */
    @GetMapping("/edit/{jobId}")
    public String edit(@PathVariable("jobId") Long jobId, ModelMap mmap)
    {
        mmap.put("job", jobService.selectJobById(jobId));
        return prefix + "/edit";
    }

    /**
     * 修改保存调度
     */
    @PostMapping("/edit")
    @ResponseBody
    public ResultModel editSave(SysJob job)
    {
        jobService.updateJobCron(job);
        return ResultModel.success("成功");
    }
    
    /**
     * 校验cron表达式是否有效
     */
    @PostMapping("/checkCronExpressionIsValid")
    @ResponseBody
    public boolean checkCronExpressionIsValid(SysJob job)
    {
        return jobService.checkCronExpressionIsValid(job.getCronExpression());
    }
}
