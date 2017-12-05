package com.qhit.sbms.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Request;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.common.service.CommonService;
import com.qhit.sbms.common.service.impl.CommonServiceImpl;
import com.qhit.sbms.sm.Bean.Provider;
import com.qhit.sbms.sm.Dao.ProviderDao;
import com.qhit.sbms.sm.Dao.impl.ProviderDaoImpl;
import com.qhit.sbms.sm.Service.ProviderService;
import com.qhit.sbms.sm.Service.impl.ProviderServiceImpl;

public class SmServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceImpl();
	private CommonService commonService = new CommonServiceImpl();
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getAllProvider":
			getAllProvider(request, response);
			break;
		
		case "getSm":
			getSm(request, response);
			break;	
		default:
			break;
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * 查询供应商
	 * @throws IOException 
	 */
	private void getSm(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		/**
		 * pagesize=5
		 * data:实例化
		 * count：1
		 * pagetotal:2
		 * p:3
		 * */
		PageBean pageBeanS = new PageBean();
		int count = commonService.getCount("tb_provider", null, null);
		pageBeanS.setCount(count);
		
		String p = request.getParameter("p");
		if(p != null && p != ""){
			//有参数p
			pageBeanS.setP(Integer.parseInt(p));
		}else{
			//没有参数，第一次进入
			pageBeanS.setP(1);
		}
		
		pageBeanS = providerService.getPageBean(pageBeanS);
		//保存数据
		System.out.println(pageBeanS.getData().size());
		request.getSession().setAttribute("pageBeanS", pageBeanS);
		//重定向
//		response.sendRedirect("jsp/admin_index.jsp");
		if(p != null && p != ""){
			//p
			System.out.println("有参数");
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/providerAdmin.jsp'</script>");
		}else{
			System.out.println(8);
			response.sendRedirect("jsp/providerAdmin.jsp");
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * 查询所有的供应商
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getAllProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		List<Provider> list = providerService.getAllProvider();
		
		request.setAttribute("providers", list);
		if(action.equals("add")){
			//查完之后:如果是添加账单，转发到添加账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//查完之后：如果是修改账单，那就转发到修改账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
		
	}

}
