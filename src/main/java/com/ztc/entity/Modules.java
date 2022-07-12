package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @TableName modules
 */
@TableName(value = "modules")
@Data
public class Modules implements Serializable {
    /**
     * 模块编号
     */

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模块名称
     */
    @TableField(value = "Name")
    private String name;
    @TableField(value = "Name")
    private String title;

    /**
     * 父模块编号
     */
    @TableField(value = "ParentId")
    private Integer parentId;
    @TableField(value = "icon")
    private Integer icon;
    /**
     * 模块路径
     */
    @TableField(value = "Path")
    private String path;

    @TableField(value = "type")
    private String type;

    /**
     * 权重
     */
    @TableField(value = "Weight")
    private Double weight;

    /**
     * 预留字符串
     */
    @TableField(value = "Ops")
    private String ops;

    @TableField(exist = false)
    private List<Modules> children;

    @TableField(exist = false)
    private Boolean checked = false;

    public void setChecked(Boolean checked) {
        if (this.children.size() > 0) {
            this.checked = false;
        } else {
            this.checked = checked;
        }

    }

    @TableField(exist = false)
    private Boolean spread = false;

//    @TableField(exist = false)
//    private int page;
//
//    @TableField(exist = false)
//    private int limit;
//
//    @TableField(exist = false)
//    private int offset;
//
//    public int getOffset() {
//        return (page-1)*limit;
//    }
//
//    public void setOffset(Integer offset) {
//        this.offset = offset;
//    }


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}