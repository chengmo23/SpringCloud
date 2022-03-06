package com.zimo.mapper;

import com.zimo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    int deleteByPrimaryKey(Integer deptNo);

    int insert(Dept record);

    Dept selectByPrimaryKey(Integer deptNo);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}