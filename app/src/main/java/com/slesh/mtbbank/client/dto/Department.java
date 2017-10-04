package com.slesh.mtbbank.client.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by yauheni on 9/27/17.
 */


@Root(name = "department")
public class Department {

    @Attribute
    private String id;

    @Attribute(name = "x")
    private double longitude;

    @Attribute(name = "y")
    private double latitude;

    @Attribute
    private String label;

    @Attribute
    private String address;

    @Attribute
    private String city;

    @ElementList(inline = true)
    List<Currency> currencies;

    public String getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getLabel() {
        return label;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
