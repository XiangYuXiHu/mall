package com.smile.common.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @ClassName PageVo
 * @Author smile
 * @date 2022.11.19 20:04
 */
public class PageVo<T> {

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 当前页的数量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将分页后的list转为分页信息
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageVo<T> pageInfo(List<T> list) {
        PageVo<T> pageVo = new PageVo<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageVo.setTotalPage(pageInfo.getPages());
        pageVo.setTotal(pageInfo.getTotal());
        pageVo.setPageSize(pageInfo.getPageSize());
        pageVo.setPageNum(pageInfo.getPageNum());
        pageVo.setList(pageInfo.getList());
        return pageVo;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
