package com.genericmethod.datafire.sample;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


@XStreamAlias("sampleXml")
public class SampleXml {
  @XStreamImplicit(itemFieldName = "com/genericmethod/datafire/sample")
  List<Sample> samples;

  public List<Sample> getSamples() {
    return samples;
  }

  public void setSamples(List<Sample> samples) {
    this.samples = samples;
  }
}
