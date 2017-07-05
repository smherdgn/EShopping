package com.indbilisim.base;

import java.util.List;

/**
 * Created by semih on 05.07.2017.
 */

public class JsonListType {

    private Object id;

    private Object text;

    private List<JsonListType> children;

    private List<JsonListType> subchildren;

    public List<JsonListType> getChildren() {

        return children;
    }

    public void setChildren(List<JsonListType> children) {

        this.children = children;
    }

    public Object getId() {

        return id;
    }

    public void setId(Object id) {

        this.id = id;
    }

    public List<JsonListType> getSubchildren() {

        return subchildren;
    }

    public void setSubchildren(List<JsonListType> subchildren) {

        this.subchildren = subchildren;
    }

    public Object getText() {

        return text;
    }

    public void setText(Object text) {

        this.text = text;
    }

}
