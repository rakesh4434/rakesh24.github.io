package com.tcs.org.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
Location findByLocationId(int locationId);
List<Location> findByCountryId(int countryId);
List<Location> findByCountryIdInAndBranchId(int countryId,int branchId);
List<Location> findByCountryIdInAndBranchIdInAndCityId(int countryId,int branchId,int cityId);
List<Location> findByCountryIdInAndBranchIdInAndCityIdInAndLocationId(int countryId,int branchId,int cityId,int locationId);

/*List<Location> findByCountryNameInAndBranchNameInAndCityNameInAndLocationNameIn(List<String> countryName, List<String> branchName,List<String> cityName,List<String> locationName);

List<Location> findDistinctByBranchNameInAndCityNameInAndLocationNameIn( List<String> branchName,List<String> cityName,List<String> locationName);*/
}

