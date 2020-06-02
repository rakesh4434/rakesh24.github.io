package com.tcs.org.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.tcs.model.Category;
import com.tcs.org.model.Location;
//import com.tcs.org.model.Skill;
import com.tcs.org.service.LocationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LocationController {

@Autowired
private LocationService locationService;

@GetMapping("/location")
public List<Location> getAllLocationValues() {
    return locationService.getAllLocations();
}

/* @GetMapping("/location/{countryName}/branch/{branchName}/city/{cityName}/location/{locationName}")
    public List<Location> getLocation(@PathVariable List<String> countryName, @PathVariable List<String> branchName,
            @PathVariable List<String> cityName, @PathVariable List<String> locationName) {
        return locationService.getLocationByCountryBranchCityLocation(countryName, branchName,cityName,locationName);
    }*/


@GetMapping("/location/{countryId}")
public List<Location> getLocation(@PathVariable int countryId) {
    return locationService.getAllLocationVlues(countryId);


}    




@GetMapping("/location/{countryId}/{branchId}")
public List<Location> getLocationByBranchId(@PathVariable int countryId,@PathVariable int branchId) {
    return locationService.getAllLocationVlues(countryId, branchId);


}    



@GetMapping("/location/{countryId}/{branchId}/{cityId}")
public List<Location> getLocationByCityId(@PathVariable int countryId,@PathVariable int branchId,@PathVariable int cityId) {
    return locationService.getAllLocationVlues(countryId, branchId, cityId);


}    



@GetMapping("/location/{countryId}/{branchId}/{cityId}/{locationId}")
public List<Location> getLocationByLocationId(@PathVariable int countryId,@PathVariable int branchId,@PathVariable int cityId,@PathVariable int locationId) {
    return locationService.getAllLocationVlues(countryId, branchId, cityId, locationId);


}    


/* @GetMapping("/location/{id}/country/{countryName}")
    public List<Location> getLocation1( @PathVariable List<String> branchName,
            @PathVariable List<String> cityName, @PathVariable List<String> locationName) {
        return locationService.getLocationByBranchCityLocation(branchName,cityName,locationName);
    }
*/


/*@GetMapping("/location")
public Map<String,List<Location>> getAllLocationVlues() {
    return locationService.getAllLocationVlues();
}*/
}

