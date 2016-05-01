package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;
import com.jessemcgilallen.lc.entity.Type;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.persistence.TopicDao;
import com.jessemcgilallen.lc.persistence.TypeDao;
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
 * Created by jessemcgilallen on 4/30/16.
 */
@WebServlet(name = "addConcept", urlPatterns = { "/languages/concepts/new"} )
public class ConceptNew extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../../create/new-concept.jsp";
        request = TopicService.getWithLanguage(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request = TopicService.postWithLanguageAndTypeName(request, "concept");
        RequestDispatcher dispatcher;

        int id = (Integer)request.getAttribute("id");

        if (id > 0) {
            dispatcher = request.getRequestDispatcher("../../read/show-language" + ".jsp");
        } else {
            dispatcher = request.getRequestDispatcher("../../create/new-concept" + ".jsp");
        }

        dispatcher.forward(request, response);
    }
}
