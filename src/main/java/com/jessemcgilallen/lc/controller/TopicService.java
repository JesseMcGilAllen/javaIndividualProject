package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;
import com.jessemcgilallen.lc.entity.Type;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import com.jessemcgilallen.lc.persistence.TopicDao;
import com.jessemcgilallen.lc.persistence.TypeDao;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by jessemcgilallen on 5/1/16.
 */
public class TopicService {

    public static HttpServletRequest getWithLanguage(HttpServletRequest request) {
        Logger logger = LogManager.getRootLogger();

        LanguageDao languageDao = new LanguageDao();
        String name = request.getParameter("name");

        Language language = languageDao.findByName(name);
        request.setAttribute("language", language);
        logger.debug("Sending " + language);

        return request;
    }

    public static HttpServletRequest postWithLanguageAndTypeName(HttpServletRequest request,
                                                                String typeName) {
        Logger logger = LogManager.getRootLogger();

        int id;
        logger.setLevel(Level.DEBUG);

        LanguageDao languageDao = new LanguageDao();
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        String name = request.getParameter("nameField");
        String description = request.getParameter("descriptionField");
        String languageName = request.getParameter("language");

        Language language = languageDao.findByName(languageName);
        Type type = typeDao.findByName(typeName);

        Topic topic = new Topic();

        topic.setName(name);
        topic.addLanguage(language);
        topic.setDescription(description);
        topic.setType(type);

        id = topicDao.create(topic);

        request.setAttribute("id", id);
        request.setAttribute("language", language);

        return request;
    }

}
