package com.jessemcgilallen.lc.controller;

import com.jessemcgilallen.lc.persistence.LanguageDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jessemcgilallen on 4/20/16.
 */
@WebServlet(name = "Delete Language", urlPatterns = { "/languages/delete" } )
public class DeleteLanguage extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());
    private final LanguageDao dao = new LanguageDao();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  super.doDelete(req, resp);
    }
}
