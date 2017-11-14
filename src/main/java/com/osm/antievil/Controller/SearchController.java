package com.osm.antievil.Controller;

import com.osm.antievil.Entity.Company;
import com.osm.antievil.Repository.CompanyRepository;
import com.osm.antievil.Tools.CompareString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.osm.antievil.Tools.PinyinQuery.changeToPinyin;

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

    @GetMapping(value = "/findVague")
    public List<Company> companyListVague(@RequestParam("name") String name,@RequestParam("area") String area){
        CompareString compareString = new CompareString();
        String newName=changeToPinyin(name);
        String newArea=changeToPinyin(area);
        //查询所有结果
        List<Company> allResult =  companyRepository.findAll();
        List<Company> returnResult= new ArrayList<Company>();
        //循环遍历出它们的pinyinname
        //用输入的name去比较
        //相似度大于0.7,就存下来
        for (Company c:allResult) {
            float result= compareString.getSimilarityRatio(newName, c.getPinyinname());
            if(result>0.3){
                System.out.println(c.getName()+"---"+result);
                returnResult.add(c);
            }
        }


        return returnResult;
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
