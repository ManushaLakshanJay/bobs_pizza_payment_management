package com.example.paymentapp2;

public class PayMethodModelClass {

    private int id;
    private String name;
    private String carno;
    private String cvv;
    private String expdate;

    public PayMethodModelClass(int id, String name, String carno, String cvv, String expdate) {
        this.id = id;
        this.name = name;
        this.carno = carno;
        this.cvv = cvv;
        this.expdate = expdate;
    }

    public PayMethodModelClass(String name, String carno, String cvv, String expdate) {
        this.name = name;
        this.carno = carno;
        this.cvv = cvv;
        this.expdate = expdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }
}
