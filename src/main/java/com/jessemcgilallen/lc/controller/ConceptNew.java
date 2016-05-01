package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;
import com.jessemcgilallen.lc.entity.Type;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.persistence.TopicDao;
import com.jessemcgilallen.lc.persistence.TypeDao;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 4/30/16.
 */
@WebServlet(name = "addConcept", urlPatterns = { "/languages/concepts/new"} )
public class ConceptNew extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LanguageDao languageDao = new LanguageDao();
        String name = request.getParameter("name");
        languageDao.openSession();
        Language language = languageDao.findByName(name);
        request.setAttribute("language", language);
        logger.debug("Sending " + language);
        languageDao.closeSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("../../create/new-concept" + ".jsp");

        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        logger.setLevel(Level.DEBUG);
        RequestDispatcher dispatcher;
        LanguageDao languageDao = new LanguageDao();
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        typeDao.openSession();
        Type type = typeDao.findByName("concept");
        typeDao.closeSession();

        String name = request.getParameter("nameField");
        String description = request.getParameter("descriptionField");
        String languageName = request.getParameter("language");


        languageDao.openSession();
        Language language = languageDao.findByName(languageName);
        languageDao.closeSession();
        Topic topic = new Topic();

        topic.setName(name);
        topic.addLanguage(language);
        topic.setDescription(description);
        topic.setType(type);

        topicDao.openSession();
        id = topicDao.create(topic);
        topicDao.closeSession();

        logger.debug("Id: " + id);

        request.setAttribute("language", language);

        if (id > 0) {
            dispatcher = request.getRequestDispatcher("../../read/show-language" + ".jsp");
        } else {
            dispatcher = request.getRequestDispatcher("../../create/new-concept" + ".jsp");
        }

        dispatcher.forward(request, response);
    }
}
