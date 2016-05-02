package com.jessemcgilallen.lc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 5/2/16.
 */

@WebServlet(name = "newAlgorithm", urlPatterns = { "/algorithms/new" } )
public class AlgorithmNew extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = TopicService.postNewWithTypeName(request, "algorithm");

        RequestDispatcher dispatcher;

        int id = (Integer)request.getAttribute("id");

        if (id > 0) {
            dispatcher = request.getRequestDispatcher("../algorithms");
        } else {
            dispatcher = request.getRequestDispatcher("../create/new-algorithm" + ".jsp");
        }

        dispatcher.forward(request, response);
    }
}
