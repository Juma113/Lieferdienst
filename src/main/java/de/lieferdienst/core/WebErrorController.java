package de.lieferdienst.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WebErrorController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebErrorController.class);

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model)
    {
        String errorPage = "error";
        String pageTitle = "Error";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null)
        {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value())
            {
                pageTitle = "Not Found Page";
                errorPage = "/error/404";
                LOGGER.error("Error 404");
            }
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
            {
                pageTitle = "Internal Server Error";
                errorPage = "/error/500";
                LOGGER.error("Error 500");
            }
            else if (statusCode==HttpStatus.FORBIDDEN.value())
            {
                pageTitle = "Forbidden Error";
                errorPage = "/error/403";
                LOGGER.error("Error 403");
            }
        }
        model.addAttribute("title",pageTitle);


        return errorPage;
    }
}
