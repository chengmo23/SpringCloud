package com.zimo.service;

import com.zimo.entity.Dept;

import java.util.List;

/**
 * Created by Zimo on 2022/3/5.
 */
public interface DeptService {

    Dept get(Integer deptNo);

    List<Dept> selectAll();
}
