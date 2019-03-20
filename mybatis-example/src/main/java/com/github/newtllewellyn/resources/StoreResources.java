package com.github.newtllewellyn.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.newtllewellyn.JacksonUtil;
import com.github.newtllewellyn.MyBatisInit;
import com.github.newtllewellyn.dao.StoreRecordDao;
import com.github.newtllewellyn.store.StoreRecord;

@Path("stores")
public class StoreResources {
	private static Logger log = Logger.getLogger(StoreResources.class.getName());

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(@DefaultValue("121") @QueryParam("bookid") String uuid) {
		try {
			ObjectMapper omp = JacksonUtil.getMapper();
			StoreRecordDao dao = MyBatisInit.getDao(StoreRecordDao.class);
			StoreRecord s = dao.searchStoreRecordById(uuid);
			ObjectWriter w = omp.writer().withDefaultPrettyPrinter();

			return w.writeValueAsString(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "error", e);
			return e.getMessage();
		}
	
	}
}
