package com.genericmethod.feedfire.filter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Applies a set of filters to an object of type T
 * @param <T> The type of object to be filtered.
 */
public abstract class AbstractFilterChain<T>  {

    List<Filter> filters = new ArrayList<>();

    /**
     * Applies a set of filters to a set of objects of type T.
     * @param objects The object of type T to be filtered
     * @return A list of filtered objects after all the filters in the filter chain have been applied
     */
    public T apply(T objects) {
        T filteredObjects = objects;
        for (Filter filter : filters) {
            filteredObjects = (T) filter.apply(filteredObjects);
        }
        return filteredObjects;
    }

    /**
     * Adds a {@link Filter} object to the filter chain
     * @param filter {@link Filter} to be added.
     */
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @PostConstruct
    public abstract void registerFilters();
}

