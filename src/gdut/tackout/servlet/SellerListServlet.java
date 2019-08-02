package gdut.tackout.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdut.tackout.bean.Response;
import gdut.tackout.bean.Seller;
import gdut.tackout.utils.CommonUtil;
import net.sf.json.JSONArray;


/**
 * Servlet implementation class SellerListServlet
 */
public class SellerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerListServlet() {
        super();
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
		System.out.println("--------获取商家列表--------");
		List<Seller> list=new ArrayList<Seller>();
		
		for(int i=1;i<10;i++){
			Seller seller=new Seller();
			seller.setId(i);
			seller.setName("第"+i+"家分店");
			list.add(seller);
		}
		
		Response res=new Response();
		res.setCode("0");
		String data="{\"list\":"+JSONArray.fromObject(list).toString()+"}";
		res.setData(data);
		
		CommonUtil.renderJson(response, res);
	}

}
