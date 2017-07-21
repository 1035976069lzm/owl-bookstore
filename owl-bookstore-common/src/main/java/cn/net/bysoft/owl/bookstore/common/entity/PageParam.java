package cn.net.bysoft.owl.bookstore.common.entity;

import java.io.Serializable;

/**
 * 分页参数的实体类。<br>
 * 设置对象的当前页数和每页记录数，进行数据库分页查询。
 * 
 * @author XuePeng
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = 6297178964005032338L;
    private int pageNum;
    private int numPerPage;

    public PageParam(int pageNum, int numPerPage) {
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

}
