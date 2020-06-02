package com.tcs.org.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import com.tcs.org.audit.AuditableEntity;

@Entity

public class Location /*extends AuditableEntity*/ {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
//private int id;
private int locationId;
private int countryId;
private String countryName;
private int branchId;
private String branchName;
private int cityId;
private String cityName;
private String locationName;


//private int locationId;
//private String locationName;
/* @Embedded
@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//@JoinColumn(name=countryId)
private List<Country> country;

public Location(List<Country> country) {
    super();
    this.country = country;
}*/

/*@OneToMany
List<Location> requirement;
*/
public Location() {
}

public Location(int id, int cityId, String cityName, int locationId,
        String locationName ,int branchId, String branchName,int countryId, String countryName) {
    super();
    //this.id = id;
    this.locationId = locationId;
    this.cityId = cityId;
    this.cityName = cityName;
    //this.locationId = locationId;
    this.locationName = locationName;
    this.branchId = branchId;
    this.branchName = branchName;
    this.countryName = countryName;
    this.countryId = countryId;
    //this.requirement = requirement;
}

/*public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}*/

public int getCountryId() {
    return countryId;
}

public void setCountryId(int countryId) {
    this.countryId = countryId;
}

public String getCountryName() {
    return countryName;
}

public void setCountryName(String countryName) {
    this.countryName = countryName;
}

public int getCityId() {
    return cityId;
}

public void setCityId(int cityId) {
    this.cityId = cityId;
}

public String getCityName() {
    return cityName;
}

public void setCityName(String cityName) {
    this.cityName = cityName;
}

public int getLocationId() {
    return locationId;
}

public void setLocationId(int locationId) {
    this.locationId = locationId;
}

public String getLocationName() {
    return locationName;
}

public void setLocationName(String locationName) {
    this.locationName = locationName;
}

public int getBranchId() {
    return branchId;
}

public void setBranchId(int branchId) {
    this.branchId = branchId;
}

public String getBranchName() {
    return branchName;
}

public void setBranchName(String branchName) {
    this.branchName = branchName;
}

/*public List<Country> getCountry() {
    return country;
}

public void setCountry(List<Country> country) {
    this.country = country;
}*/
}

