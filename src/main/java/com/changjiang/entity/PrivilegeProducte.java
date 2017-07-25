package com.changjiang.entity;
public class PrivilegeProducte {
    private Integer id;
    private Integer producteId;
    private Integer privilegeId;
    public PrivilegeProducte() {
        super();
    }
    public PrivilegeProducte(Integer id,Integer producteId,Integer privilegeId) {
        super();
        this.id = id;
        this.producteId = producteId;
        this.privilegeId = privilegeId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProducteId() {
        return this.producteId;
    }

    public void setProducteId(Integer producteId) {
        this.producteId = producteId;
    }

    public Integer getPrivilegeId() {
        return this.privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

}
