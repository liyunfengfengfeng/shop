package com.changjiang.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.FunctionDao;
import com.changjiang.dao.RolePowerDao;
import com.changjiang.dao.UsersDao;
import com.changjiang.entity.Function;
import com.changjiang.entity.RolePower;
import com.changjiang.entity.Users;
import com.changjiang.viewModel.FunctionNestNode;
import com.changjiang.viewModel.FunctionNode;
import com.changjiang.common.Assist;
@Service()
public class FunctionServiceImpl implements FunctionService{
    @Autowired
	private FunctionDao functionDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RolePowerDao rolePowerDao;
    @Override
    public long getFunctionRowCount(Assist assist){
        return functionDao.getFunctionRowCount(assist);
    }
    @Override
    public List<Function> selectFunction(Assist assist){
        return functionDao.selectFunction(assist);
    }
    @Override
    public Function selectFunctionById(Integer id){
        return functionDao.selectFunctionById(id);
    }
    @Override
    public int insertFunction(Function value){
        return functionDao.insertFunction(value);
    }
    @Override
    public int insertNonEmptyFunction(String name,Integer pId){
    	Function function=new Function();
    	function.setFunctionName(name);
    	function.setUpperLevelId(pId);
    	functionDao.insertNonEmptyFunction(function);
    	List<Function> functions=functionDao.selectFunction(new Assist(Assist.and_eq("function_name",name)));
        return functions.get(0).getId();
    }
    //有无子节点进行不同的处理
    @Override
    public int deleteFunctionById(Integer id){
    	List<Function> functions=functionDao.selectFunction(new Assist(Assist.and_eq("upper_level_id",id.toString())));
    	if(functions==null||functions.size()==0){
    		return functionDao.deleteFunctionById(id);
    	}
    	functionDao.deleteFunction(new Assist(Assist.and_eq("upper_level_id",id.toString())));
        return functionDao.deleteFunctionById(id);
    }
    @Override
    public int deleteFunction(Assist assist){
        return functionDao.deleteFunction(assist);
    }
    @Override
    public int updateFunctionById(Function enti){
        return functionDao.updateFunctionById(enti);
    }
    @Override
    public int updateFunction(Function value, Assist assist){
        return functionDao.updateFunction(value,assist);
    }
    @Override
    public int updateNonEmptyFunctionById(Integer id,String newName){
    	Function function=new Function();
    	function.setId(id);
    	function.setFunctionName(newName);
        return functionDao.updateNonEmptyFunctionById(function);
    }
    @Override
    public int updateNonEmptyFunction(Function value, Assist assist){
        return functionDao.updateNonEmptyFunction(value,assist);
    }

    public FunctionDao getFunctionDao() {
        return this.functionDao;
    }

    public void setFunctionDao(FunctionDao functionDao) {
        this.functionDao = functionDao;
    }
    //这个获得排序后节点的方法基于表中数据是有序的形式
	@Override
	public List<FunctionNestNode> getFunctionByUserId(Integer id) {
		List<RolePower> rolePowers=new ArrayList<>();
		Users user=usersDao.selectUsersById(id);
		rolePowers=rolePowerDao.selectRolePowerByRoleId(user.getRoleId());
		List<Function> functionsOnFirst=new ArrayList<>();
		List<Function> functionsOnSecond=new ArrayList<>();
		//所有子节点的父节点的Functionid
		Set<Integer> parents=new HashSet<>();
		for(RolePower rolePower:rolePowers){
			//将功能分为一级和二级
			if(rolePower.getFunction().getCurrentLevel().equals(1)){
				//根据索引对其进行排序
				functionsOnFirst.add(rolePower.getFunction());
			}else{
				functionsOnSecond.add(rolePower.getFunction());
				parents.add(rolePower.getFunction().getUpperLevelId());
			}
		}
		Collections.sort(functionsOnFirst,new Comparator<Function>(){
			@Override
			public int compare(Function o1, Function o2) {
				//根据order进行排序
				return o1.getOrderId()-o2.getOrderId();
			}
		});
		Collections.sort(functionsOnSecond,new Comparator<Function>(){
			@Override
			public int compare(Function o1, Function o2) {
				// TODO Auto-generated method stub
				return o1.getOrderId()-o2.getOrderId();
			}
		});
		List<FunctionNestNode> nodes=new ArrayList<>(functionsOnFirst.size());
		for(Function function:functionsOnFirst){
			FunctionNestNode node=new FunctionNestNode();
			//说明有子节点
			if(parents.contains(function.getId())){
				//查出这个节点的所有子节点
				List<Function> functions=new ArrayList<>();
				for(Function f:functionsOnSecond){
					if(f.getUpperLevelId().equals(function.getId())){
						functions.add(f);
					}
				}
				functionsOnSecond.removeAll(functions);
				Collections.sort(functions,new Comparator<Function>(){
					@Override
					public int compare(Function o1, Function o2) {
						// TODO Auto-generated method stub
						return o1.getOrderId()-o2.getOrderId();
					}
				});
				//得到这个节点的所有子节点
				List<FunctionNestNode> childNodes=new ArrayList<>(functions.size());
				for(int i=0;i<functions.size();i++){
					FunctionNestNode childNode=new FunctionNestNode();
					childNode.setId(functions.get(i).getId());
					childNode.setIcon(functions.get(i).getIcon());
					childNode.setName(functions.get(i).getFunctionName());
					childNode.setChild(0);
					childNode.setUrls(functions.get(i).getUrls());
					childNodes.add(childNode);
				}
				//得到这个节点的子节点属性
				node.setNodes(childNodes);
				node.setChild(1);
				node.setIcon(function.getIcon());
				node.setName(function.getFunctionName());
				node.setId(function.getId());
				node.setUrls(function.getUrls());
				nodes.add(node);
			}else{
				node.setChild(0);
				node.setIcon(function.getIcon());
				node.setName(function.getFunctionName());
				node.setId(function.getId());
				node.setUrls(function.getUrls());
				nodes.add(node);
			}
		}
		return nodes;
	}
	@Override
	public List<FunctionNode> getAllFunctionNoNest() {
		List<Function> functionAll=functionDao.selectFunction(new Assist(Assist.and_neq("urls","0")));
		List<Function> functionsFirst=new ArrayList<>();
		List<Function> functionsOther=new ArrayList<>();
		for(Function singleFunction:functionAll){
			if(singleFunction.getCurrentLevel()==1){
				functionsFirst.add(singleFunction);
			}else{
				functionsOther.add(singleFunction);
			}
		}
		Collections.sort(functionsFirst,new Comparator<Function>(){
			@Override
			public int compare(Function o1, Function o2) {
				//根据order进行排序
				return o1.getOrderId()-o2.getOrderId();
			}
		});
		List<FunctionNode> result=new ArrayList<>();
		//根据第一级，按顺序加入到结果集
		for(Function f:functionsFirst){
			FunctionNode functionNode=new FunctionNode();
			functionNode.setId(f.getId());
			functionNode.setName(f.getFunctionName());
			functionNode.setpId("0");
			result.add(functionNode);
			//找到所有子节点
			List<Function> sonFunctions=new ArrayList<>();
			for(Function fSon:functionsOther){
				if(fSon.getUpperLevelId()==f.getId()){
					sonFunctions.add(fSon);
				}
			}
			functionsOther.removeAll(sonFunctions);
			//对子节点集进行排序
			Collections.sort(sonFunctions,new Comparator<Function>(){
				@Override
				public int compare(Function o1, Function o2) {
					//根据order进行排序
					return o1.getOrderId()-o2.getOrderId();
				}
			});
			//将子节点集放在结果集中
			for(Function f1:sonFunctions){
				FunctionNode sonFunctionNode=new FunctionNode();
				sonFunctionNode.setId(f1.getId());
				sonFunctionNode.setName(f1.getFunctionName());
				sonFunctionNode.setpId(f.getId().toString());
				result.add(sonFunctionNode);
			}
		}
		return result;
	}

}