package com.genericmethod.feedfire.mapper;

import com.genericmethod.feedfire.cache.CacheableObject;
import com.genericmethod.feedfire.exception.FeedFireException;

import java.util.List;

/**
 * Handles mapping of a xml feed document (represented as a String) to a generic model object T
 *
 * @author cfarrugia
 */
public abstract class AbstractXmlFeedMapper<T> {

    /**
     * Return a generic model object containing data mapped from the xml feed.
     * @param feedXml The xml feed to be mapped
     * @return A generic model object T containing the xml feed data.
     * @throws Exception
     */
    public abstract List<T> mapXmlToModel(String feedXml) throws FeedFireException;

}
