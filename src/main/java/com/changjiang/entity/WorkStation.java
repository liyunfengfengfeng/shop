package com.changjiang.entity;

import java.util.List;

public class WorkStation {
    private Integer id;
    private String name;
    private Integer userId;
    private java.util.Date goWorkTime;
    private java.util.Date leaveWorkTime;
    private Integer departmentId;
    //一个岗位对应多条记录
    List<WorkstationRecord> workstationRecords;
    //一个岗位对应多条counter_work_station_record
    List<CounterWorkStationRecord> counterWorkStationRecords;
    public WorkStation() {
        super();
    }
    public WorkStation(Integer id,String name,Integer userId,java.util.Date goWorkTime,java.util.Date leaveWorkTime,Integer departmentId) {
        super();
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.goWorkTime = goWorkTime;
        this.leaveWorkTime = leaveWorkTime;
        this.departmentId = departmentId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public java.util.Date getGoWorkTime() {
        return this.goWorkTime;
    }

    public void setGoWorkTime(java.util.Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    public java.util.Date getLeaveWorkTime() {
        return this.leaveWorkTime;
    }

    public void setLeaveWorkTime(java.util.Date leaveWorkTime) {
        this.leaveWorkTime = leaveWorkTime;
    }

    public Integer getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
	public List<WorkstationRecord> getWorkstationRecords() {
		return workstationRecords;
	}
	public void setWorkstationRecords(List<WorkstationRecord> workstationRecords) {
		this.workstationRecords = workstationRecords;
	}
	public List<CounterWorkStationRecord> getCounterWorkStationRecords() {
		return counterWorkStationRecords;
	}
	public void setCounterWorkStationRecords(List<CounterWorkStationRecord> counterWorkStationRecords) {
		this.counterWorkStationRecords = counterWorkStationRecords;
	}

}
