package com.jessemcgilallen.lc.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 5/10/16.
 */
@WebServlet(name = "examplesServlet", urlPatterns = { "examples/*" } )
public class Examples extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        String baseURL = "/pr/examples";

        String deleteExampleURL = baseURL + "/delete";

        if (servletPath.equals(deleteExampleURL)) {
            deleteExample(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        String baseURL = "/pr/examples";

        String newExampleURL = baseURL + "/new";

        if (servletPath.equals(newExampleURL)) {
            createExample(request, response);
        }

    }

    private void deleteExample(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../";

        TopicService.deleteTopicById(request);
        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);
    }

    private void createExample(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
