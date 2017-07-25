package com.changjiang.entity;
//流水号
public class SysCodeRule {
    private Integer id;
    private String areaprefix;
    private String areatime;
    private Integer glidebit;
    private String currentcode;
    private String available;
    private String nextseq;
    private String curdate;
    public SysCodeRule() {
        super();
    }
    public SysCodeRule(Integer id,String areaprefix,String areatime,Integer glidebit,String currentcode,String available,String nextseq,String curdate) {
        super();
        this.id = id;
        this.areaprefix = areaprefix;
        this.areatime = areatime;
        this.glidebit = glidebit;
        this.currentcode = currentcode;
        this.available = available;
        this.nextseq = nextseq;
        this.curdate = curdate;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaprefix() {
        return this.areaprefix;
    }

    public void setAreaprefix(String areaprefix) {
        this.areaprefix = areaprefix;
    }

    public String getAreatime() {
        return this.areatime;
    }

    public void setAreatime(String areatime) {
        this.areatime = areatime;
    }

    public Integer getGlidebit() {
        return this.glidebit;
    }

    public void setGlidebit(Integer glidebit) {
        this.glidebit = glidebit;
    }

    public String getCurrentcode() {
        return this.currentcode;
    }

    public void setCurrentcode(String currentcode) {
        this.currentcode = currentcode;
    }

    public String getAvailable() {
        return this.available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getNextseq() {
        return this.nextseq;
    }

    public void setNextseq(String nextseq) {
        this.nextseq = nextseq;
    }

    public String getCurdate() {
        return this.curdate;
    }

    public void setCurdate(String curdate) {
        this.curdate = curdate;
    }

}
