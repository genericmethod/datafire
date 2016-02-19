package com.genericmethod.datafire.samples.producthunt;

import com.genericmethod.datafire.event.DataFireEvent;
import com.genericmethod.datafire.event.DataFireEventProducer;
import com.genericmethod.datafire.samples.producthunt.enums.ProductHuntEventType;
import com.genericmethod.datafire.samples.producthunt.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductHuntNewPostEventProducer extends DataFireEventProducer<Post,ProductHuntEventType>{

    @Override
    public void sendEvent(List<DataFireEvent<Post, ProductHuntEventType>> events) {
        for (DataFireEvent<Post, ProductHuntEventType> event : events) {
            System.out.println(event.getMessage().getName() + " " + event.getEventType().name());
        }
    }
}
