package com.practice.authenticationauthorisation.services;

import com.practice.authenticationauthorisation.modules.*;
import com.practice.authenticationauthorisation.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.function.Function;

@Service
public class SignUpService {
    @Autowired
    private RepoBankDetail repoBankDetail;
    @Autowired
    private RepoCity repoCity;
    @Autowired
    private RepoUser repoUser ;
    @Autowired
    private RepoState repoState;
    @Autowired
    private RepoCountry repoCountry;
    @Autowired
    private RepoLocationDetail repoLocationDetail;
    public @ResponseBody User signup(@RequestBody User user)
    {


//         Accessing various details
        List<BankDetail> bankDetails = user.getBankDetailList();
        List<LocationDetail> locationDetails = user.getLocationDetailList();


        List<City> cityDetails = new ArrayList<>();
        for(LocationDetail ld : locationDetails)
        {
            cityDetails.add(ld.getCity());
        }

        List<State> stateDetails = new ArrayList<>();
        for(City cd : cityDetails)
        {
            stateDetails.add(cd.getState());
        }

        List<Country> countryDetails = new ArrayList<>();
        for(State sd : stateDetails)
        {
            countryDetails.add(sd.getCountry());
        }




//         Country FillUp
        for(Country country : countryDetails)
        {
            repoCountry.save(country);
        }

//         State FillUp
        for(State state : stateDetails)
        {
            Country country = new Country();
            country.setId(state.getCountry().getId());
            state.setCountry(country);
            repoState.save(state);
        }

//         City FillUp
        for(City city : cityDetails)
        {
            State state = new State();
            state.setId(city.getState().getId());
            city.setState(state);
            repoCity.save(city);
        }

//         User Table FillUp
        user.setBankDetailList(null);
        user.setLocationDetailList(null);
        repoUser.save(user);

//         Location Details FillUp
        for(LocationDetail ld : locationDetails)
        {
          User newUser = new User();
          newUser.setId(user.getId());

          City newCity = new City();
          newCity.setId(ld.getCity().getId());

          ld.setCity(newCity);
          ld.setUser(newUser);
          repoLocationDetail.save(ld);
        }




        user.setLocationDetailList(locationDetails);
        user.setBankDetailList(bankDetails);
        return user;
    }
}
