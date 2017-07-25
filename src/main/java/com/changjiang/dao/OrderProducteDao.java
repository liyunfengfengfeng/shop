package com.changjiang.dao;
import com.changjiang.entity.OrderProducte;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface OrderProducteDao{
    long getOrderProducteRowCount(Assist assist);
    List<OrderProducte> selectOrderProducte(Assist assist);
    OrderProducte selectOrderProducteById(Integer id);
    int insertOrderProducte(OrderProducte value);
    int insertNonEmptyOrderProducte(OrderProducte value);
    int deleteOrderProducteById(Integer id);
    int deleteOrderProducte(Assist assist);
    int updateOrderProducteById(OrderProducte enti);
    int updateOrderProducte(@Param("enti") OrderProducte value, @Param("assist") Assist assist);
    int updateNonEmptyOrderProducteById(OrderProducte enti);
    int updateNonEmptyOrderProducte(@Param("enti") OrderProducte value, @Param("assist") Assist assist);
}