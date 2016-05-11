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
        String servletPath = request.getRequestURI();
        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);
        String baseURL = "/pr/katas";

        String showKataURL = baseURL + "/show";
        String updateKataURL = baseURL + "/update";
        String deleteKataURL = baseURL + "/delete";

        if (servletPath.equals(baseURL)) {
            showKatas(request, response);
        } else if (servletPath.equals(showKataURL)) {
            showKata(request, response);
        } else if (servletPath.equals(updateKataURL)) {
            updateKataGet(request, response);
        } else if (servletPath.equals(deleteKataURL)) {
            deleteKata(request, response);
        }
        logger.setLevel(Level.WARN);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();
        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);
        String baseURL = "/pr/katas";

        String newKataURL = baseURL + "/new";
        String updateKataURL = baseURL + "/update";
        String showKataURL = baseURL + "/show";

        if (servletPath.equals(updateKataURL)) {
            updateKataPost(request, response);
        } else if (servletPath.equals(showKataURL)) {
            showKata(request, response);
        } else if (servletPath.equals(newKataURL)) {
            createKata(request, response);
        } else if (servletPath.equals(baseURL)) {
            showKatas(request, response);
        }

        logger.setLevel(Level.WARN);
    }

    private void createKata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void showKatas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "read/katas.jsp";
        request = TopicService.getAllTopicsForTypeName(request, "kata");

        forwardRequestToURL(request, response, url);

    }

    private void showKata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../read/show-kata.jsp";
        request = TopicService.getTopicForId(request);

        forwardRequestToURL(request, response, url);
    }

    private void updateKataGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../update/update-kata.jsp";
        request = TopicService.getTopicForId(request);

        forwardRequestToURL(request, response, url);
    }

    private  void updateKataPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String url = "../katas/show";
        request = TopicService.updateTopicById(request);

        forwardRequestToURL(request, response, url);
    }

    private void deleteKata(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
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
