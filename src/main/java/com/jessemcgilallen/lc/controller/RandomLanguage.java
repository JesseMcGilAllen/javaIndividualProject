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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.List;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 5/4/16.
 */
@WebServlet(name = "randomLanguage", urlPatterns = { "/random/language" } )
public class RandomLanguage extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Language> languages = languages();
        String requestUrl = "../read/show-language.jsp";
        int languagesCount = languages.size();
        String url = RandomNumber.formUrlWithMax(languagesCount - 1);
        int randomNumber = RandomNumber.randomNumberFromURL(url);
        Language language = languages.get(randomNumber);

        request = assignAttributesOnRequestWithLanguage(request, language);

        RequestDispatcher dispatcher = request.getRequestDispatcher(requestUrl);
        dispatcher.forward(request, response);
    }

    private List<Language> languages() {
        List<Language> languages = null;
        LanguageDao languageDao = new LanguageDao();

        languages = languageDao.findAll();

        return languages;

    }

    private HttpServletRequest assignAttributesOnRequestWithLanguage(HttpServletRequest request, Language language) {


        List<Topic> concepts = TopicService.topicsWithLanguageAndTypeName(language, "concept");
        List<Topic> terms = TopicService.topicsWithLanguageAndTypeName(language, "term");

        request.setAttribute("language", language);
        request.setAttribute("concepts", concepts);
        request.setAttribute("terms", terms);

        return request;
    }


}
