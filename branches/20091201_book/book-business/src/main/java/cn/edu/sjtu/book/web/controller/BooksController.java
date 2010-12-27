package cn.edu.sjtu.book.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.service.BookManager;
import cn.edu.sjtu.book.service.BookRepositoryManager;
import cn.edu.sjtu.book.service.OrderManager;
import cn.edu.sjtu.book.service.SaleManager;

@Controller
@RequestMapping("/books")
public class BooksController extends BaseController {

	@Autowired
	private BookManager bookManager;
	
	@Autowired
	private BookRepositoryManager bookRepositoryManager;
	
	@Autowired
	private SaleManager saleManager;
	
	@Autowired
	private OrderManager orderManager;
	
	@RequestMapping(value = "/search/form", method = RequestMethod.GET)
	public String getSearchForm(Model model) {
		logger.debug("do getSearchForm...");
		return ViewNames.FORWARD_BOOKS_LIST;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String findAllBooks(Model model) {
		logger.debug("do findAllBooks...");
		model.addAttribute("books", bookManager.findBooksByName(""));
		return ViewNames.FORWARD_BOOKS_LIST;
	}
	
	@RequestMapping(value = "/list/{bookName}", method = RequestMethod.GET)
	public String findBooksByBookName(@PathVariable String bookName, Model model) {
		logger.debug("do findBooksByBookName...");
		logger.debug("books for: " + bookName);
		model.addAttribute("bookName", bookName);
		model.addAttribute("books", bookManager.findBooksByName(bookName));
		return ViewNames.FORWARD_BOOKS_LIST;
	}
	
	@RequestMapping(value = "/{bookId}/history", method = RequestMethod.GET)
	public String getBookHistory(HttpSession session, @PathVariable Long bookId, Model model) {
		logger.debug("do getBookHistory...");
		Book bookParam = new Book();
		bookParam.setId(bookId);
		model.addAttribute("repository", bookRepositoryManager.findBookRepository(getSessionUser(session).getStore(), bookParam));
		model.addAttribute("sales", saleManager.findStoreSalesDailys(getSessionUser(session).getStore(), bookParam));
		model.addAttribute("stockOrders", orderManager.findStockOrders(getSessionUser(session).getStore(), bookParam));
		model.addAttribute("drawOrders", orderManager.findDrawOrders(getSessionUser(session).getStore(), bookParam));
		return ViewNames.FORWARD_BOOKS_HISTORY;
	}
	
}
