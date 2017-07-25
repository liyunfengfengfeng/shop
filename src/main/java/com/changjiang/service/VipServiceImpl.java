package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.VipDao;
import com.changjiang.entity.Vip;
import com.changjiang.common.Assist;
@Service
public class VipServiceImpl implements VipService{
    @Autowired
	private VipDao vipDao;
    @Override
    public long getVipRowCount(Assist assist){
        return vipDao.getVipRowCount(assist);
    }
    @Override
    public List<Vip> selectVip(Assist assist){
        return vipDao.selectVip(assist);
    }
    @Override
    public Vip selectVipById(Integer id){
        return vipDao.selectVipById(id);
    }
    @Override
    public int insertVip(Vip value){
        return vipDao.insertVip(value);
    }
    @Override
    public int insertNonEmptyVip(Vip value){
        return vipDao.insertNonEmptyVip(value);
    }
    @Override
    public int deleteVipById(Integer id){
        return vipDao.deleteVipById(id);
    }
    @Override
    public int deleteVip(Assist assist){
        return vipDao.deleteVip(assist);
    }
    @Override
    public int updateVipById(Vip enti){
        return vipDao.updateVipById(enti);
    }
    @Override
    public int updateVip(Vip value, Assist assist){
        return vipDao.updateVip(value,assist);
    }
    @Override
    public int updateNonEmptyVipById(Vip enti){
        return vipDao.updateNonEmptyVipById(enti);
    }
    @Override
    public int updateNonEmptyVip(Vip value, Assist assist){
        return vipDao.updateNonEmptyVip(value,assist);
    }

    public VipDao getVipDao() {
        return this.vipDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }
    /**
	 * 查询所有的会员信息
	 * @return
	 */
    public List<Vip> queryAllVips(){
    	
    	Assist assist = new Assist();
    	return vipDao.selectVip(assist);
    }
    /**
     * 通过店面id查找其下所有的会员信息
     */
	@Override
	public List<Vip> queryVipsByStoreId(String storeid) {
		Integer id = Integer.parseInt(storeid);
		List<Vip> vips = vipDao.queryVipsByStoreId(id);
		return vips;
	}
    
}