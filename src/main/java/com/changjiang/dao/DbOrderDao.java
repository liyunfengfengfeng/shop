package com.changjiang.dao;
import com.changjiang.entity.DbOrder;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface DbOrderDao{
    long getDbOrderRowCount(Assist assist);
    List<DbOrder> selectDbOrder(Assist assist);
    DbOrder selectDbOrderById(Integer id);
    int insertDbOrder(DbOrder value);
    int insertNonEmptyDbOrder(DbOrder value);
    int deleteDbOrderById(Integer id);
    int deleteDbOrder(Assist assist);
    int updateDbOrderById(DbOrder enti);
    int updateDbOrder(@Param("enti") DbOrder value, @Param("assist") Assist assist);
    int updateNonEmptyDbOrderById(DbOrder enti);
    int updateNonEmptyDbOrder(@Param("enti") DbOrder value, @Param("assist") Assist assist);
}