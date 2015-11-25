package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.mapper.AbstractXmlFeedMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.List;



@Component
public class SampleXmlFeedMapper extends AbstractXmlFeedMapper<Sample> {

    private static final Logger log = Logger.getLogger(SampleXmlFeedMapper.class);

    @Autowired
    private XStreamMarshaller xStreamMarshaller;

    @Override
    public List<Sample> mapXmlToModel(String feedXml) throws Exception {

        if (StringUtils.isBlank(feedXml)) {
            throw new Exception("Xml feed cannot be null");
        }

        log.debug("Mapping retrieved event xml to Sample model objects.");

        Source src = new StreamSource(new java.io.StringReader(feedXml));
        List<Sample> samples = null;
        try {
            samples = (List<Sample>) xStreamMarshaller.unmarshal(src);
        } catch (IOException e) {
            log.error("Failed to read xml source.", e);
            throw new Exception(e);
        }

        return samples;
    }
}

