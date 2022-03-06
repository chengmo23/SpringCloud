package com.zimo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门实体类
 * Created by Zimo on 2022/3/5.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptNo;
    private String deptName;
    private String dbSource;
}
