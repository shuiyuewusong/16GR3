package com.qhit.sbms.gm.DAO;

import com.qhit.sbms.gm.Bean.Goods;

/**
 * @author admin
 * 2017年11月13日
 */
public interface GoodsDao {

	/**
	 * @param goodsName
	 * @return
	 * 根据商品名称去查询商品信息
	 */
	public Goods getGoodsInfoByName(String goodsName);
	
	/**
	 * @param num
	 * @return
	 * 更新库存
	 */
	public int updateStore(int num, int goodsId);
}
