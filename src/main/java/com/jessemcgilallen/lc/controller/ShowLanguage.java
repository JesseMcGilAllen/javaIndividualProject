package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by jessemcgilallen on 4/16/16.
 */

@WebServlet(name = "Show Language", urlPatterns = { "/language"} )

public class ShowLanguage extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.warn("Testing");
        String name = request.getParameter("name");
        logger.debug("Parameter Name: " + name);


        LanguageDao dao = new LanguageDao();


        Language language = dao.findByName(name);


        logger.debug("Sending " + language);
        request.setAttribute("language", language);
        logger.debug("Sending " + language);

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/show-language" + ".jsp");
        logger.debug("Language: " + request);
        dispatcher.forward(request, response);
    }
}
