package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.VipGoupsDao;
import com.changjiang.entity.Vip;
import com.changjiang.entity.VipGoups;
import com.changjiang.common.Assist;
@Service
public class VipGoupsServiceImpl implements VipGoupsService{
    @Autowired
	private VipGoupsDao vipGoupsDao;
    @Override
    public long getVipGoupsRowCount(Assist assist){
        return vipGoupsDao.getVipGoupsRowCount(assist);
    }
    @Override
    public List<VipGoups> selectVipGoups(Assist assist){
        return vipGoupsDao.selectVipGoups(assist);
    }
    @Override
    public VipGoups selectVipGoupsById(Integer id){
        return vipGoupsDao.selectVipGoupsById(id);
    }
    @Override
    public int insertVipGoups(VipGoups value){
        return vipGoupsDao.insertVipGoups(value);
    }
    @Override
    public int insertNonEmptyVipGoups(VipGoups value){
        return vipGoupsDao.insertNonEmptyVipGoups(value);
    }
    @Override
    public int deleteVipGoupsById(Integer id){
        return vipGoupsDao.deleteVipGoupsById(id);
    }
    @Override
    public int deleteVipGoups(Assist assist){
        return vipGoupsDao.deleteVipGoups(assist);
    }
    @Override
    public int updateVipGoupsById(VipGoups enti){
        return vipGoupsDao.updateVipGoupsById(enti);
    }
    @Override
    public int updateVipGoups(VipGoups value, Assist assist){
        return vipGoupsDao.updateVipGoups(value,assist);
    }
    @Override
    public int updateNonEmptyVipGoupsById(VipGoups enti){
        return vipGoupsDao.updateNonEmptyVipGoupsById(enti);
    }
    @Override
    public int updateNonEmptyVipGoups(VipGoups value, Assist assist){
        return vipGoupsDao.updateNonEmptyVipGoups(value,assist);
    }

    public VipGoupsDao getVipGoupsDao() {
        return this.vipGoupsDao;
    }

    public void setVipGoupsDao(VipGoupsDao vipGoupsDao) {
        this.vipGoupsDao = vipGoupsDao;
    }
    /**
	 * 查询所有的会员组信息
	 * @return
	 */
	@Override
	public List<VipGoups> queryAllVipGoups() {
		Assist assist = new Assist();
		return vipGoupsDao.selectVipGoups(assist);
	}
	/**
	 * 通过会员组id查询其下所有的会员信息
	 * @param vipgoupsid  会员组id
	 * @return
	 */
	@Override
	public List<Vip> queryAllVipsByVipGoupid(String vipgoupsid) {
		Integer id = Integer.parseInt(vipgoupsid);
		VipGoups vipGoups = vipGoupsDao.selectVipGoupsByGoupId(id);
		List<Vip> vips = vipGoups.getVips();
		return vips;
	}

}