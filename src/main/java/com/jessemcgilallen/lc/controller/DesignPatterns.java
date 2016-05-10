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
 * Created by jessemcgilallen on 5/9/16.
 */@WebServlet(name = "designPattern", urlPatterns = { "/design-patterns", "/design-patterns/*" } )
public class DesignPatterns extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String baseURL = "/design-patterns";

        if (servletPath.equals(baseURL)) {
            showPatterns(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showPatterns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "read/design-patterns.jsp";
        request = TopicService.getAllTopicsForTypeName(request, "design pattern");

        forwardRequestToURL(request, response, url);

    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
