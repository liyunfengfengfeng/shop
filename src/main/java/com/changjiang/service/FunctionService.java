package com.changjiang.service;
import java.util.List;
import com.changjiang.entity.Function;
import com.changjiang.viewModel.FunctionNestNode;
import com.changjiang.viewModel.FunctionNode;
import com.changjiang.common.Assist;
public interface FunctionService{
    long getFunctionRowCount(Assist assist);
    List<Function> selectFunction(Assist assist);
    Function selectFunctionById(Integer id);
    int insertFunction(Function value);
    int insertNonEmptyFunction(String name,Integer pId);
    int deleteFunctionById(Integer id);
    int deleteFunction(Assist assist);
    int updateFunctionById(Function enti);
    int updateFunction(Function value, Assist assist);
    int updateNonEmptyFunctionById(Integer id,String newName);
    int updateNonEmptyFunction(Function value, Assist assist);
    //根据userId查出排好序的function
    List<FunctionNestNode> getFunctionByUserId(Integer id);
    //没有进行嵌套的功能节点
    List<FunctionNode> getAllFunctionNoNest();
}