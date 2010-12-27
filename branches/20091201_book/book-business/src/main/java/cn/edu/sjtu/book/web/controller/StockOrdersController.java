package cn.edu.sjtu.book.web.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.service.OrderManager;
import cn.edu.sjtu.book.web.utils.DateUtils;

@Controller
@RequestMapping("/orders/stock")
public class StockOrdersController extends BaseOrderController {

	@Autowired
	private OrderManager orderManager;
	
	@RequestMapping(value = "/search/form", method = RequestMethod.GET)
	public String getSearchForm(Model model) {
		logger.debug("do getSearchForm...");
		initSearchForm(model);
		return ViewNames.FORWARD_ORDERS_STOCK_LIST;
	}
	
	@RequestMapping(value = "/list/{status}/{startDate}to{endDate}", method = RequestMethod.GET)
	public String findStockOrders(HttpSession session, @PathVariable String status,
			@PathVariable String startDate, @PathVariable String endDate, Model model) throws ParseException {
		logger.debug("do findStockOrders...");
		initList(status, startDate, endDate, model);
		model.addAttribute("orders", orderManager.findStockOrders(getSessionUser(session).getStore(), 
				DateUtils.parseDefaultFormatDate(startDate), DateUtils.parseDefaultFormatDate(endDate),
				Status.valueOf(status)));
		return ViewNames.FORWARD_ORDERS_STOCK_LIST;
	}
	
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public String findStockOrderById(@PathVariable Long orderId, Model model) {
		logger.debug("do findStockOrderById...");
		model.addAttribute("order", orderManager.findStockOrderById(orderId));
		return ViewNames.FORWARD_ORDERS_STOCK_DETAIL;
	}
	
	@RequestMapping(value = "/verify/{orderId}", method = RequestMethod.POST)
	public String verifyStockOrder(HttpSession session, @PathVariable Long orderId, Model model) {
		logger.debug("do verifyStockOrder...");
		StockOrder orderParam = new StockOrder();
		orderParam.setId(orderId);
		orderParam.setLastModifyBy(getSessionUser(session).getLoginName());
		orderParam.setLastModifyTime(new Date());
		StockOrder order = orderManager.verifyStockOrder(orderParam);
		model.addAttribute("order", order);
		return ViewNames.FORWARD_ORDERS_STOCK_MESSAGE;
	}
	
}
