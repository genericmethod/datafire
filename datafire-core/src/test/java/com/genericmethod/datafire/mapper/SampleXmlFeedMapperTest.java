package com.genericmethod.datafire.mapper;

import com.genericmethod.datafire.exception.DataFireException;
import com.genericmethod.datafire.sample.Sample;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/feed-fire-context-test.xml"})
public class SampleXmlFeedMapperTest {

  @Autowired
  SampleXmlFeedMapper sampleXmlFeedMapper;

  public void testMapXml() throws DataFireException {

    String sampleXmlFeed =
            "<sampleXml>\n"
                    + "    <sample>\n"
                    + "        <id>1</id>\n"
                    + "        <home>Team A</home>\n"
                    + "        <away>Team B</away>\n"
                    + "        <homeTeamScore>1</homeTeamScore>\n"
                    + "        <awayTeamScore>0</awayTeamScore>\n"
                    + "    </sample>\n"
                    + "    <sample>\n"
                    + "        <id>2</id>\n"
                    + "        <home>Team C</home>\n"
                    + "        <away>Team D</away>\n"
                    + "        <homeTeamScore>3</homeTeamScore>\n"
                    + "        <awayTeamScore>1</awayTeamScore>\n"
                    + "    </sample>\n"
                    + "</sampleXml>";

    List<Sample> samples = sampleXmlFeedMapper.mapToModel(sampleXmlFeed);
    assertEquals(2, samples.size());
  }


}