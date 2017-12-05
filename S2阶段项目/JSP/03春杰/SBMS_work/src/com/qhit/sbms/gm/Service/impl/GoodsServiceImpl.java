package com.qhit.sbms.gm.Service.impl;

import com.qhit.sbms.gm.Bean.Goods;
import com.qhit.sbms.gm.DAO.impl.GoodsDaoImpl;
import com.qhit.sbms.gm.Service.GoodsService;

/**
 * @author admin
 * 2017年11月13日
 */
public class GoodsServiceImpl implements GoodsService {

	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoodsInfoByName(goodsName);
	}

	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateStore(num, goodsId);
	}

}
