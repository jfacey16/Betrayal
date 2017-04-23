package com.term_project.system;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import spark.ExceptionHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Hello world!
 *
 */
public class Main
{
	private static final int DEFAULT_PORT = 4567;
	
	public static void main(String[] args) {
	    new Main(args).run();
	}
	private String[] args;

	    private Main(String[] args) {
	        this.args = args;
	}

	private void run() {
    	OptionParser parser = new OptionParser();
        parser.accepts("gui");
        parser.accepts("port").withRequiredArg().ofType(Integer.class)
            .defaultsTo(DEFAULT_PORT);
        OptionSet options = parser.parse(args);
    	
        if (options.has("gui")) {
            runSparkServer((int) options.valueOf("port"));
        } else {
    		System.out.println("Starting REPL");
            Environment env = new Environment();
            try {
              env.startRepl();
            } catch (Throwable e) {
              e.printStackTrace();
            }
    	}
    }
    
    /*
     * Spark methods are currently residing in Main. We've discussed moving them if they get too over-bearing.
     * 
     */
    private static FreeMarkerEngine createEngine() {
        Configuration config = new Configuration();
        File templates = new File("src/main/resources/spark/template/freemarker");
        try {
          config.setDirectoryForTemplateLoading(templates);
        } catch (IOException ioe) {
          System.out.printf("ERROR: Unable use %s for template loading.%n",
              templates);
          System.exit(1);
        }
        return new FreeMarkerEngine(config);
      }

      private void runSparkServer(int port) {
        Spark.port(port);
        Spark.externalStaticFileLocation("src/main/resources/static");
        Spark.exception(Exception.class, new ExceptionPrinter());

        FreeMarkerEngine freeMarker = createEngine();

        // Setup Spark Routes
        Spark.get("/betrayal_menu", new MenuHandler(), freeMarker);
      }
      
      private static class MenuHandler implements TemplateViewRoute {

    	    @Override
    	    public ModelAndView handle(Request req, Response res) {

    	      String message = "Let's play Betrayal! Create or join a lobby below:";

    	      Map<String, Object> variables = ImmutableMap.of("title",
    	          "Betrayal at House on the Hill", "message", message);
    	      return new ModelAndView(variables, "menu.ftl");
    	    }
      }
      
      private static class ExceptionPrinter implements ExceptionHandler {
    	    @Override
    	    public void handle(Exception e, Request req, Response res) {
    	      res.status(500);
    	      StringWriter stacktrace = new StringWriter();
    	      try (PrintWriter pw = new PrintWriter(stacktrace)) {
    	        pw.println("<pre>");
    	        e.printStackTrace(pw);
    	        pw.println("</pre>");
    	      }
    	      res.body(stacktrace.toString());
    	    }
    	  }
    
}
