package com.osm.antievil.Controller;

import com.osm.antievil.Entity.Company;
import com.osm.antievil.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/searchAll")
    public List<Company> search(){
        return companyRepository.findAll();
    }

    @GetMapping(value = "/findByName")
    public List<Company> companyListByName(@RequestParam("name") String name){
        System.out.println(name);
        return companyRepository.findByNameLike(name);
    }

    @GetMapping(value = "test")
    public String girlListByAge(){
        return companyRepository.findAll().get(1).getName();
    }

}
