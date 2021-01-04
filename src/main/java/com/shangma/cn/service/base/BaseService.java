package com.shangma.cn.service.base;

import com.shangma.cn.vo.PageVo;

import java.util.List;

public interface BaseService<T,ID> {

    //有条件的分页查询
    PageVo<T>findPage(Object example);
    //分页查询
    PageVo<T> findPage();
    //根据id查询
    T findById(ID id);

    //添加
    int addEntity(T entity);
    //修改
    int updateEntity(T entity);
    //删除
    int deleteById(ID id);
    //批量添加
    int batchAddEntity(List<T> list);
    //批量修改
    int batchupdateEntity(List<T> list);
    //批量删除
    int batchdeleteEntity(List<ID> ids);
    //封装分页数据
    PageVo<T> setPageVo(List<T>list);
}
