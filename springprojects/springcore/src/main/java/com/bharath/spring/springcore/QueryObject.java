package com.bharath.spring.springcore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JIQUERY")
public class QueryObject {

    public QueryObject() {
    }

    @Id
    @Column(name="id")
    int id;
    @Column(name="datasource")
    int datasource;

    @Column(name="query_language")
    String querylanguage;
    @Column(name="sql_query")
    String sqlquery;

    @Override
    public String toString() {
        return "QueryObject{" +
                "id=" + id +
                ", datasource=" + datasource +
                ", querylanguage='" + querylanguage + '\'' +
                ", sqlquery='" + sqlquery + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDatasource() {
        return datasource;
    }

    public void setDatasource(int datasource) {
        this.datasource = datasource;
    }

    public String getQuerylanguage() {
        return querylanguage;
    }

    public void setQuerylanguage(String querylanguage) {
        this.querylanguage = querylanguage;
    }

    public String getSqlquery() {
        return sqlquery;
    }

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    public int getId() {
        return id;
    }
}
