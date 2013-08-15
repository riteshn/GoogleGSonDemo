/**
 * 
 */
package com.rnath.domain;

import java.util.List;

/**
 * POJO class for json mapping.
 * @author rnath
 *
 */
public class Departments 
{
	private String title;
    private Long id;
    private Boolean children;
    private List<Departments> groups;

    public String getTitle() { return title; }
    public Long getId() { return id; }
    public Boolean getChildren() { return children; }
    public List<Departments> getGroups() { return groups; }

    public void setTitle(String title) { this.title = title; }
    public void setId(Long id) { this.id = id; }
    public void setChildren(Boolean children) { this.children = children; }
    public void setGroups(List<Departments> groups) { this.groups = groups; }

    public String toString() {
        return "title:" + title + ",id:" + id + ",children:" + children + ",groups:" + groups;
    }

}
