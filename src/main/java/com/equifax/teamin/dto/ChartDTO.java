package com.equifax.teamin.dto;


import java.util.List;

public class ChartDTO {

    private String label;
    private String type;
    private String styleClass;
    private boolean expanded;
    private String data;
    private List<ChartDTO> children;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<ChartDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ChartDTO> children) {
        this.children = children;
    }
}
