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

import cn.edu.sjtu.book.service.SaleManager;
import cn.edu.sjtu.book.web.utils.DateUtils;

@Controller
@RequestMapping("/sales")
public class SalesController extends BaseController {
	
	@Autowired
	private SaleManager saleManager;
	
	@RequestMapping(value = "/search/form", method = RequestMethod.GET)
	public String getSearchForm(Model model) {
		logger.debug("do getSearchForm...");
		Date today = new Date();
		model.addAttribute("startDate", today);
		model.addAttribute("endDate", today);
		return ViewNames.FORWARD_SALES_DAILY_LIST;
	}
	
	@RequestMapping(value = "/daily/list/{startDate}to{endDate}", method = RequestMethod.GET)
	public String findSalesDailyByDate(HttpSession session, @PathVariable String startDate, 
			@PathVariable String endDate, Model model) throws ParseException {
		logger.debug("do findSalesDailyByDate...");
		model.addAttribute("startDate", DateUtils.parseDefaultFormatDate(startDate));
		model.addAttribute("endDate", DateUtils.parseDefaultFormatDate(endDate));
		model.addAttribute("dailySales", saleManager.findDailySalesByStoreDate(getSessionUser(session).getStore(), 
				DateUtils.parseDefaultFormatDate(startDate), DateUtils.parseDefaultFormatDate(endDate)));
		return ViewNames.FORWARD_SALES_DAILY_LIST;
	}
	
	@RequestMapping(value = "/daily/{saleDate}/books", method = RequestMethod.GET)
	public String findSalesDailyBooksByDate(HttpSession session, @PathVariable String saleDate, 
			Model model) throws ParseException {
		logger.debug("do findSalesDailyByDate...");
		model.addAttribute("saleDate", DateUtils.parseDefaultFormatDate(saleDate));
		model.addAttribute("booksSaleDaily", saleManager.findStoreSalesDailys(getSessionUser(session).getStore(), 
				DateUtils.parseDefaultFormatDate(saleDate)));
		return ViewNames.FORWARD_SALES_DAILY_BOOKS;
	}
	
}
