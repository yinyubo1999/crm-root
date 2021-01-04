package com.shangma.cn.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.shangma.cn.mapper.base.BaseMapper;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Service
//@Transactional
public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {
    @Autowired
    private BaseMapper<T,ID> baseMapper;

    @Override
    public PageVo<T> findPage(Object example) {
        return setPageVo(baseMapper.selectByExample(example));
    }

    @Override
    public PageVo<T> findPage() {
        return setPageVo(baseMapper.selectByExample(null));
    }

    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchAddEntity(List<T> list) {
        list.forEach(item->baseMapper.insert(item));
        return 1;
    }

    @Override
    public int batchupdateEntity(List<T> list) {
        list.forEach(item->baseMapper.updateByPrimaryKey(item));
        return 1;
    }

    @Override
    public int batchdeleteEntity(List<ID> list) {
        list.forEach(item->baseMapper.deleteByPrimaryKey(item));
        return 1;
    }

    @Override
    public PageVo<T> setPageVo(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>();
        long total = pageInfo.getTotal();
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setTotal(total);
        pageVo.setList(list);
        return pageVo;
    }
}
