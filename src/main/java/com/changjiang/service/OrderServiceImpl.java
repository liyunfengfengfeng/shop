package com.changjiang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changjiang.dao.OrderDao;
import com.changjiang.entity.Order;
import com.changjiang.entity.SysCodeRule;
import com.changjiang.util.DataType;
import com.changjiang.common.Assist;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
	private OrderDao orderDao;
    @Override
    public long getOrderRowCount(Assist assist){
        return orderDao.getOrderRowCount(assist);
    }
    @Override
    public List<Order> selectOrder(Assist assist){
        return orderDao.selectOrder(assist);
    }
    @Override
    public Order selectOrderById(Integer id){
        return orderDao.selectOrderById(id);
    }
    @Override
    public int insertOrder(Order value){
        return orderDao.insertOrder(value);
    }
    @Override
    public int insertNonEmptyOrder(Order value){
        return orderDao.insertNonEmptyOrder(value);
    }
    @Override
    public int deleteOrderById(Integer id){
        return orderDao.deleteOrderById(id);
    }
    @Override
    public int deleteOrder(Assist assist){
        return orderDao.deleteOrder(assist);
    }
    @Override
    public int updateOrderById(Order enti){
        return orderDao.updateOrderById(enti);
    }
    @Override
    public int updateOrder(Order value, Assist assist){
        return orderDao.updateOrder(value,assist);
    }
    @Override
    public int updateNonEmptyOrderById(Order enti){
        return orderDao.updateNonEmptyOrderById(enti);
    }
    @Override
    public int updateNonEmptyOrder(Order value, Assist assist){
        return orderDao.updateNonEmptyOrder(value,assist);
    }

    public OrderDao getOrderDao() {
        return this.orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    /**
     * 查询所有订单信息
     */
	@Override
	public List<Order> selectAllOrder() {
		List<Order> orders = orderDao.selectAllOrder();
		return orders;
	}
	/**
	 * 该方法用于生成流水号
	 * 
	 * @return
	 */
	public String createGlideNumber(SysCodeRuleService sysCodeRuleService) {
		String glideNumber = "";
		List<SysCodeRule> sysCodeRules = null;
		if(sysCodeRuleService == null){
			System.out.println("sysCodeRuleService is null");
			return null;
		}
		// 查询所有的流水号编码规则
		if(sysCodeRuleService != null){
			Assist assist = new Assist();
			
			sysCodeRules = sysCodeRuleService.selectSysCodeRule(assist);
		}
		if (sysCodeRules == null || sysCodeRules.size() < 1) {
			System.out.println("不能够产生流水线编号");
		}
		System.out.println("sysCodeRules.size()    :" + sysCodeRules.size());
		SysCodeRule sysCodeRule = null;
		if (sysCodeRules.size() == 1) {
			sysCodeRule = sysCodeRules.get(0);
		}
		System.out.println("sysCodeRule.getAreaprefix()   :" + sysCodeRule.getAreaprefix());
		// 如果是今天的第一单
		if (sysCodeRule != null) {
			if (sysCodeRule.getCurrentcode()==null) {
				System.out.println("该订单为今天的第一单");
				//获取需要生成的流水号是几位的
				int bit = sysCodeRule.getGlidebit();
				//生成001类似的流水号后缀
				String glideLast = DataType.createCurrentGlideNumber(bit);
				System.out.println("5为流水号" + glideLast);
				//获取流水号的前缀
				String glidePre = sysCodeRule.getAreaprefix();
				//获取流水号的中缀
				String glideMid = DataType.getStringDate(sysCodeRule.getAreatime());
				//生成当天的第一单流水号
				glideNumber = glidePre+"-"+glideMid+"-"+glideLast;
				System.out.println("生成的流水号是   :" + glideNumber);
				
				//获取下一条流水线的后缀
				String nextGlideLast = DataType.createNextGlideNumber(glideLast);
				System.out.println("5为流水号的下一位" + glideLast);
				//持久化下一条流水线的后缀   nextseq
				sysCodeRule.setNextseq(nextGlideLast);
				
				//设置数据库改变currentCode与CurDate 此时已经不是首单了
				String curDate = DataType.getStringDate(sysCodeRule.getAreatime());
				sysCodeRule.setCurdate(curDate);
				sysCodeRule.setCurrentcode(glideNumber);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleService.updateNonEmptySysCodeRuleById(sysCodeRule);
			}else if(sysCodeRule.getCurdate().equals(DataType.getStringDate(sysCodeRule.getAreatime()))) {
				System.out.println("订单非收单但是是同一天的");
				//获取当前的流水号后缀
				String glideLast = sysCodeRule.getNextseq();
				//获取当前流水号的中缀
				String glideMid = DataType.getStringDate(sysCodeRule.getAreatime());
				//获取流水号前缀
				String glidePre = sysCodeRule.getAreaprefix();
				//生成当天的不是第一条的流水号
				glideNumber = glidePre+"-"+glideMid+"-"+glideLast;
				//通过当前流水号后缀获取下一条流水号的后缀
				String nextGlideLast = DataType.createNextGlideNumber(sysCodeRule.getNextseq());
				//获取当前日期
				String curDate = DataType.getStringDate(sysCodeRule.getAreatime());
				//保存下一条流水号 并且重新设置当前日期
				sysCodeRule.setNextseq(nextGlideLast);
				sysCodeRule.setCurrentcode(glideNumber);
				sysCodeRule.setCurdate(curDate);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleService.updateNonEmptySysCodeRuleById(sysCodeRule);
			}else{
				System.out.println("订单是首单但是是隔天的");
				//获取流水号的位数
				int bit = sysCodeRule.getGlidebit();
				//生成第二天的第一条流水号后缀
				String firstGlideLast = DataType.createCurrentGlideNumber(bit);
				//获取当前的时间 生成第二天的第一条流水号中缀
				String firstGlideMid = DataType.getStringDate(sysCodeRule.getAreatime());
				//获取第二天的第一条流水号前缀
				String firstGlidePre = sysCodeRule.getAreaprefix();
				//生成第二天的第一单流水号
				glideNumber = firstGlidePre+"-"+firstGlideMid+"-"+firstGlideLast;
				
				//获取当前时间
				String curDate = DataType.getStringDate(sysCodeRule.getAreatime());
				//获取第二天流水号后缀
				String nextGlideLast = DataType.createNextGlideNumber(firstGlideLast);
				//进行更新
				sysCodeRule.setCurdate(curDate);
				sysCodeRule.setNextseq(nextGlideLast);
				sysCodeRule.setCurrentcode(glideNumber);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleService.updateNonEmptySysCodeRuleById(sysCodeRule);
			}
		}
		return glideNumber;
	}
}
