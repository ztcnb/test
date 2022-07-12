package com.ztc.entity;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfo {
    private String ops;
    private Integer id;
    private Integer parentId;
    private String title;
    private String icon;
    private String href;
    private String target;
    private List<MenuInfo> child;
}
