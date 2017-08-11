package com.viptaojin.union.dao;

import com.viptaojin.union.common.data.PageResult;
import com.viptaojin.union.common.data.PageSettings;

import java.util.List;
import java.util.Map;

/**
 * Created by pj on 4/28/17.
 */
public interface BaseRepository {

    public PageResult query(String sql, PageSettings pageSettings);

    public PageResult query(String sql, Class clazz, PageSettings pageCustomRequest);

    public List queryAll(String sql, Map<String, Object> parameters, Class clazz);

    public List queryAll(String sql, Map<String, Object> parameters);
}
