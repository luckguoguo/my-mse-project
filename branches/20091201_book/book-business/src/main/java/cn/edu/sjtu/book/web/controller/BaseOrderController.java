package cn.edu.sjtu.book.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;

import cn.edu.sjtu.book.entity.OrderItem;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.book.web.validation.exception.NonOrderItemException;
import cn.edu.sjtu.book.web.validation.exception.OrderItemsIllegalArgumentsException;
import cn.edu.sjtu.book.web.validation.exception.OrderItemsRepeatedException;

public class BaseOrderController extends BaseController {

	protected void initSearchForm(Model model) {
		model.addAttribute("statusList", Status.values());
		model.addAttribute("status", Status.PENDING);
		Date today = new Date();
		model.addAttribute("startDate", today);
		model.addAttribute("endDate", today);
	}
	
	protected void initList(String status, String startDate, String endDate,
			Model model) throws ParseException {
		model.addAttribute("statusList", Status.values());
		model.addAttribute("status", Status.valueOf(status));
		model.addAttribute("startDate", DateUtils.parseDefaultFormatDate(startDate));
		model.addAttribute("endDate", DateUtils.parseDefaultFormatDate(endDate));
	}
	
	public static class OrderForm {
		
		private String memo;
		
		private List<OrderItem> items = new ArrayList<OrderItem>();

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

		public List<OrderItem> getItems() {
			return items;
		}

		public void setItems(List<OrderItem> items) {
			this.items = items;
		}
		
		public void validateRepeatedItem() throws NonOrderItemException, 
				OrderItemsRepeatedException, OrderItemsIllegalArgumentsException {
			
			// check if it is blank
			if (items == null || items.size() <= 0) {
				throw new NonOrderItemException("no items");
			}
			
			// check arguments and check if it is repeated
			for (OrderItem item : items) {
				if (item.getBook() == null || item.getBook().getId() == null || item.getBook().getId() < 1) {
					throw new OrderItemsIllegalArgumentsException("book id invalid");
				}
				if (item.getNum() < 1) {
					throw new OrderItemsIllegalArgumentsException("book num invalid");
				}
				if (countNum(items, item) > 1) {
					throw new OrderItemsRepeatedException("item " + item.getBook().getId() + " repeated");
				}
			}
		}
		
		private int countNum(List<OrderItem> items, OrderItem item) {
			int count = 0;
			for (OrderItem itemInList : items) {
				if (item.getBook().getId().equals(itemInList.getBook().getId())) {
					count ++;
				}
			}
			return count;
		}
		
	}
	
}
