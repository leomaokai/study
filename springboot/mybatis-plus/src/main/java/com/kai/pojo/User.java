package com.kai.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 主键自增,在数据库同样需要设置
    @TableId(type = IdType.AUTO)

    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 字段在插入时自动填充
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    // 字段在插入和更新时自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    // 乐观锁字段
    @Version
    private Integer version;

    // 逻辑删除
    @TableLogic
    private Integer deleted;
}
