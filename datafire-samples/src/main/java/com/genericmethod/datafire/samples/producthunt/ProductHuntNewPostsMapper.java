package com.genericmethod.datafire.samples.producthunt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genericmethod.datafire.exception.DataFireException;
import com.genericmethod.datafire.mapper.DataFireMapper;
import com.genericmethod.datafire.samples.producthunt.model.Post;
import com.genericmethod.datafire.samples.producthunt.model.ProductHuntNewPostData;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ProductHuntNewPostsMapper extends DataFireMapper<Post>{

    @Override
    public List<Post> mapToModel(String s) throws DataFireException {

        ObjectMapper mapper = new ObjectMapper();
        ProductHuntNewPostData newPostList;

        try {
             newPostList  = mapper.readValue(s, ProductHuntNewPostData.class);
        } catch (IOException e) {
            throw new DataFireException("Could not map data");
        }

        return newPostList.getPosts();
    }
}
