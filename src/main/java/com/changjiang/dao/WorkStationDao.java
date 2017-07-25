package com.changjiang.dao;
import com.changjiang.entity.WorkStation;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface WorkStationDao{
    long getWorkStationRowCount(Assist assist);
    List<WorkStation> selectWorkStation(Assist assist);
    WorkStation selectWorkStationById(Integer id);
    int insertWorkStation(WorkStation value);
    int insertNonEmptyWorkStation(WorkStation value);
    int deleteWorkStationById(Integer id);
    int deleteWorkStation(Assist assist);
    int updateWorkStationById(WorkStation enti);
    int updateWorkStation(@Param("enti") WorkStation value, @Param("assist") Assist assist);
    int updateNonEmptyWorkStationById(WorkStation enti);
    int updateNonEmptyWorkStation(@Param("enti") WorkStation value, @Param("assist") Assist assist);
    @Select("SELECT * FROM work_station,department WHERE work_station.department_id=department.id AND "
    		+ "department.store_id=#{id}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="name",property="name"),
    	@Result(id=true,column="user_id",property="userId"),
    	@Result(column="go_work_time",property="goWorkTime"),
    	@Result(column="leave_work_time",property="leaveWorkTime"),
    	@Result(column="department_id",property="departmentId")
    })
    List<WorkStation> selectWorkStationByStoreId(Integer id);
	/**
	 * 通过id查询岗位和岗位所对应的记录
	 * @param id
	 * @return
	 */
    List<WorkStation> findWorkStationAndRecord(Integer id);
    /**
	 * 通过id查询岗位和counter_work_station_record
	 */
    List<WorkStation> findWorkStationAndCounterStationRecord(Integer id);
}