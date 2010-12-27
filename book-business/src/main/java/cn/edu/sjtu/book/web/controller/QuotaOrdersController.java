package cn.edu.sjtu.book.web.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.book.entity.OrderItem;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.QuotaOrderItem;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.entity.Order.SyncFlag;
import cn.edu.sjtu.book.service.OrderManager;
import cn.edu.sjtu.book.service.exception.BookNotExistsException;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.book.web.utils.ServletUtils;
import cn.edu.sjtu.book.web.validation.exception.NonOrderItemException;
import cn.edu.sjtu.book.web.validation.exception.OrderItemsIllegalArgumentsException;
import cn.edu.sjtu.book.web.validation.exception.OrderItemsRepeatedException;

@Controller
@RequestMapping("/orders/quota")
public class QuotaOrdersController extends BaseOrderController {

	@Autowired
	private OrderManager orderManager;
	
	@RequestMapping(value = "/search/form", method = RequestMethod.GET)
	public String getSearchForm(Model model) {
		logger.debug("do getSearchForm...");
		initSearchForm(model);
		model.addAttribute("status", Status.REVIEW);
		return ViewNames.FORWARD_ORDERS_QUOTA_LIST;
	}
	
	@RequestMapping(value = "/list/{status}/{startDate}to{endDate}", method = RequestMethod.GET)
	public String findQuotaOrders(HttpSession session, @PathVariable String status,
			@PathVariable String startDate, @PathVariable String endDate, Model model) throws ParseException {
		logger.debug("do findQuotaOrders...");
		initList(status, startDate, endDate, model);
		model.addAttribute("orders", orderManager.findQuotaOrders(getSessionUser(session).getStore(), 
				DateUtils.parseDefaultFormatDate(startDate), DateUtils.parseDefaultFormatDate(endDate),
				Status.valueOf(status)));
		return ViewNames.FORWARD_ORDERS_QUOTA_LIST;
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public String findQuotaOrderById(@PathVariable Long orderId, Model model) {
		logger.debug("do findQuotaOrderById...");
		model.addAttribute("order", orderManager.findQuotaOrderById(orderId));
		return ViewNames.FORWARD_ORDERS_QUOTA_DETAIL;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getQuotaOrderForm(Model model) {
		logger.debug("do getQuotaOrderForm...");
		return ViewNames.FORWARD_ORDERS_QUOTA_FORM;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addQuotaOrder(HttpServletRequest request, Model model, OrderForm orderForm, BindingResult result) {
		logger.debug("do addQuotaOrder...");
		try {
			QuotaOrder quotaOrder = transferToQuotaOrder(request.getSession(), orderForm);
			logger.debug("adding quota order..");
			orderManager.addQuotaOrder(quotaOrder);
			model.addAttribute("order", quotaOrder);
			logger.debug("quota order has been added successfully");
		} catch (NonOrderItemException e) {
			logger.debug(e.getMessage());
			result.reject("orders.quota.form.error.nonitems");
		} catch (OrderItemsRepeatedException e) {
			logger.debug(e.getMessage());
			result.reject("orders.quota.form.error.itemsrepeat");
		} catch (OrderItemsIllegalArgumentsException e) {
			logger.debug(e.getMessage());
			result.reject("orders.quota.form.error.illegal");
		} catch (BookNotExistsException e) {
			logger.debug(e.getMessage());
			result.reject("orders.quota.form.error.book.notexsits");
		}
		
		logger.debug("check result errors");
		
		if (result.hasErrors()) {
			logger.debug("quota form submit has some errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Quota Order Error", request.getLocale()));
			model.addAttribute("orderForm", orderForm);
			return ViewNames.FORWARD_ORDERS_QUOTA_FORM;
		}
		
		logger.debug("go to message view");
		
		return ViewNames.FORWARD_ORDERS_QUOTA_MESSAGE;
	}
	
	private QuotaOrder transferToQuotaOrder(HttpSession session, OrderForm orderForm) 
			throws NonOrderItemException, OrderItemsRepeatedException, OrderItemsIllegalArgumentsException {
		if (logger.isDebugEnabled()) {
			logger.debug("memo: " + orderForm.getMemo());
			logger.debug("items: " + orderForm.getItems().size());
			for (OrderItem item : orderForm.getItems()) {
				logger.debug("item book id: " + item.getBook().getId());
				logger.debug("item num: " + item.getNum());
			}
		}
		
		orderForm.validateRepeatedItem();
		
		logger.debug("passed vilidation");
		
		QuotaOrder order = new QuotaOrder();
		order.setStore(getSessionUser(session).getStore());
		order.setStatus(Status.REVIEW);
		order.setSyncFlag(SyncFlag.WAITING);
		order.setMemo(orderForm.getMemo());
		Date today = new Date();
		order.setOrderDate(today);
		order.setCreateBy(getSessionUser(session).getLoginName());
		order.setCreateTime(today);
		order.setLastModifyBy(getSessionUser(session).getLoginName());
		order.setLastModifyTime(today);
		order.setNum(0);
		
		logger.debug("do with items");
		
		for (OrderItem item : orderForm.getItems()) {
			QuotaOrderItem quotaOrderItem = new QuotaOrderItem();
			quotaOrderItem.setOrder(order);
			order.getItems().add(quotaOrderItem);
			quotaOrderItem.setBook(item.getBook());
			quotaOrderItem.setNum(item.getNum());
			order.setNum(order.getNum() + quotaOrderItem.getNum());
		}
		
		logger.debug("transfer success");
		
		return order;
	}
	
}
