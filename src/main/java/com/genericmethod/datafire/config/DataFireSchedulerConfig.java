package com.genericmethod.datafire.config;

import com.genericmethod.datafire.request.DataFireRequestScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public abstract class DataFireSchedulerConfig implements SchedulingConfigurer {

    @Bean
    public abstract DataFireRequestScheduler myTask();

    public abstract Trigger getTrigger();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler());
        taskRegistrar.addTriggerTask(
                new Runnable() {
                    public void run() {
                        myTask().work();
                    }
                },
                getTrigger()
        );
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(100);
    }
}