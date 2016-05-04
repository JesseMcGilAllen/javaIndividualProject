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
@WebServlet(name = "updateAlgorithm", urlPatterns = { "algorithms/update" } )
public class AlgorithmUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = TopicService.getTopicForId(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/show-algorithm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../read/show-algorithm.jsp";

        request = TopicService.updateTopicById(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
