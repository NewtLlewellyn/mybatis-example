package com.github.newtllewellyn.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.newtllewellyn.JacksonUtil;
import com.github.newtllewellyn.MyBatisInit;
import com.github.newtllewellyn.dao.StudentDao;
import com.github.newtllewellyn.user.Student;

/**
 * Root resource (exposed at "myresource" path)
 */
@Service
@Component
@Path("students")
public class StudentResource {
	
//	@Autowired
//    private ISomeService someService;
	
	private static Logger log = Logger.getLogger(StudentResource.class.getName());

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(@DefaultValue("as") @QueryParam("name") String name) {
		try {
			ObjectMapper omp = JacksonUtil.getMapper();
			StudentDao dao = MyBatisInit.getDao(StudentDao.class);
			Student s = dao.searchStudent(name);
			ObjectWriter w = omp.writer().withDefaultPrettyPrinter();

			return w.writeValueAsString(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "error", e);
			return e.getMessage();
		}
	}
}
