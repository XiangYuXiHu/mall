package com.smile.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 帮助表
 * </p>
 *
 * @author smile
 * @since 2022-07-02
 */
@ApiModel("cms帮助")
public class CmsHelp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("策略主键")
    private Long categoryId;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 0不展示 1展示
     */
    @ApiModelProperty("0不展示 1展示")
    private Boolean showStatus;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 阅读数量
     */
    @ApiModelProperty("阅读数量")
    private Integer readCount;

    @ApiModelProperty("内容")
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CmsHelp{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title=" + title +
                ", showStatus=" + showStatus +
                ", icon=" + icon +
                ", readCount=" + readCount +
                ", content=" + content +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
