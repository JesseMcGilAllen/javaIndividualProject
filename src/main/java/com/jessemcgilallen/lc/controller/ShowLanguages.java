package com.jessemcgilallen.lc.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.entity.Language;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by jessemcgilallen on 4/6/16.
 */

@WebServlet(name = "Show Languages", urlPatterns = { "/languages"} )


public class ShowLanguages extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.warn("Testing");

        LanguageDao dao = new LanguageDao();
        List<Language> languages = dao.findAll();
        logger.debug("Size: " + languages.size());
        request.setAttribute("languages", languages);
        for (Language language: languages) {
            logger.debug(" Language: " + language.getName());
        }
        logger.debug("Sending the languages...");

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/languages" + ".jsp");
        logger.debug("Languages: " + request);
        dispatcher.forward(request, response);
    }



}
