package com.osm.antievil.Controller;

import com.osm.antievil.Entity.Company;
import com.osm.antievil.Repository.CompanyRepository;
import com.osm.antievil.Tools.PinyinQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.osm.antievil.Tools.PinyinQuery.changeToPinyin;
import static com.osm.antievil.Tools.PinyinQuery.getPinyin;

/**
 * @author airxiao
 * @DESCRIPTION
 * @create 2017 - 11 - 12 20:59
 */
@RestController
public class SearchController {

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * 查询所有结果
     * @return 返回公司所有的信息集合
     */
    @GetMapping(value = "/searchAll")
    public List<Company> search(){
        return companyRepository.findAll();
    }

    /**
     *
     * @param name 需要查询的公司中文名称
     * @return 返回查询到的公司集合
     */
    @GetMapping(value = "/findByName")
    public List<Company> companyListByName(@RequestParam("name") String name){
        //System.out.println(name);
        String newName=changeToPinyin(name);
        return companyRepository.findByPinyinnameLike(newName);
    }


    @GetMapping(value = "test")
    public Company girlListByAge(){
        Company c=new Company();
        c.setName("中文");
        c.setPinyinname("zhongwen");
        c.setN(0.0);
        c.setAddress("中文,勉强可以用");
        c.setCid(202);
        c.setPid(19);
        return companyRepository.save(c);
}

}
