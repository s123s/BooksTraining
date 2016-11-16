package v001.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import v001.model.MyQueryFactory;

/**
 * Servlet implementation class BookOperation
 */
public class BookOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BookOperation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * ServletOutputStream out = response.getOutputStream();
		 * out.print("asdas"); out.flush(); out.close();
		 */
		String funcString = request.getParameter("func");
		
		if (funcString == null) {
			response.sendRedirect("error/error.jsp");
			return;
		}
		switch (funcString) {
		case "delete_book":
			try (MyQueryFactory fact = new MyQueryFactory()) {
				fact.initConnection();
				String idBookPar = request.getParameter("checked");
				fact.markBookDeleted(Integer.valueOf(idBookPar));
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("book_table.jsp");
			return;
		case "edit_book":
			response.sendRedirect("book/edit_book.jsp");
			return;
		case "new_book":
			response.sendRedirect("book/new_book.jsp");
			return;
		default:
			response.sendRedirect("error/error.jsp");
		}

	}

}
