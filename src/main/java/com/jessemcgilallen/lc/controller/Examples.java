package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.*;
import com.jessemcgilallen.lc.persistence.ExampleDao;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.persistence.TopicDao;

import com.jessemcgilallen.lc.entity.Language;

import org.apache.log4j.Level;
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
 * Created by jessemcgilallen on 5/10/16.
 */
@WebServlet(name = "examplesServlet", urlPatterns = { "/examples/*" } )
public class Examples extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());
    private final ExampleDao exampleDao = new ExampleDao();
    private final LanguageDao languageDao = new LanguageDao();
    private  final TopicDao topicDao = new TopicDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        String baseURL = "/pr/examples";

        String deleteExampleURL = baseURL + "/delete";
        String newExampleURL = baseURL + "/new";


        if (servletPath.equals(deleteExampleURL)) {
            deleteExample(request, response);
        } else if (servletPath.equals(newExampleURL)) {
            createExampleGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        String baseURL = "/pr/examples";

        String newExampleURL = baseURL + "/new";

        if (servletPath.equals(newExampleURL)) {
            createExamplePost(request, response);
        }

    }

    private void createExampleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../create/new-example.jsp";


        List<Language> languages = languageDao.findAll();
        String idString = request.getParameter("topicId");

        request.setAttribute("languages", languages);
        request.setAttribute("topicId", idString);

        forwardRequestToURL(request, response, url);
    }

    private void deleteExample(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../";

        int id = Integer.parseInt(request.getParameter("id"));
        Example example = (Example) exampleDao.findById(id);
        exampleDao.delete(example);

        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);
    }

    private void createExamplePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String url;

        logger.setLevel(Level.DEBUG);

        id = createExample(request);

        if (id > 0) {
            url = backToTopicURL(request);
        } else {
            url = "../create/new-example.jsp";
        }

        forwardRequestToURL(request, response, url);
    }

    private int createExample(HttpServletRequest request) {
        String topicString = request.getParameter("topicId");
        String languageString = request.getParameter("languageSelect");
        logger.debug("Request Language: " + languageString);
        int topicId = Integer.parseInt(topicString);
        int languageId = Integer.parseInt(languageString);
        logger.error("Language: " + languageId);

        Language language = (Language) languageDao.findById(languageId);
        Topic topic = (Topic) topicDao.findById(topicId);

        String gistURL = request.getParameter("gistField");

        Example example = new Example();

        example.setCode(gistURL);
        example.setLanguage(language);
        example.setTopic(topic);

        logger.error("Example: " + example);

        return exampleDao.create(example);
    }

    private String backToTopicURL(HttpServletRequest request) {
        String url;

        int topicId = Integer.parseInt(request.getParameter("topicField"));
        Topic topic = (Topic) topicDao.findById(topicId);
        Type type = topic.getType();

        url = "../" + type.getName() + "s/show?id=" + topic.getId();

        return url;
    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
