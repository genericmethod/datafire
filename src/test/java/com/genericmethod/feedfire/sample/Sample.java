package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.CacheableObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author cfarrugia
 */
public class Sample extends CacheableObject {

    @XStreamAlias("id") private String id;
    @XStreamAlias("home") private String home;
    @XStreamAlias("away") private String away;
    @XStreamAlias("homeTeamScore") private String homeTeamScore;
    @XStreamAlias("awayTeamScore") private String awayTeamScore;

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
}
