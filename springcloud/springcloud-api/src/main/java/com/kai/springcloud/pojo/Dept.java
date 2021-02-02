package com.kai.springcloud.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable { //序列化


    public Dept(String dName) {
        this.dName = dName;
    }

    private long deptNo;
    private String dName;
    private String dbSource;
}
