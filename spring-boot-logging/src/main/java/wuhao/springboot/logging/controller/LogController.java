package wuhao.springboot.logging.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author PC
 */
@RestController
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logDemo() {
        log.trace("This is a TRACE log");
        log.debug("This is a DEBUG log");
        log.info("This is a INFO log");
        log.warn("This is a WARN log");
        log.error("This is a ERROR log");
        return "Logs have been generated";
    }
}



