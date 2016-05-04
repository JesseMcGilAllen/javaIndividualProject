package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.persistence.TopicDao;
import com.jessemcgilallen.lc.entity.Topic;

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
 * Created by jessemcgilallen on 5/3/16.
 */
@WebServlet(name = "showAlgorithm", urlPatterns = { "/algorithm" } )
public class AlgorithmShow extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = TopicService.getTopicForId(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/show-algorithm.jsp");
        dispatcher.forward(request, response);

    }
}
