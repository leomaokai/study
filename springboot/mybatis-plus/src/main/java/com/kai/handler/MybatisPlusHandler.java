package com.kai.handler;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Component
@Slf4j
public class MybatisPlusHandler implements MetaObjectHandler {

    private final static Date DATE_TIME = new Date();

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start auto insert createDate");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)

        this.setFieldValByName("createDate", DATE_TIME, metaObject);
        this.setFieldValByName("updateDate", DATE_TIME, metaObject);
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start auto update updateDate");
        this.setFieldValByName("updateDate", DATE_TIME, metaObject);
    }
}
