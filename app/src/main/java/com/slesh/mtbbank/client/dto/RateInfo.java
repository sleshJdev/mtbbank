package com.slesh.mtbbank.client.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rates")
public class RateInfo {

    @Attribute
    private String name;

    @Attribute
    private String date;

    @ElementList(inline = true)
    private List<Department> departments;

    @ElementList
    private List<Currency> payokay;

    @ElementList
    private List<Currency> best;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Currency> getPayokay() {
        return payokay;
    }

    public List<Currency> getBest() {
        return best;
    }
}
