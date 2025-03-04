package com.example.spacego.databaseaccess;

import java.util.List;

public class UserDetails {

//    private String id;
    private String first_name;
    private String last_name;
    private String dob;
    private String address;
    private Long mobno;
    private String email;
    private List<Integer> msn_id;



    public UserDetails(String first_name, String last_name, String dob, String address, Long mobno, String email, List<Integer> msn_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.address = address;
        this.mobno = mobno;
        this.email = email;
        this.msn_id = msn_id;
    }

    public UserDetails() {
    }

//    public String getFormId() {
//        return id;
//    }

    public List<Integer> getMsn_id() {
        return msn_id;
    }

    public void setMsn_id(List<Integer> msn_id) {
        this.msn_id = msn_id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobno() {
        return mobno;
    }

    public void setMobno(Long mobno) {
        this.mobno = mobno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
