package com.osm.antievil.Tools;

import com.osm.antievil.Entity.Company;
import com.osm.antievil.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.osm.antievil.Tools.PinyinQuery.getPinyin;

/**
 * @author wellCh4n
 * @DESCRIPTION 把现有的更改为拼音
 * @create 2017 - 11 - 13 13:52
 */

@RestController
public class nameToPinYin {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "/tools/topinyin")
    public void run(){
        List<Company> companyList = companyRepository.findAll();
        for (Company c:companyList
             ) {
            System.out.println( c.getName() + " - " +getPinyin(c.getName()));
            Company company = companyRepository.getOne(c.getId());
            company.setPinyinname(getPinyin(c.getName()));
            companyRepository.save(company);
        }
    }
}
