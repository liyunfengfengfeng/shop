package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.DbOrder;
import com.changjiang.common.Assist;
public interface DbOrderService{
    long getDbOrderRowCount(Assist assist);
    List<DbOrder> selectDbOrder(Assist assist);
    DbOrder selectDbOrderById(Integer id);
    int insertDbOrder(DbOrder value);
    int insertNonEmptyDbOrder(DbOrder value);
    int deleteDbOrderById(Integer id);
    int deleteDbOrder(Assist assist);
    int updateDbOrderById(DbOrder enti);
    int updateDbOrder(DbOrder value, Assist assist);
    int updateNonEmptyDbOrderById(DbOrder enti);
    int updateNonEmptyDbOrder(DbOrder value, Assist assist);
}