package com.quartz.controller;

import com.htkj.system.quartz.model.SysJob;
import com.htkj.system.quartz.service.ISysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/monitor/job")
public class TestController  {

    @Autowired
    private ISysJobService jobService;
    /**
     * 任务调度立即执行一次
     */
    @PostMapping("/run")
    @ResponseBody
    public Object run(SysJob job) {
        System.err.println("定时器初始化配置   controller  =====================>>>>!");
        jobService.run(job);
        return null ;
    }
}
