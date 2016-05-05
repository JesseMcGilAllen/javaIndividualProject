package com.jessemcgilallen.lc.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jessemcgilallen on 5/4/16.
 */
public class RandomNumber {

    public static String formUrlWithMax(int max) {
        String baseUrl = "https://www.random.org/integers/";

        String parameters = parameterStringWithMax(max);
        String url = baseUrl + parameters;

        return url;
    }

    private static String parameterStringWithMax(int max) {
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

    public static int randomNumberFromURL(String url) {
        URL urlObject;
        HttpURLConnection connection;
        BufferedReader reader;
        int randomNumber = -1;
        Logger logger = Logger.getRootLogger();

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
}
