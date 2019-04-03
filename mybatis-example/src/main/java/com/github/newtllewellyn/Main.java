package com.github.newtllewellyn;

//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;

//import java.io.IOException;
//import java.net.URI;
//import java.util.Scanner;
//import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//class ShutDownMain {
//	private final CountDownLatch signal;
//
//	ShutDownMain(CountDownLatch signal) {
//		this.signal = signal;
//	}
//
//	public void shutDownMain() {
//		Scanner in = new Scanner(System.in);
//		String a = in.next();
//		if (a == "stop")
//			signal.countDown();
//	}
//
//}

/**
 * Main class.
 *
 */

@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new Main()
                .configure(new SpringApplicationBuilder(Main.class))
                .run(args);
    }
}


//@SpringBootApplication
//public class Main {
//	
//
//	public Main() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Main.class);
//	}
	
	
	
	
	//	public static CountDownLatch signal = new CountDownLatch(1);
//
//	// Base URI the Grizzly HTTP server will listen on
//	public static final String BASE_URI = "http://localhost:8080/library/";
//	
//	
//	public static void shutdown() {
//		signal.countDown();
//	}
//
//	/**
//	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
//	 * application.
//	 * 
//	 * @return Grizzly HTTP server.
//	 */
//	public static HttpServer startServer() {
//		// create a resource config that scans for JAX-RS resources and providers
//		// in com.example package
//		final ResourceConfig rc = new ResourceConfig().packages("com.github.newtllewellyn.resources");
//
//		// create and start a new instance of grizzly http server
//		// exposing the Jersey application at BASE_URI
//		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
//	}
//
//	/**
//	 * Main method.
//	 * 
//	 * @param args
//	 * @throws IOException
//	 */
//	public static void main(String[] args) throws IOException {
//		final HttpServer server = startServer();
//		System.out.println(String.format(
//				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
//				BASE_URI));
////        System.in.read();
////		server.shutdown();
//		try {
//			ShutDownMain sdMain = new ShutDownMain(signal);
//			sdMain.shutDownMain();
//			signal.await();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//}
