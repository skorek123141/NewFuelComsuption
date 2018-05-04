package com.example.skore.newfuelcomsuption;

public class Model {

    private int id;
    private String amount_fuel;
    private String amount_km;
    private String avg;
    private String data;

    public Model(int id, String amount_km, String amount_fuel, String avg, String data) {
        this.id = id;
        this.amount_km = amount_km;
        this.avg = avg;
        this.amount_fuel = amount_fuel;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAvg() {

        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getAmount_fuel() {

        return amount_fuel;
    }

    public void setAmount_fuel(String amount_fuel) {
        this.amount_fuel = amount_fuel;
    }

    public String getAmount_km() {

        return amount_km;
    }

    public void setAmount_km(String amount_km) {
        this.amount_km = amount_km;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
