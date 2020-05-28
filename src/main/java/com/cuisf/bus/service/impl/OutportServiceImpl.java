package com.cuisf.bus.service.impl;

import java.util.Date;

import com.cuisf.bus.entity.Goods;
import com.cuisf.bus.entity.Inport;
import com.cuisf.bus.entity.Outport;
import com.cuisf.bus.mapper.GoodsMapper;
import com.cuisf.bus.mapper.InportMapper;
import com.cuisf.bus.mapper.OutportMapper;
import com.cuisf.bus.service.OutportService;
import com.cuisf.sys.common.WebUtils;
import com.cuisf.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 *  &#x670d;&#x52a1;&#x5b9e;&#x73b0;&#x7c7b;
 * </p>
 *
 */
@Service
@Transactional
public class OutportServiceImpl extends ServiceImpl<OutportMapper, Outport> implements OutportService {

	@Autowired
	private InportMapper inportMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public void addOutPort(Integer id, Integer number, String remark) {
		//1,根据进货单ID查询进货单信息
		Inport inport = this.inportMapper.selectById(id);
		//2,根据商品ID查询商品信息
		Goods goods = this.goodsMapper.selectById(inport.getGoodsid());
		goods.setNumber(goods.getNumber()-number);
		this.goodsMapper.updateById(goods);
		//3,添加退货单信息
		Outport entity=new Outport();
		entity.setGoodsid(inport.getGoodsid());
		entity.setNumber(number);
		User user=(User) WebUtils.getSession().getAttribute("user");
		entity.setOperateperson(user.getName());
		entity.setOutportprice(inport.getInportprice());
		entity.setOutputtime(new Date());
		entity.setPaytype(inport.getPaytype());
		entity.setProviderid(inport.getProviderid());
		entity.setRemark(remark);
		this.getBaseMapper().insert(entity);
	}

}
