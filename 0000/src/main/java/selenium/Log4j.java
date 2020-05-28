package selenium;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger log=Logger.getLogger("Log4j");
		//Level custom=Level.forName("custom",550);//for log4j 2 and above versions
		log.setLevel(Level.DEBUG);
		PropertyConfigurator.configure("log4j.properties");
		log.warn("this is just a warning");
		log.info("This is just a log info");
		log.debug("This is just a log debug");
		log.fatal("This is just a fata message");
		log.trace("this is just a trace message");
		log.error("This is a just a error message");
	}

}
