package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jessemcgilallen on 5/4/16.
 */
public class RandomAlgorithm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Topic> algorithms = TopicService.topicsWithTypeName("algorithm");
        String requestUrl = "../read/show-algorithm.jsp";

        int algorithmsCount = algorithms.size();
        String url = RandomNumber.formUrlWithMax(algorithmsCount - 1);

        int randomNumber = RandomNumber.randomNumberFromURL(url);

        Topic algorithm = algorithms.get(randomNumber);

        request.setAttribute("topic", algorithm);
        RequestDispatcher dispatcher = request.getRequestDispatcher(requestUrl);
        dispatcher.forward(request, response);
    }

}
