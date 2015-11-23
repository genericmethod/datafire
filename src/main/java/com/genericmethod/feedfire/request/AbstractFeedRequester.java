package com.genericmethod.feedfire.request;

import com.genericmethod.feedfire.http.interceptor.GzipRequestInterceptor;
import com.genericmethod.feedfire.http.interceptor.GzipResponseInterceptor;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 *
 * Requests and downloads an xml feed.
 * If request fails, retries a number of times specified by getMaximumRetry()
 *
 * @author cfarrugia
 */
public abstract class AbstractFeedRequester implements FeedRequester {

    private static Logger log = Logger.getLogger(AbstractFeedRequester.class);

    @Autowired private RestTemplate restTemplate;
    @Autowired private DefaultHttpClient httpClient;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        httpClient.addResponseInterceptor(new GzipResponseInterceptor());
        httpClient.addRequestInterceptor(new GzipRequestInterceptor());
    }

    /**
     * Return the url of the feed to download
     * @return the xml feed url
     */
    public abstract String getFeedUrl();

    /**
     * The maximum number of times to retry requesting and downloading the field.
     * @return the maximum number of retries.
     */
    public abstract Integer getMaximumRetry();

    /** Uses the rest template to download the feed.
     * @return
     * @throws Exception
     */
    public String requestAndGet() throws Exception {

        int retry = 0;
        String xmlFeed = null;

        log.debug("Requesting event feed for ["+getFeedUrl()+"]");
        while (xmlFeed == null && retry < getMaximumRetry()) {
            try {
                xmlFeed = restTemplate.getForObject(getFeedUrl(), String.class);
                log.debug("Xml feed retrieved at attempt ["+retry+"] ["+getFeedUrl()+"] at ["+new DateTime()+"]");
            }
            catch (Throwable t){
                log.error("Try ["+retry+"] failed to retrieve feed url["+getFeedUrl()+"]",t);
                retry++;
            }
        }
        return xmlFeed;
    }

}
