package org.mrhpolat.model;

import javax.persistence.*;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String bloodGroup;
    private String mobile;
    private String address;
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String isim) {
        this.firstname = isim;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String soyisim) {
        this.lastname = soyisim;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String kanGrubu) {
        this.bloodGroup = kanGrubu;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String cepTelefonu) {
        this.mobile = cepTelefonu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adres) {
        this.address = adres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bloodgroup='" + bloodGroup + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
