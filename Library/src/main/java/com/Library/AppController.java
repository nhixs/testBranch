package com.Library;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private BookService service;
	
	@RequestMapping(value = {"/","/book"})
	public String viewHomePage(Model model) {
		List<Book> listBooks = service.listAll();
		model.addAttribute("listBooks", listBooks);
		
		return "index";
		
	}
	@RequestMapping("/new")
	public String showNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "newBook";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book")Book book) {
		service.save(book);
		
		return "redirect:/";
	}
	@RequestMapping("/editBook/{id}")
	public ModelAndView showEditBookPage(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("editBook");
		Book book = service.get(id);
		mav.addObject("book", book);
		
		return mav;
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);;
		return "redirect:/";		
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> get(@PathVariable Integer id) {
		try {
			Book book = service.get(id); 
		  return new ResponseEntity<Book>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}		
	}
	

}
