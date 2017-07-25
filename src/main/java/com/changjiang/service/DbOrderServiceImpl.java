package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.DbOrderDao;
import com.changjiang.entity.DbOrder;
import com.changjiang.common.Assist;
public class DbOrderServiceImpl implements DbOrderService{
    private DbOrderDao dbOrderDao;
    @Override
    public long getDbOrderRowCount(Assist assist){
        return dbOrderDao.getDbOrderRowCount(assist);
    }
    @Override
    public List<DbOrder> selectDbOrder(Assist assist){
        return dbOrderDao.selectDbOrder(assist);
    }
    @Override
    public DbOrder selectDbOrderById(Integer id){
        return dbOrderDao.selectDbOrderById(id);
    }
    @Override
    public int insertDbOrder(DbOrder value){
        return dbOrderDao.insertDbOrder(value);
    }
    @Override
    public int insertNonEmptyDbOrder(DbOrder value){
        return dbOrderDao.insertNonEmptyDbOrder(value);
    }
    @Override
    public int deleteDbOrderById(Integer id){
        return dbOrderDao.deleteDbOrderById(id);
    }
    @Override
    public int deleteDbOrder(Assist assist){
        return dbOrderDao.deleteDbOrder(assist);
    }
    @Override
    public int updateDbOrderById(DbOrder enti){
        return dbOrderDao.updateDbOrderById(enti);
    }
    @Override
    public int updateDbOrder(DbOrder value, Assist assist){
        return dbOrderDao.updateDbOrder(value,assist);
    }
    @Override
    public int updateNonEmptyDbOrderById(DbOrder enti){
        return dbOrderDao.updateNonEmptyDbOrderById(enti);
    }
    @Override
    public int updateNonEmptyDbOrder(DbOrder value, Assist assist){
        return dbOrderDao.updateNonEmptyDbOrder(value,assist);
    }

    public DbOrderDao getDbOrderDao() {
        return this.dbOrderDao;
    }

    public void setDbOrderDao(DbOrderDao dbOrderDao) {
        this.dbOrderDao = dbOrderDao;
    }

}