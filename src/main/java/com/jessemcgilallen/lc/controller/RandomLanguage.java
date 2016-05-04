package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.LanguageDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        int languagesCount = languages.size();
        String parameters = parameterString(languagesCount - 1);
        String url = baseUrl + parameters;

        int randomNumber = randomNumberFromURL(url);
    }

    private List<Language> languages() {
        List<Language> languages = null;
        LanguageDao languageDao = new LanguageDao();

        languages = languageDao.findAll();

        return languages;

    }

    private String parameterString(int max) {
        int min = 0;
        int base = 10;
        int col = 1;
        String format = "plain";
        String random = "new";
        String paramString = "?min=" + min + "&max=" + max + "&col="
                + col + "&base=" + base + "&format=" + format + "&rnd=" + random;

        return paramString;
    }

    private int randomNumberFromURL(String url) {
        URL urlObject;
        HttpURLConnection connection;

        try {
            urlObject = new URL(url);
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            logger.error("Response Code: " + responseCode);

        } catch (MalformedURLException malformedException) {
            logger.error(malformedException);
        } catch (IOException ioException) {
            logger.error(ioException);
        }

        return 0;
    }

}
