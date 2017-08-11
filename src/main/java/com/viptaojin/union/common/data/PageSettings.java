package com.viptaojin.union.common.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pj on 4/28/17.
 */
public class PageSettings {

    /* 每一页的数量*/
    private int size;

    /* 请求的页数 */
    private int page;

    private Map<String,Object> parameters =new HashMap<String,Object>();

    public PageSettings(int page, int size) {
       this.size = size;
       this.page = page;
    }

    public int getOffset(){
        return this.page * this.size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public PageSettings add(String key,Object obj){
        this.parameters.put(key,obj);
        return this;
    }
}
