package base.domain;

import java.util.List;

//分页的JavaBean
public class PageBean<T> {
    private int pageCode = 1;//页号
    private int totalCount;//总数据
    private int pageSize;//页大小
    private List<T> beanList;//数据

    //调用getTotal Page()获取到总页数,JavaBean的属性规定:totalPage是JavaBean属性${pageBean.totalPage}
    public int getTotalPage() {
        //计算
        int totalPage = totalCount / pageSize;
        //判断是否整除
        if (totalCount % pageSize != 0) {
            totalPage += 1;
        }
        return totalPage;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
