package com.genericmethod.datafire.sample;

import com.genericmethod.datafire.cache.CacheableObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Sample extends CacheableObject {

  @XStreamAlias("id")
  private String id;
  @XStreamAlias("home")
  private String home;
  @XStreamAlias("away")
  private String away;
  @XStreamAlias("homeTeamScore")
  private String homeTeamScore;
  @XStreamAlias("awayTeamScore")
  private String awayTeamScore;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getAway() {
    return away;
  }

  public void setAway(String away) {
    this.away = away;
  }

  public String getHomeTeamScore() {
    return homeTeamScore;
  }

  public void setHomeTeamScore(String homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public String getAwayTeamScore() {
    return awayTeamScore;
  }

  public void setAwayTeamScore(String awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }

  @Override
  public String getCacheId() {
    return id;
  }


  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Sample that = (Sample) o;

    return com.google.common.base.Objects.equal(this.id, that.id)
            && com.google.common.base.Objects.equal(this.home, that.home)
            && com.google.common.base.Objects.equal(this.away, that.away)
            && com.google.common.base.Objects.equal(this.homeTeamScore, that.homeTeamScore)
            && com.google.common.base.Objects.equal(this.awayTeamScore, that.awayTeamScore);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(id, home, away, homeTeamScore, awayTeamScore);
  }
}
