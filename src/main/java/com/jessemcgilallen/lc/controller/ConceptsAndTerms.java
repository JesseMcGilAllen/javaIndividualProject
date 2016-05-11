package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;

import java.util.List;

import com.jessemcgilallen.lc.persistence.LanguageDao;
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
 * Created by jessemcgilallen on 5/10/16.
 */

@WebServlet(name = "conceptsAndTerms", urlPatterns = { "/concepts/*", "/terms/*" } )
public class ConceptsAndTerms extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);

        String baseConceptsURL = "/pr/concepts";
        String baseTermsURL = "/pr/terms";

        String showConceptURL = baseConceptsURL + "/show";
        String updateConceptURL = baseConceptsURL + "/update";
        String deleteConceptURL = baseConceptsURL + "/delete";
        String newConceptURL = baseConceptsURL + "/new";

        String showTermURL = baseTermsURL + "/show";
        String updateTermURL = baseTermsURL + "/update";
        String deleteTermURL = baseTermsURL + "/delete";
        String newTermURL = baseTermsURL + "/new";

        if (servletPath.equals(showConceptURL)) {
            showTermOrConcept("concept", request, response);
        } else if (servletPath.equals(updateConceptURL)) {
            updateTermOrConceptGet("concept", request, response);
        } else if (servletPath.equals(deleteConceptURL)) {
            logger.error("In Delete switch");
            deleteTermOrConcept("concept", request, response);
        } else if (servletPath.equals(showTermURL)) {
            showTermOrConcept("term", request, response);
        } else if (servletPath.equals(updateTermURL)) {
            updateTermOrConceptGet("term",request, response);
        } else if (servletPath.equals(deleteTermURL)) {
            deleteTermOrConcept("term", request, response);
        } else if (servletPath.equals(newConceptURL)) {
            createTermOrConceptGet("concept", request, response);
        } else if (servletPath.equals(newTermURL)) {
            createTermOrConceptGet("term", request, response);
        }
        logger.setLevel(Level.WARN);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getRequestURI();

        logger.setLevel(Level.DEBUG);
        logger.warn("Get Path: " + servletPath);

        String baseConceptsURL = "/pr/concepts";
        String baseTermsURL = "/pr/terms";

        String newConceptURL = baseConceptsURL + "/new";
        String updateConceptURL = baseConceptsURL + "/update";
        String showConceptURL = baseConceptsURL + "/show";

        String newTermURL = baseTermsURL + "/new";
        String updateTermURL = baseTermsURL + "/update";
        String showTermURL = baseTermsURL + "/show";

        if (servletPath.equals(updateConceptURL)) {
            updateTermOrConceptPost("concept", request, response);
        } else if (servletPath.equals(showConceptURL)) {
            showTermOrConcept("concept", request, response);
        } else if (servletPath.equals(newConceptURL)) {
            createTermOrConceptPost("concept", request, response);
        } else if (servletPath.equals(newTermURL)) {
            createTermOrConceptPost("term", request, response);
        } else if (servletPath.equals(updateTermURL)) {
            updateTermOrConceptPost("term", request, response);
        } else if (servletPath.equals(showTermURL)) {
            showTermOrConcept("term", request, response);
        }

        logger.setLevel(Level.WARN);
    }

    private void createTermOrConceptGet(String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../create/new-" + type + ".jsp";
        request = TopicService.getNewWithLanguage(request);

        forwardRequestToURL(request, response, url);
    }

    private void createTermOrConceptPost(String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url;

        request = TopicService.postNewWithLanguageAndTypeName(request, type);

        int id = (Integer)request.getAttribute("id");

        if (id > 0) {
            String languageName = request.getParameter("languageName");
            logger.error("Language Name: " + languageName);
            url = "../language?name=" + languageName;
        } else {
            url = "../create/new-" + type + ".jsp";
        }

        forwardRequestToURL(request, response, url);
    }

    private void showTermOrConcept(String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../read/show-" + type + ".jsp";
        request = TopicService.getTopicForId(request);
        String name = request.getParameter("languageName");
        request.setAttribute("languageName", name);
        logger.info("attribute: " + request.getAttribute("languageName"));

        forwardRequestToURL(request, response, url);
    }


    private void updateTermOrConceptGet(String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "../update/update-" + type + ".jsp";
        request = TopicService.getTopicForId(request);
        
        String languageName = request.getParameter("languageName");
        request.setAttribute("languageName", languageName);

        logger.info("Update: " + request.getAttribute("languageName"));

        forwardRequestToURL(request, response, url);
    }

    private  void updateTermOrConceptPost(String type, HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String languageName = (String) request.getParameter("languageName");
        String url = "../language?name=" + languageName;

        request = TopicService.updateTopicById(request);

        forwardRequestToURL(request, response, url);
    }

    private void deleteTermOrConcept(String type, HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {

        String languageName = (String) request.getParameter("languageName");
        String url = "../language?name=" + languageName;

        TopicService.deleteTopicById(request);

        forwardRequestToURL(request, response, url);
    }

    private void forwardRequestToURL(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String url) throws ServletException, IOException  {

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
