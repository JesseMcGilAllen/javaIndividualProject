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
 * Created by jessemcgilallen on 4/19/16.
 */
@WebServlet(name = "Add Language", urlPatterns = { "/languages/add"} )

public class AddLanguage extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        LanguageDao dao = new LanguageDao();
        Language language = new Language();
        language.setName(name);
        int id = dao.create(language);

        request.setAttribute("language", dao.findById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/show-language" + ".jsp");

        dispatcher.forward(request, response);
    }
}
