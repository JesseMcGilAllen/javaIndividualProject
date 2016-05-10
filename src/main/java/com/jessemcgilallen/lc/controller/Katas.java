package com.jessemcgilallen.lc.controller;

/**
 * Created by jessemcgilallen on 5/9/16.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "katas", urlPatterns = { "/katas", "/katas/*" } )
public class Katas extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);
        String baseURL = "/katas";

        String showPatternURL = baseURL + "/show";
        String updatePatternURL = baseURL + "/update";
        String deletePatternURL = baseURL + "/delete";

        if (servletPath.equals(baseURL)) {
            showPatterns(request, response);
        } else if (servletPath.equals(showPatternURL)) {
            showPattern(request, response);
        } else if (servletPath.equals(updatePatternURL)) {
            updatePatternGet(request, response);
        } else if (servletPath.equals(deletePatternURL)) {
            deletePattern(request, response);
        }
        logger.setLevel(Level.WARN);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);
        String baseURL = "/katas";

        String newPatternURL = baseURL + "/new";
        String updatePatternURL = baseURL + "/update";
        String showPatternURL = baseURL + "/show";

        if (servletPath.equals(updatePatternURL)) {
            updatePatternPost(request, response);
        } else if (servletPath.equals(showPatternURL)) {
            showPattern(request, response);
        } else if (servletPath.equals(newPatternURL)) {
            createPattern(request, response);
        }

        logger.setLevel(Level.WARN);
    }

    private void createPattern(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url;
        request = TopicService.postNewWithTypeName(request, "kata");

        int id = (Integer)request.getAttribute("id");

        if (id > 0) {
            url = "../katas";
        } else {
            url = "../create/new-kata.jsp";
        }

        forwardRequestToURL(request, response, url);
    }

    private void showPatterns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "read/katas.jsp";
        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);

    }

    private void showPattern(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../read/show-kata.jsp";
        request = TopicService.getTopicForId(request);

        forwardRequestToURL(request, response, url);
    }

    private void updatePatternGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../update/update-kata.jsp";
        request = TopicService.getTopicForId(request);

        forwardRequestToURL(request, response, url);
    }

    private  void updatePatternPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String url = "../katas/show";
        request = TopicService.updateTopicById(request);

        forwardRequestToURL(request, response, url);
    }

    private void deletePattern(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String url = "../read/katas.jsp";

        TopicService.deleteTopicById(request);
        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);
    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
