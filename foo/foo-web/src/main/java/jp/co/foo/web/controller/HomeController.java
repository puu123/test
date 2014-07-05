package jp.co.foo.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.PrintWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import jp.co.foo.service.ZipService;

//import jp.co.foo.data.dto.Foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@Validated
@Scope( proxyMode = ScopedProxyMode.TARGET_CLASS )
//http://stackoverflow.com/questions/7638251/mixing-jdk-and-cglib-proxies-within-spring
/*
 * Something doesn't match here - if ther is a $ProxyXX, it means there is an interface. Make sure there is no interface. 
 * Some other notes:
 * in your pointcut you can check if the target object is already a proxy using (x instanceof Advised), then you can cast to Advised
 * you can use <aop:scoped-proxy /> to define the proxy strategy per-bean
 */
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ZipService zipService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! ^^; The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//Foo foo = new Foo();
		//foo.setName("abc");
		
		System.out.println(zipService.count());
		
		return "home";
	}
	
	@RequestMapping(value = "/{num}/index.html", method = RequestMethod.GET)
	public String homeN(@Size(min = 5, max = 5) @PathVariable("num") String num, Locale locale, Model model) {
		
		logger.info("Welcome home! ^^; The client locale is {}. {}", locale, num);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//Foo foo = new Foo();
		//foo.setName("abc");
		
		return "home";
	}
}
