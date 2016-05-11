package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.entity.Language;

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
        LanguageDao languageDao = new LanguageDao();

        List<Language> languages = languageDao.findAll();
        String idString = request.getParameter("topicId");

        request.setAttribute("languages", languages);
        request.setAttribute("id", idString);

        forwardRequestToURL(request, response, url);
    }

    private void deleteExample(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../";

        TopicService.deleteTopicById(request);
        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);
    }

    private void createExamplePost(HttpServletRequest request, HttpServletResponse response) {

    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
