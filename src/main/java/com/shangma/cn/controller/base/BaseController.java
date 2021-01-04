package com.shangma.cn.controller.base;

import com.github.pagehelper.PageHelper;
import com.shangma.cn.http.AxiosResult;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<T,ID> {

    @Autowired
    private BaseService<T,ID> baseService;

    @GetMapping
    public AxiosResult<PageVo<T>> findPage(
            @RequestParam(defaultValue = "1" ) int currentPage,
            @RequestParam(defaultValue = "5" ) int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        PageVo<T> pageVo = baseService.findPage();
        return AxiosResult.success(pageVo);
    }
    @GetMapping("{id}")
    public AxiosResult<T> findById(@PathVariable ID id){
        return AxiosResult.success(baseService.findById(id));
    }
    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody T entity){
        return toaxos(baseService.addEntity(entity));
    }

    @PutMapping
    public AxiosResult<Void>updateEntity(@RequestBody T entity){
        return toaxos(baseService.updateEntity(entity));

    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteEntity(@PathVariable ID id){
        return toaxos(baseService.deleteById(id));
    }


    public AxiosResult<Void> toaxos(int row) {
        return row>0?AxiosResult.success():AxiosResult.error();
    }

}
