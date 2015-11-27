package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.exception.FeedFireException;
import com.genericmethod.feedfire.mapper.AbstractXmlFeedMapper;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SampleXmlFeedMapper extends AbstractXmlFeedMapper<Sample> {

    private static final Logger log = Logger.getLogger(SampleXmlFeedMapper.class);

    @Override
    public List<Sample> mapXmlToModel(String feedXml) throws FeedFireException {

        if (StringUtils.isBlank(feedXml)) {
            throw new FeedFireException("Xml feed cannot be null");
        }

        log.debug("Mapping retrieved event xml to Sample model objects.");
        XStream xStream = new XStream();
        xStream.processAnnotations(SampleXml.class);
        SampleXml sample = (SampleXml) xStream.fromXML(feedXml);

        return sample.getSamples();
    }
}
