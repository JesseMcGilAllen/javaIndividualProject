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
        String baseUrl = "https://www.random.org/integers/";
        String requestUrl = "../read/show-language.jsp";

        int languagesCount = languages.size();
        String parameters = parameterString(languagesCount - 1);
        String url = baseUrl + parameters;

        int randomNumber = randomNumberFromURL(url);

        Language language = languages.get(randomNumber);
        List<Topic> concepts = topicsWithLanguageAndTypeName(language, "concept");
        List<Topic> terms = topicsWithLanguageAndTypeName(language, "term");

        request.setAttribute("language", language);
        request.setAttribute("concepts", concepts);

        request.setAttribute("terms", terms);


        RequestDispatcher dispatcher = request.getRequestDispatcher(requestUrl);
        dispatcher.forward(request, response);
    }

    private List<Language> languages() {
        List<Language> languages = null;
        LanguageDao languageDao = new LanguageDao();

        languages = languageDao.findAll();

        return languages;

    }

    private String parameterString(int max) {
        int num = 1;
        int min = 0;
        int base = 10;
        int col = 1;
        String format = "plain";
        String random = "new";
        String paramString = "?num=" + num + "&min=" + min + "&max=" + max + "&col="
                + col + "&base=" + base + "&format=" + format + "&rnd=" + random;

        return paramString;
    }

    private int randomNumberFromURL(String url) {
        URL urlObject;
        HttpURLConnection connection;
        BufferedReader reader;
        int randomNumber = -1;

        logger.setLevel(Level.INFO);
        try {
            urlObject = new URL(url);
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            logger.info("Response Code: " + responseCode);

            reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String response = reader.readLine();
            randomNumber = Integer.parseInt(response);

        } catch (MalformedURLException malformedException) {
            logger.error(malformedException);
        } catch (IOException ioException) {
            logger.error(ioException);
        }

        return randomNumber;
    }

    private List<Topic> topicsWithLanguageAndTypeName(Language language, String typeName ) {
        TypeDao typeDao = new TypeDao();
        TopicDao topicDao = new TopicDao();

        Type type = typeDao.findByName(typeName);
        List<Topic> topics = topicDao.topicsUsingTopicCriteria(type, language);

        return topics;
    }

}
