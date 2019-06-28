package com.jinke.mybatis.sqlsession;

import com.jinke.mybatis.cfg.Configuration;
import com.jinke.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.jinke.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
