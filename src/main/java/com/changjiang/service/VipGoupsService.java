package com.changjiang.service;
import java.util.List;

import com.changjiang.entity.Vip;
import com.changjiang.entity.VipGoups;
import com.changjiang.common.Assist;
public interface VipGoupsService{
    long getVipGoupsRowCount(Assist assist);
    List<VipGoups> selectVipGoups(Assist assist);
    VipGoups selectVipGoupsById(Integer id);
    int insertVipGoups(VipGoups value);
    int insertNonEmptyVipGoups(VipGoups value);
    int deleteVipGoupsById(Integer id);
    int deleteVipGoups(Assist assist);
    int updateVipGoupsById(VipGoups enti);
    int updateVipGoups(VipGoups value, Assist assist);
    int updateNonEmptyVipGoupsById(VipGoups enti);
    int updateNonEmptyVipGoups(VipGoups value, Assist assist);
    /**
	 * 查询所有的会员组信息
	 * @return
	 */
	List<VipGoups> queryAllVipGoups();
	/**
	 * 通过会员组id查询其下所有的会员信息
	 * @param vipgoupsid  会员组id
	 * @return
	 */
	List<Vip> queryAllVipsByVipGoupid(String vipgoupsid);
}