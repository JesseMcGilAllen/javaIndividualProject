package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Type;
import com.jessemcgilallen.lc.entity.Topic;

import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.persistence.TopicDao;
import com.jessemcgilallen.lc.persistence.TypeDao;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Alias;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 * Created by jessemcgilallen on 4/16/16.
 */

@WebServlet(name = "Show Language", urlPatterns = { "/language"} )

public class ShowLanguage extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        Language language = languageForName(name);

        List<Topic> concepts = topicsWithLanguageAndTypeName(language, "concept");
        List<Topic> terms = topicsWithLanguageAndTypeName(language, "term");

        request.setAttribute("language", language);
        request.setAttribute("concepts", concepts);
        request.setAttribute("terms", terms);

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/show-language" + ".jsp");

        dispatcher.forward(request, response);
    }

    private Language languageForName(String name) {
        LanguageDao dao = new LanguageDao();
        Language language = dao.findByName(name);

        return language;
    }

    private List<Topic> topicsWithLanguageAndTypeName(Language language, String typeName ) {
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        Type type = typeDao.findByName(typeName);
        List<Topic> topics = topicDao.topicsUsingsTopicCriteria(type, language);

        return topics;
    }

}
