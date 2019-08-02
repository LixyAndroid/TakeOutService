package gdut.tackout.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gdut.tackout.bean.GoodsInfo;
import gdut.tackout.bean.Order;
import gdut.tackout.bean.Order.Distribution;
import gdut.tackout.bean.Order.OrderDetail;
import gdut.tackout.bean.Order.Rider;
import gdut.tackout.bean.Response;
import gdut.tackout.bean.Seller;
import gdut.tackout.utils.CommonUtil;



/**
 * Servlet implementation class UserLoginServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OrderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		System.out.println("id:"+id);
		
		Response res=new Response();
		res.setCode("0");
		List<Order> orders = new ArrayList<Order>();
		
		Order order1 = new Order();
		order1.id = "0001";
		order1.type = "20";
		OrderDetail detail1 = order1.new OrderDetail();
		detail1.address = "外环西路999号";
		detail1.pay = "微信支付";
		detail1.phone = "18575627762";
		detail1.time = "2016-8-8 18:00";
		detail1.username = "用户250";
		order1.detail = detail1;
		
		Rider rider1 = order1.new Rider();
		rider1.id = 01;
		rider1.name = "广州骑士";
		rider1.phone = "13888888888";
		order1.rider = rider1;
		
		Distribution distribution1 = order1.new Distribution();
		distribution1.des = "湘赣木桶饭，好吃到爆";
		distribution1.type = "yes";
		order1.distribution = distribution1;
		
		List<GoodsInfo> goodsInfos1 = new ArrayList<GoodsInfo>();
		GoodsInfo info1 = new GoodsInfo();
		info1.setName("湘味腊肉饭");
		info1.setNewPrice("10.00");
		GoodsInfo info2 = new GoodsInfo();
		info2.setName("土豆炒牛肉");
		info2.setNewPrice("10.00");
		goodsInfos1.add(info2);
		goodsInfos1.add(info1);
		order1.goodsInfos = goodsInfos1;
		
		Seller seller1 = new Seller();
		seller1.setName("一品木桶饭");
		order1.seller = seller1;
		orders.add(order1);
		
		Order order = new Order();
		order.id = "0002";
		order.type = "20";
		OrderDetail detail = order.new OrderDetail();
		detail.address = "留仙大道999号";
		detail.pay = "微信支付";
		detail.phone = "18575627762";
		detail.time = "2016-8-8 18:00";
		detail.username = "用户180";
		order.detail = detail;
		
		Rider rider = order.new Rider();
		rider.id = 01;
		rider.name = "西安骑士";
		rider.phone = "13755556666";
		order.rider = rider;
		
		Distribution distribution = order.new Distribution();
		distribution.des = "地道陕西面食";
		distribution.type = "yes";
		order.distribution = distribution;
		
		List<GoodsInfo> goodsInfos = new ArrayList<GoodsInfo>();
		GoodsInfo info3 = new GoodsInfo();
		info3.setName("三鲜牛肉米粉");
		info3.setNewPrice("10.00");
		GoodsInfo info4 = new GoodsInfo();
		info4.setName("纯廋肉夹馍");
		info4.setNewPrice("10.00");
		goodsInfos.add(info3);
		goodsInfos.add(info4);
		order.goodsInfos = goodsInfos;
		
		Seller seller = new Seller();
		seller.setName("陈师傅红烧肉(大学城店)");
		order.seller = seller;
		orders.add(order);
		
		res.setData(new Gson().toJson(orders));
		CommonUtil.renderJson(response, res);
	}

}
