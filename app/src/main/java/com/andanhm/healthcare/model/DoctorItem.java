package com.andanhm.healthcare.model;

/**
 * Java been class to DoctorItem object is serializable
 */

public class DoctorItem {
    private String txtName;
    private String txtDepartment;
    private String imgUrl;
    private String txtAboutUs;
    private String txtId;

    DoctorItem() {

    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(String txtDepartment) {
        this.txtDepartment = txtDepartment;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTxtAboutUs() {
        return txtAboutUs;
    }

    public void setTxtAboutUs(String txtAboutUs) {
        this.txtAboutUs = txtAboutUs;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }
}
