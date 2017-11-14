package com.osm.antievil.Repository;

import com.osm.antievil.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    //通过公司名称来查询
    @Query("select c from Company c where name like %?1%")
    public List<Company> findByNameLike(String name);
    //通过公司拼音名称查询
    @Query("select pinyin from Company pinyin where pinyinname like %?1%")
    public List<Company> findByPinyinnameLike(String pinyinname);

}
