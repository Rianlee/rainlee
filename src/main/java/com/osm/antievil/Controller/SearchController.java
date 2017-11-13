package com.osm.antievil.Controller;

import com.osm.antievil.Entity.Company;
import com.osm.antievil.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author airxiao
 * @DESCRIPTION
 * @create 2017 - 11 - 12 20:59
 */
@RestController
public class SearchController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "/hello")
    public List<Company> hello(){
        return companyRepository.findAll();
    }

}
