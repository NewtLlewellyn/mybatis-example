package com.github.newtllewellyn.resources;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.newtllewellyn.JacksonUtil;
import com.github.newtllewellyn.MyBatisInit;
import com.github.newtllewellyn.book.Book;
import com.github.newtllewellyn.book.BookInterface;
import com.github.newtllewellyn.dao.BookDao;


@Service
@Component
@Path("/books")
public class BookResource {

//	@Autowired
//    private ISomeService someService;
	
	private static Logger log = Logger.getLogger(BookResource.class.getName());

	@GET
	public String pppp() {
		return "ok";
	}
	
	@DELETE  @Path("{bookid}")
	public void deleteBook(@PathParam("bookid") String bookId) {
		BookDao dao = MyBatisInit.getDao(BookDao.class);
		dao.deleteBook(bookId);
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(String message) {
		ObjectMapper omp = JacksonUtil.getMapper();
		BookDao dao = MyBatisInit.getDao(BookDao.class);

		log.log(Level.INFO, message);
		Book b;
		try {
			b = omp.readValue(message, Book.class);
			dao.updateBook(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, "error", e);
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String createBook(String mesg) {
		try {
			ObjectMapper omp = JacksonUtil.getMapper();
			BookDao dao = MyBatisInit.getDao(BookDao.class);

			log.log(Level.INFO, mesg);
			Book b = omp.readValue(mesg, Book.class);
			dao.saveBook(b);
			ObjectWriter w = omp.writer().withDefaultPrettyPrinter();
			return w.writeValueAsString(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "error", e);
			return e.getMessage();
		}

	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(@QueryParam("bookid") String bookid) {
		try {
			ObjectMapper omp = JacksonUtil.getMapper();
			BookDao dao = MyBatisInit.getDao(BookDao.class);
			BookInterface s = dao.searchBookById(bookid);
			log.log(Level.INFO, s.toString());
			ObjectWriter w = omp.writer().withDefaultPrettyPrinter();

			return w.writeValueAsString(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "error", e);
			return e.getMessage();
		}

	}
}
