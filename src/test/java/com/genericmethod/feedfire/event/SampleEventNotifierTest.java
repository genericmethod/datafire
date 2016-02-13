package com.genericmethod.feedfire.event;

import com.genericmethod.feedfire.cache.CacheKey;
import com.genericmethod.feedfire.sample.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@Ignore
public class SampleEventNotifierTest {

  @InjectMocks
  SampleEventNotifier sampleEventNotifier;

  @Spy
  SampleEventProducer sampleEventProducer;

  @Spy
  SampleCacheService sampleCacheService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreatedEvent() throws Exception {

    SampleXml sampleXml = new SampleXml();
    List<Sample> samples = new ArrayList<>();
    Sample sample = new Sample();
    sample.setHome("Team A");
    sample.setAway("Team B");
    sample.setHomeTeamScore("1");
    sample.setAwayTeamScore("2");
    sample.setId("1");
    samples.add(sample);
    sampleXml.setSamples(samples);
    sampleEventNotifier.updateCacheAndGenerateEvents(samples, new ConcurrentHashMap<CacheKey, Sample>());

    assertEquals(1, sampleCacheService.getAll().size());
    assertEquals(sample, sampleCacheService.get(new CacheKey(sample.getId())));
    //verify(sampleEventProducer).sendEvent(new Event<>(sample, Enum.CREATED));

  }

  @Test
  public void testUpdatedEvent() throws Exception {

    List<Sample> feedSamples = new ArrayList<>();
    Sample modifiedSample = new Sample();
    modifiedSample.setHome("Team A");
    modifiedSample.setAway("Team B");
    modifiedSample.setHomeTeamScore("2");
    modifiedSample.setAwayTeamScore("2");
    modifiedSample.setId("1");
    feedSamples.add(modifiedSample);

    final ConcurrentHashMap<CacheKey, Sample> cacheObjects = new ConcurrentHashMap<>();
    Sample originalSample = new Sample();
    originalSample.setHome("Team A");
    originalSample.setAway("Team B");
    originalSample.setHomeTeamScore("1");
    originalSample.setAwayTeamScore("2");
    originalSample.setId("1");
    cacheObjects.put(new CacheKey(originalSample.getId()), originalSample);

    sampleEventNotifier.updateCacheAndGenerateEvents(feedSamples, cacheObjects);

    assertEquals(1, sampleCacheService.getAll().size());
    assertEquals(modifiedSample, sampleCacheService.get(new CacheKey(originalSample.getId())));
    //verify(sampleEventProducer).sendEvent(new Event<>(modifiedSample, Enum.UPDATED));
  }

  @Test
  public void testDeletedEvent() throws Exception {

    List<Sample> feedSamples = new ArrayList<>();

    final ConcurrentHashMap<CacheKey, Sample> cacheObjects = new ConcurrentHashMap<>();
    Sample originalSample = new Sample();
    originalSample.setHome("Team A");
    originalSample.setAway("Team B");
    originalSample.setHomeTeamScore("1");
    originalSample.setAwayTeamScore("2");
    originalSample.setId("1");
    cacheObjects.put(new CacheKey(originalSample.getId()), originalSample);

    sampleEventNotifier.updateCacheAndGenerateEvents(feedSamples, cacheObjects);

    assertEquals(0, sampleCacheService.getAll().size());
    assertNull(sampleCacheService.get(new CacheKey(originalSample.getId())));
    //verify(sampleEventProducer).sendEvent(new Event<>(originalSample, Enum.DELETED));

  }
}
