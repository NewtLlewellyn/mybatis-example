package com.github.newtllewellyn;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.github.newtllewellyn.resources.BookResource;
import com.github.newtllewellyn.resources.BorrowRecordResoures;
import com.github.newtllewellyn.resources.StoreResources;
import com.github.newtllewellyn.resources.StudentResource;


@Component
@ApplicationPath("library")
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(BookResource.class);
		register(StudentResource.class);
		register(BorrowRecordResoures.class);
		register(StoreResources.class);
	}
}
