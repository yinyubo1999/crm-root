package com.shangma.cn.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T>{
    private int status;
    private String message;
    private T data;

    private AxiosResult() {
    }
    public static <T> AxiosResult<T> success(){
        return setData(AxiosStatus.OK,null);
    }
    public static <T> AxiosResult<T> success(T data){
        return setData(AxiosStatus.OK,data);
    }
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus){
        return setData(axiosStatus,null);
    }
    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }
    public static <T> AxiosResult<T> error(){
        return setData(AxiosStatus.ERROR,null);
    }
    public static <T> AxiosResult<T> error(T data){
        return setData(AxiosStatus.ERROR,data);
    }
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus){
        return setData(axiosStatus,null);
    }
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }

    private static <T> AxiosResult<T> setData(AxiosStatus axiosStatus, T data){
        AxiosResult<T> axiosResult = new AxiosResult<>();
        axiosResult.setStatus(axiosStatus.getStatus());
        axiosResult.setMessage(axiosStatus.getMessage());
        axiosResult.setData(data);
        return axiosResult;
    }
}
