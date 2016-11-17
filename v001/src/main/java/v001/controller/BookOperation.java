package v001.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import v001.model.Book;
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

		String funcString = request.getParameter("func");

		if (funcString == null) {
			response.sendRedirect("error/error.jsp");
			return;
		}
		switch (funcString) {
		case "delete_book":
			try (MyQueryFactory fact = new MyQueryFactory()) {
				fact.initConnection();
				String idBookPar = request.getParameter("checked_id");
				fact.markBookDeleted(Integer.valueOf(idBookPar));

				response.sendRedirect("book_table.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				response.sendRedirect("error/error.jsp");
			}
			return;
			
		case "edit_book":
			try (MyQueryFactory fact = new MyQueryFactory()) {
				fact.initConnection();
				String idBookPar = request.getParameter("checked_id");
				
				Book book = fact.returnBook(Integer.valueOf(idBookPar));
				request.getSession().setAttribute("id_attr", book.id);
				request.getSession().setAttribute("name_attr", book.name);
				request.getSession().setAttribute("isdn_attr", book.isdn);
				request.getSession().setAttribute("autor_id_attr",
						book.autor_id);

				response.sendRedirect("book/edit_book.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error/error.jsp");
			}
			return;
			
			
		case "save_edited_book":

			try (MyQueryFactory fact = new MyQueryFactory()) {
				fact.initConnection();
				Book book = new Book(
						Integer.valueOf(request.getParameter("id")),
						request.getParameter("name"),
						request.getParameter("isdn"), Integer.valueOf(request
								.getParameter("autor_id")));

				int countUpdated = fact.saveEditedBook(book);

				if (countUpdated == 0) {
					response.sendRedirect("../error/error.jsp");
					return;
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				response.sendRedirect("error/error.jsp");
				return;
			}

			response.sendRedirect("book_table.jsp");
			return;
		case "new_book":
			response.sendRedirect("book/new_book.jsp");
			return;
			
			
		case "save_new_book":

			try (MyQueryFactory fact = new MyQueryFactory()) {
				fact.initConnection();
				Book book = new Book(
						0,
						request.getParameter("name"),
						request.getParameter("isdn"), Integer.valueOf(request
								.getParameter("autor_id")));

				int countUpdated = fact.saveNewBook(book);

				if (countUpdated == 0) {
					response.sendRedirect("../error/error.jsp");
					return;
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				response.sendRedirect("error/error.jsp");
				return;
			}

			response.sendRedirect("book_table.jsp");
			return;
		default:
			response.sendRedirect("error/error.jsp");
		}

	}

}
