package com.example.crc_rajnandangaon;

public class Patient_Reg_Getter_Setter {
    String reg_no, patient_name, father_name,
           age, gender, contact_no,
           occupation, address, referred_by,
           referred_to, chief_complaints;

    public Patient_Reg_Getter_Setter(String reg_no, String patient_name, String father_name, String age, String gender, String contact_no, String occupation, String address, String referred_by, String referred_to, String chief_complaints) {
        this.reg_no = reg_no;
        this.patient_name = patient_name;
        this.father_name = father_name;
        this.age = age;
        this.gender = gender;
        this.contact_no = contact_no;
        this.occupation = occupation;
        this.address = address;
        this.referred_by = referred_by;
        this.referred_to = referred_to;
        this.chief_complaints = chief_complaints;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReferred_by() {
        return referred_by;
    }

    public void setReferred_by(String referred_by) {
        this.referred_by = referred_by;
    }

    public String getReferred_to() {
        return referred_to;
    }

    public void setReferred_to(String referred_to) {
        this.referred_to = referred_to;
    }

    public String getChief_complaints() {
        return chief_complaints;
    }

    public void setChief_complaints(String chief_complaints) {
        this.chief_complaints = chief_complaints;
    }
}
