package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    private Logger logger;

    public LogUtil(Class<?> refClass) {
        logger = LogManager.getLogger(refClass);
    }

    public void warn(String msg){
        logger.warn(msg);
    }public void debug(String msg){
        logger.debug(msg);
    }public void error(String msg){
        logger.error(msg);
    }
    public void info(String msg){
        logger.info(msg);
    }

}
