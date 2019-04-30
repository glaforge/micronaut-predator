package io.micronaut.data.model.query.factory;

import io.micronaut.data.model.query.Query;

/**
 * Projections used to customize the results of a query
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public class Projections {
    public static final Query.IdProjection ID_PROJECTION = new Query.IdProjection();
    public static final Query.CountProjection COUNT_PROJECTION = new Query.CountProjection();

    /**
     * Projection used to obtain the id of an object
     * @return The IdProjection instance
     */
    public static Query.IdProjection id() {
        return ID_PROJECTION;
    }

    /**
     * Projection that returns the number of records from the query
     * instead of the results themselves
     *
     * @return The CountProjection instance
     */
    public static Query.CountProjection count() {
        return COUNT_PROJECTION;
    }

    /**
     * A projection that obtains the value of a property of an entity
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public static Query.PropertyProjection property(String name) {
        return new Query.PropertyProjection(name);
    }

    /**
     * Computes the sum of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public static Query.SumProjection sum(String name) {
        return new Query.SumProjection(name);
    }

    /**
     * Computes the min value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public static Query.MinProjection min(String name) {
        return new Query.MinProjection(name);
    }

    /**
     * Computes the max value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public static Query.MaxProjection max(String name) {
        return new Query.MaxProjection(name);
    }

    /**
     * Computes the average value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public static Query.AvgProjection avg(String name) {
        return new Query.AvgProjection(name);
    }

    /**
     * Projection that signifies to return only distinct results
     *
     * @return Distinct projection
     */
    public static Query.DistinctProjection distinct() {
        return new Query.DistinctProjection();
    }

    /**
     * Projection that signifies to return only distinct results
     *
     * @param property The name of the property
     * @return Distinct projection
     */
    public static Query.DistinctPropertyProjection distinct(String property) {
        return new Query.DistinctPropertyProjection(property);
    }

    /**
     * Projection that signifies to return only distinct results
     *
     * @param property The name of the property
     * @return Distinct projection
     */
    public static Query.CountDistinctProjection countDistinct(String property) {
        return new Query.CountDistinctProjection(property);
    }

    /**
     * Defines a group by projection for datastores that support it
     *
     * @param property The property name
     *
     * @return The projection list
     */
    public static Query.GroupPropertyProjection groupProperty(String property) {
        return new Query.GroupPropertyProjection(property);
    }
}