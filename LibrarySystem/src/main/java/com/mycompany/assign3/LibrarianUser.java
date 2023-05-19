package com.mycompany.assign3;

public class LibrarianUser extends User {
    private String Email;
    private String Address;
    private String Phonenumber;

    


    public LibrarianUser(){
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
        this.setID(librarianId);
        this.setName(name);
        this.setAddress(address);
        this.setPhonenumber(phoneNumber);
        this.setEmail(email);
    }

    @Override
    public String lineRepresentation() {
        String data;
        data = this.getID() + "," + this.getName() + "," + this.getEmail() + "," + this.getAddress() + "," + this.getPhonenumber();
        return data;
    }

    @Override
    public String getSearchKey() {
      return this.getID();
    }
}

