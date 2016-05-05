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
import java.util.List;

/**
 * Created by jessemcgilallen on 4/20/16.
 */
@WebServlet(name = "languageDelete", urlPatterns = { "/languages/delete" } )
public class LanguageDelete extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());
    private final LanguageDao dao = new LanguageDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name  = request.getParameter("name");

        Language language = (Language) dao.findByName(name);
        logger.error("Language: " + language);
        dao.delete(language);
        request.setAttribute("languages", "");

        List<Language> languages = dao.findAll();

        request.setAttribute("languages", languages);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../read/languages" + ".jsp");
        logger.debug("Languages: " + request);
        dispatcher.forward(request, response);
    }
}
