package com.jessemcgilallen.lc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by jessemcgilallen on 5/1/16.
 */

@WebServlet(name = "addTerm", urlPatterns = { "/languages/terms/new"} )
public class TermNew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../../create/new-term.jsp";
        request = TopicService.getNewWithLanguage(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = TopicService.postNewWithLanguageAndTypeName(request, "term");

        RequestDispatcher dispatcher;

        int id = (Integer)request.getAttribute("id");

        if (id > 0) {
            String languageName = (String) request.getAttribute("language");
            dispatcher = request.getRequestDispatcher("../../language?name=" + languageName);
        } else {
            dispatcher = request.getRequestDispatcher("../../create/new-term" + ".jsp");
        }

        dispatcher.forward(request, response);
    }
}
