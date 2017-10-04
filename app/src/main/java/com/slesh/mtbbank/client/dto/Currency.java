package com.slesh.mtbbank.client.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "currency")
public class Currency  {

    @Element
    private String code;

    @Element
    private String codeTo;

    @Element
    private BigDecimal purchase;

    @Element
    private BigDecimal sale;

    @Element(required = false)
    private int cacheless;


    public String getCode() {
        return code;
    }

    public String getCodeTo() {
        return codeTo;
    }

    public BigDecimal getPurchase() {
        return purchase;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public int getCacheless() {
        return cacheless;
    }
}
