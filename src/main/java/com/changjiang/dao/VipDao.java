package com.changjiang.dao;
import com.changjiang.entity.Vip;
import java.util.List;
import com.changjiang.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface VipDao{
    long getVipRowCount(Assist assist);
    List<Vip> selectVip(Assist assist);
    Vip selectVipById(Integer id);
    int insertVip(Vip value);
    int insertNonEmptyVip(Vip value);
    int deleteVipById(Integer id);
    int deleteVip(Assist assist);
    int updateVipById(Vip enti);
    int updateVip(@Param("enti") Vip value, @Param("assist") Assist assist);
    int updateNonEmptyVipById(Vip enti);
    int updateNonEmptyVip(@Param("enti") Vip value, @Param("assist") Assist assist);
	/**
	 * 通过店面id查找其下所有的会员信息
	 * @param id
	 * @return
	 */
    List<Vip> queryVipsByStoreId(Integer id);
}