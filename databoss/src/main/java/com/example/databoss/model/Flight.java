package com.example.databoss.model;

import org.elasticsearch.common.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "kibana_sample_data_flights", type = "doc")
public class Flight {

    @Id
    private String id;

    @Nullable
    @Field(value = "FlightNum", type = FieldType.Text, fielddata = true)
    private String flightNum;

    @Nullable
    @Field(value = "DestCountry", type = FieldType.Text, fielddata = true)
    private String DestCountry;

    @Nullable
    @Field(value = "AvgTicketPrice", type = FieldType.Double, fielddata = true)
    private String AvgTicketPrice;


    @Nullable
    @Field(value = "Carrier", type = FieldType.Text, fielddata = true)
    private String carrier;



    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestCountry() {
        return DestCountry;
    }

    public void setDestCountry(String destCountry) {
        DestCountry = destCountry;
    }

    public String getAvgTicketPrice() {
        return AvgTicketPrice;
    }

    public void setAvgTicketPrice(String avgTicketPrice) {
        AvgTicketPrice = avgTicketPrice;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        carrier = carrier;
    }
}