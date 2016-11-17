package v001.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class MainFilter extends HttpServlet implements Filter{
	 
	  private FilterConfig filterConfig;
	 
	  public void init(FilterConfig filterConfig) {
	    this.filterConfig = filterConfig;
	  }
	 
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
	    try {
	      request.setCharacterEncoding("UTF-8");
	      filterChain.doFilter(request, response);
	    }
	    catch(ServletException sx) {
	      filterConfig.getServletContext().log(sx.getMessage());
	    }
	    catch(IOException iox) {
	      filterConfig.getServletContext().log(iox.getMessage());
	    }
	  }
	 
	}