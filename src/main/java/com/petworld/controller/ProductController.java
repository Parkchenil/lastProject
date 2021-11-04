package com.petworld.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;

import com.petworld.command.ProductVO;
import com.petworld.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping("productTotal")
	public void productTotal(Model model) {
		ArrayList<ProductVO> list = productService.getList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("productDetail")
	public void productDetail(@RequestParam("pID") int pID, Model model) {
		ProductVO vo = productService.getContent(pID);
		model.addAttribute("vo", vo);
		System.out.println(vo.toString());
	}
	
	@RequestMapping("/cart")
	public void cart() {
	}
	
	@RequestMapping("/cancel")
	public void cancel() {
		
	}
	
	
	@RequestMapping("/change")
	public void change() {
		
	}
}
