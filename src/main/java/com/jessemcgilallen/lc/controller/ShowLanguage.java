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

        LanguageDao dao = new LanguageDao();
        Language language = dao.findByName(name);
        request.setAttribute("language", language);

        TypeDao typeDao = new TypeDao();
        Type conceptType = typeDao.findByName("concept");

        HashMap<String, Object> restrictions = new HashMap<>();

        restrictions.put("languages.id", (Integer) language.getId());
        restrictions.put("type.id", (Integer) conceptType.getId());

        TopicDao topicDao = new TopicDao();
        List<Topic> concepts = topicDao.topicsUsingsTopicCriteria(conceptType, language);
        logger.setLevel(Level.DEBUG);
        logger.debug(concepts);

        request.setAttribute("concepts", concepts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("read/show-language" + ".jsp");

        dispatcher.forward(request, response);
    }

}
