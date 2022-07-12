package com.ztc.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AutoAllocationTask {

    //可以写多个job

    /**
     * 自动分配咨询师job
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void allocationAskerJob() {
        //


    }
}
