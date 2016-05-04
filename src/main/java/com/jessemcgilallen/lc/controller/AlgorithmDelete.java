package com.jessemcgilallen.lc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 5/4/16.
 */
@WebServlet(name = "deleteAlgorithm", urlPatterns = { "/algorithms/delete" } )
public class AlgorithmDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../read/algorithms.jsp";

        TopicService.deleteTopicById(request);

        request = TopicService.getAllTopicsForTypeName(request, "algorithm");

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);

        dispatcher.forward(request, response);


    }
}
