package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.config.DataFireSchedulerConfig;
import com.genericmethod.datafire.request.DataFireRequestScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.PeriodicTrigger;

@Configuration
public class ProductHuntSchedulerConfig extends DataFireSchedulerConfig {

    @Autowired
    ProductHuntNewPostRequestScheduler productHuntNewPostRequestScheduler;

    @Override
    public DataFireRequestScheduler myTask() {
        return productHuntNewPostRequestScheduler;
    }

    @Override
    public Trigger getTrigger() {
        return new PeriodicTrigger(10000);
    }
}
