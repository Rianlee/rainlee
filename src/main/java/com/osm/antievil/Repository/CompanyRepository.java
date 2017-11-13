package com.osm.antievil.Repository;

import com.osm.antievil.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    //通过公司名称来查询
    public List<Company> findByNameLike(String name);
}
