package com.changjiang.dao;
import com.changjiang.entity.StoreType;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface StoreTypeDao{
    long getStoreTypeRowCount(Assist assist);
    List<StoreType> selectStoreType(Assist assist);
    StoreType selectStoreTypeById(Integer id);
    int insertStoreType(StoreType value);
    int insertNonEmptyStoreType(StoreType value);
    int deleteStoreTypeById(Integer id);
    int deleteStoreType(Assist assist);
    int updateStoreTypeById(StoreType enti);
    int updateStoreType(@Param("enti") StoreType value, @Param("assist") Assist assist);
    int updateNonEmptyStoreTypeById(StoreType enti);
    int updateNonEmptyStoreType(@Param("enti") StoreType value, @Param("assist") Assist assist);
    /**
     * 通过店面类型查询所有的店面  嵌套结果: 使用嵌套结果映射来处理重复的联合结果的子集
     * @param id
     * @return
     */
    List<StoreType> getStoresByStoreType(Integer id);
}