package com.viptaojin.union.common.data;

import java.util.List;

/**
 * Created by pj on 4/28/17.
 */
public class PageResult<T> {

    private List<T> resultList;

    /* 总记录数 */
    private int totalCount;

    /* 总页数 */
    private int totalPages;

    private int currentPage;

    /* 每一页的大小 */
    private int pageSize;

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
