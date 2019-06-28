package com.jinke.mybatis.sqlsession.defaults;

import com.jinke.mybatis.cfg.Configuration;
import com.jinke.mybatis.sqlsession.SqlSession;
import com.jinke.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
