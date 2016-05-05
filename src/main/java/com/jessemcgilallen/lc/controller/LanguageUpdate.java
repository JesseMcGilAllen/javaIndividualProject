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
 * Created by jessemcgilallen on 4/20/16.
 */

@WebServlet(name = "Update Language", urlPatterns = { "/languages/update" } )
public class LanguageUpdate extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());
    private final LanguageDao dao = new LanguageDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        Language language = (Language) dao.findByName(name);
        request.setAttribute("language", language);
        logger.debug("Sending " + language);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../update/update-language" + ".jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idField"));
        String name = request.getParameter("nameField");

        Language language = (Language) dao.findById(id);

        if (name.length() > 0) {
            language.setName(name);
        }

        dao.update(language);

        logger.debug("Id: " + id);
        request.setAttribute("language", language);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../read/show-language" + ".jsp");

        dispatcher.forward(request, response);
    }
}
