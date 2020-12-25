package com.example.emsdriver;

class Drivers {
    String dId;
    String dName;
    String dEmail;
    String dPhone;
    String dLicense;
    public Drivers(){

    }

    public Drivers(String dName, String dEmail, String dPhone, String dLicense) {
        this.dName = dName;
        this.dEmail=dEmail;
        this.dPhone = dPhone;
        this.dLicense = dLicense;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public void setdLicense(String dLicense) {
        this.dLicense = dLicense;
    }

    public String getdId() {
        return dId;
    }

    public String getdName() {
        return dName;
    }

    public String getdEmail() {
        return dEmail;
    }

    public String getdPhone() {
        return dPhone;
    }

    public String getdLicense() {
        return dLicense;
    }
}
