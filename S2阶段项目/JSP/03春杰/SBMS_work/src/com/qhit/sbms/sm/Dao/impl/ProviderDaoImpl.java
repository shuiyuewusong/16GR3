package com.qhit.sbms.sm.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbms.bm.Bean.AccountDetail;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.sm.Bean.Provider;
import com.qhit.sbms.sm.Dao.ProviderDao;
import com.qhit.sbms.util.DBManager;

public class ProviderDaoImpl implements ProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public List<Provider> getAllProvider() {
		List<Provider> list = new ArrayList<Provider>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				provider = new Provider(rs.getInt("providerId"), rs.getString("providerName"),
						rs.getString("providerDetail"), rs.getString("contact"), rs.getString("telephone"),
						rs.getString("facsimile"), rs.getString("address"));
				list.add(provider);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public PageBean getPageBean(PageBean pageBean) {
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select top " 
		+ pageBean.getPagesize()
				+ " p.providerId,p.providerName,p.providerDetail,p.contact,p.telephone,p.address " 
				+ " from tb_provider p "
				+ " where p.providerId " 
				+ " not in ( " 
				+ " select top " 
				+ pageBean.getPagesize() * (pageBean.getP() - 1)
				+ " p.providerId  " 
				+ " from tb_provider p ) ; " ;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"),
						rs.getString("providerDetail"),
						rs.getString("contact"),
						rs.getString("telephone"),
						rs.getString("address")
						);

				pageBean.addData(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return pageBean;

	}

}
