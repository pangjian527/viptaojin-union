package com.viptaojin.union.dao;

import com.viptaojin.union.common.data.PageResult;
import com.viptaojin.union.common.data.PageSettings;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by pj on 4/28/17.
 */
@Repository
public class BaseRepositoryImpl implements BaseRepository{

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PageResult query(String sql, PageSettings pageSettings) {
        return this.query(sql,null,pageSettings);
    }

    @Override
    public PageResult query(String sql, Class clazz, PageSettings pageSettings) {

        /* 获取到分页接口*/
        String pageSql = this.createPageSql(sql, pageSettings);
        /* 创建查询对象 */
        Query nativeQuery = this.createNativeQuery(pageSql, clazz);

        Map<String,Object> parameters = pageSettings.getParameters();
        parameters.forEach((k,v) ->{
            nativeQuery.setParameter(k,v);
            System.out.println(k);
        });

        /* 将结果转成map返回 */
        if(clazz ==null){
            nativeQuery.unwrap(org.hibernate.SQLQuery.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }

        /* 获取结果集 */
        List resultList = nativeQuery.getResultList();

        /* 获取总记录数 */
        int totalCount = this.getCount(sql, pageSettings);
        return this.getPageResult(resultList,pageSettings,totalCount);
    }

    private PageResult getPageResult(List list,PageSettings pageSettings,int totalCount){

        PageResult pageResult = new PageResult();

        int pageSize = pageSettings.getSize();
        pageResult.setResultList(list);
        int totalPage = (int)Math.ceil((totalCount*1.0)/pageSize);
        pageResult.setTotalPages(totalPage);
        pageResult.setTotalCount(totalCount);
        pageResult.setCurrentPage(pageSettings.getPage());
        pageResult.setPageSize(pageSettings.getSize());

        return pageResult;
    }

    /* 统计数量 */
    private int getCount(String sql,PageSettings pageSettings){

        StringBuffer countSql = new StringBuffer("select count(1) from (");
        countSql.append(sql).append(" ) temp ");

        Query nativeQuery = this.createNativeQuery(countSql.toString(), null);

        Map<String,Object> parameters = pageSettings.getParameters();
        parameters.forEach((k,v) ->{
            nativeQuery.setParameter(k,v);
            System.out.println(k);
        });

        return Integer.valueOf(nativeQuery.getSingleResult().toString());
    }

    private String createPageSql(String sql ,PageSettings pageSettings){

        StringBuffer pageSql = new StringBuffer("select * from (");
        pageSql.append(sql).append(") temp limit ");
        pageSql.append(pageSettings.getOffset());
        pageSql.append(","+ pageSettings.getSize());

        return pageSql.toString();
    }

    @Override
    public List queryAll(String sql, Map<String, Object> parameters, Class clazz) {
        Query nativeQuery = createNativeQuery(sql,clazz);

        if(parameters ==null){
            return nativeQuery.getResultList();
        }

        if(clazz ==null){
            nativeQuery.unwrap(org.hibernate.SQLQuery.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }

        /* 参数遍历 */
        parameters.forEach((k,v) ->{
            nativeQuery.setParameter(k,v);
        });
        return nativeQuery.getResultList();
    }

    @Override
    public List queryAll(String sql, Map<String, Object> parameters) {
        return this.queryAll(sql,parameters,null);
    }

    private Query createNativeQuery(String sql,Class clazz){
        if(clazz !=null){
            return entityManager.createNativeQuery(sql,clazz);
        }else{
            return entityManager.createNativeQuery(sql);
        }
    }
}
