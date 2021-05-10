package com.example.NetflixShow.scheduler;

import com.example.NetflixShow.service.ShowDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Autowired
    private ShowDetailsService showDetailsService;

    @Scheduled(cron = "5 * * * * *")
    public void cronJobSch() throws Exception {
        System.out.println("Java Cron job for Data Syncing started.");

        showDetailsService.insertToDb();

        System.out.println("Java Cron job for Data Syncing finished successfully.");
    }
}
