package com.changjiang.service;
import java.util.List;
import com.changjiang.dao.ProducteSpecialityDao;
import com.changjiang.entity.ProducteSpeciality;
import com.changjiang.common.Assist;
public class ProducteSpecialityServiceImpl implements ProducteSpecialityService{
    private ProducteSpecialityDao producteSpecialityDao;
    @Override
    public long getProducteSpecialityRowCount(Assist assist){
        return producteSpecialityDao.getProducteSpecialityRowCount(assist);
    }
    @Override
    public List<ProducteSpeciality> selectProducteSpeciality(Assist assist){
        return producteSpecialityDao.selectProducteSpeciality(assist);
    }
    @Override
    public ProducteSpeciality selectProducteSpecialityById(Integer id){
        return producteSpecialityDao.selectProducteSpecialityById(id);
    }
    @Override
    public int insertProducteSpeciality(ProducteSpeciality value){
        return producteSpecialityDao.insertProducteSpeciality(value);
    }
    @Override
    public int insertNonEmptyProducteSpeciality(ProducteSpeciality value){
        return producteSpecialityDao.insertNonEmptyProducteSpeciality(value);
    }
    @Override
    public int deleteProducteSpecialityById(Integer id){
        return producteSpecialityDao.deleteProducteSpecialityById(id);
    }
    @Override
    public int deleteProducteSpeciality(Assist assist){
        return producteSpecialityDao.deleteProducteSpeciality(assist);
    }
    @Override
    public int updateProducteSpecialityById(ProducteSpeciality enti){
        return producteSpecialityDao.updateProducteSpecialityById(enti);
    }
    @Override
    public int updateProducteSpeciality(ProducteSpeciality value, Assist assist){
        return producteSpecialityDao.updateProducteSpeciality(value,assist);
    }
    @Override
    public int updateNonEmptyProducteSpecialityById(ProducteSpeciality enti){
        return producteSpecialityDao.updateNonEmptyProducteSpecialityById(enti);
    }
    @Override
    public int updateNonEmptyProducteSpeciality(ProducteSpeciality value, Assist assist){
        return producteSpecialityDao.updateNonEmptyProducteSpeciality(value,assist);
    }

    public ProducteSpecialityDao getProducteSpecialityDao() {
        return this.producteSpecialityDao;
    }

    public void setProducteSpecialityDao(ProducteSpecialityDao producteSpecialityDao) {
        this.producteSpecialityDao = producteSpecialityDao;
    }

}