package com.jinke.mybatis.sqlsession.proxy;

import com.jinke.mybatis.cfg.Mapper;
import com.jinke.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper, connection);
    }
}
