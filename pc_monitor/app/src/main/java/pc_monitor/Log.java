package pc_monitor;

import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class Log {
    public Logger logger = Logger.getLogger("PC_Monitor");

    public Log() {
        try {
            FileHandler handler = new FileHandler("default_log.txt", true);
            logger.addHandler(handler);
        } catch (Exception e) {
            System.out.println("Failure while trying to configure the log handler.");
        }
    }

    public void info(String msg){
        logger.info(msg);
    }

    public void error(String msg, Exception ex){
        logger.severe(msg + " | Exception: " + ex.getMessage());
    }
}
