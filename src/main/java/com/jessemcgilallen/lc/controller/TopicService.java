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
import java.util.List;


/**
 * Created by jessemcgilallen on 5/1/16.
 */
public class TopicService {
    private static Logger logger = Logger.getRootLogger();

    public static HttpServletRequest getNewWithLanguage(HttpServletRequest request) {
        LanguageDao languageDao = new LanguageDao();
        String name = request.getParameter("name");

        Language language = languageDao.findByName(name);
        request.setAttribute("language", language);
        logger.debug("Sending " + language);

        return request;
    }

    public static HttpServletRequest postNewWithLanguageAndTypeName(HttpServletRequest request,
                                                                String typeName) {
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
        request.setAttribute("language", language.getName());

        return request;
    }

    public static HttpServletRequest postNewWithTypeName(HttpServletRequest request, String typeName) {
        int id;
        logger.setLevel(Level.DEBUG);

        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        String name = request.getParameter("nameField");
        String description = request.getParameter("descriptionField");

        Type type = typeDao.findByName(typeName);

        Topic topic = new Topic();

        topic.setName(name);
        topic.setDescription(description);
        topic.setType(type);

        id = topicDao.create(topic);

        request.setAttribute("id", id);

        return request;
    }

    public static HttpServletRequest getAllTopicsForTypeName(
            HttpServletRequest request, String typeName) {
        TopicDao topicDao = new TopicDao();
        TypeDao typeDao = new TypeDao();

        Type type = typeDao.findByName(typeName);

        List<Topic> topics =  topicDao.topicsWithType(type);
        System.out.println("Topics" + topics);
        request.setAttribute("topics", topics);

        return request;
    }

    public static HttpServletRequest getTopicForId(HttpServletRequest request) {
        TopicDao topicDao = new TopicDao();
        logger.setLevel(Level.INFO);

        int id = idFromRequest(request);
        logger.info("Id: " + id);

        Topic topic = (Topic) topicDao.findById(id);

        logger.info("Topic: " + topic.toString());

        request.setAttribute("topic", topic);

        return request;
    }

    public static HttpServletRequest updateTopicById(HttpServletRequest request) {
        TopicDao topicDao = new TopicDao();
        int id = idFromRequest(request);
        Topic topic = (Topic) topicDao.findById(id);

        topic = updateTopicWithRequest(topic, request);

        topicDao.update(topic);

        request.setAttribute("topic", topic);
        return request;
    }

    public static void deleteTopicById(HttpServletRequest request) {
        TopicDao topicDao = new TopicDao();
        logger.setLevel(Level.INFO);

        int id = idFromRequest(request);
        logger.info("Id: " + id);

        Topic topic = (Topic) topicDao.findById(id);

        topicDao.delete(topic);

    }

    private static int idFromRequest(HttpServletRequest request) {
        Logger logger = LogManager.getRootLogger();

        String idString = request.getParameter("id");

        logger.setLevel(Level.INFO);

        logger.info("IdString: " + idString);

        int id = Integer.parseInt(idString);
        logger.info("Id: " + id);

        return id;
    }

    private static Topic updateTopicWithRequest(Topic topic, HttpServletRequest request) {
        String name = request.getParameter("nameField");
        String description = request.getParameter("descriptionField");

        if (!(name.equals(topic.getName())) && name.length() > 0) {
            logger.info("Name Change");
            topic.setName(name);
        }

        if (!(description.equals(topic.getDescription())) && description.length() > 0) {
            topic.setDescription(description);
        }

        return topic;
    }

    public static List<Topic> topicsWithTypeName(String typeName) {
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        Type type = typeDao.findByName(typeName);
        List<Topic> topics = topicDao.topicsWithType(type);

        return topics;

    }

    public static List<Topic> topicsWithLanguageAndTypeName(Language language, String typeName ) {
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        Type type = typeDao.findByName(typeName);
        List<Topic> topics = topicDao.topicsUsingTopicCriteria(type, language);

        return topics;
    }



}
