package com.tcs.org.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tcs.org.model.Category;
import com.tcs.org.model.Location;
import com.tcs.org.model.ProjectDetails;
//import com.tcs.model.Skill;
import com.tcs.org.repository.LocationRepository;

@Service
public class LocationService {

@Autowired
private LocationRepository locationRepository;



public Location getLocation(int locationId) {
	return locationRepository.getOne(locationId);
}




/*public Map<String, List<Location>> getAllLocationVlues() {

    List<Location> locationList = locationRepository.findAll();

    Map<String, List<Location>> locationMap = locationList.stream().
            collect(Collectors.groupingBy(Location::getCountryId));

    return locationMap;
}*/

public List<Location> getAllLocations() {
    return locationRepository.findAll();
}

/*public Location  getLocation(int countryId) {
    return locationRepository.findByCountryId(countryId);
}
*/
public List<Location> getAllLocationVlues(int countryId) {

    return locationRepository.findByCountryId(countryId);
}
public List<Location> getAllLocationVlues(int countryId, int branchId) {

return locationRepository.findByCountryIdInAndBranchId(countryId,branchId);
}

public List<Location> getAllLocationVlues(int countryId, int branchId,int cityId) {

return locationRepository.findByCountryIdInAndBranchIdInAndCityId(countryId,branchId,cityId);
}

public List<Location> getAllLocationVlues(int countryId, int branchId,int cityId,int locationId) {

return locationRepository.findByCountryIdInAndBranchIdInAndCityIdInAndLocationId(countryId,branchId,cityId,locationId);
}

/*public List<Location> getLocationByCountryBranchCityLocation(List<String> countryName, List<String> branchName, List<String> cityName,
        List<String> locationName) {
    List<Location> location = new ArrayList<>();
    questionRepository.findDistinctByImpactInAndModuleInAndIndustryRelevanceIn(impact, module,industryList)
    .forEach(questions::add);
    List<Question> questions1 = new ArrayList<>();
    locationRepository.findDistinctByCountryNameInAndBranchNameInAndCityNameInAndLocationNameIn(countryName, branchName,cityName,locationName)
    .forEach(location::add);

    //questions1.forEach(System.out::println);
    return location;
}*/



/*
public List<Location> getLocationByBranchCityLocation( List<String> branchName, List<String> cityName,
        List<String> locationName) {
    List<Location> location1 = new ArrayList<>();
    questionRepository.findDistinctByImpactInAndModuleInAndIndustryRelevanceIn(impact, module,industryList)
    .forEach(questions::add);
    List<Question> questions1 = new ArrayList<>();
    locationRepository.findDistinctByBranchNameInAndCityNameInAndLocationNameIn(branchName,cityName,locationName)
    .forEach(location1::add);

    //questions1.forEach(System.out::println);
    return location1;
}*/

/*public List<Location> getAllLocationValues(String locationName) {
    // TODO Auto-generated method stub
    return null;
}

public List<Location> getAllLocationValues(String locationName) {
    // TODO Auto-generated method stub
    return null;
}*/
}

