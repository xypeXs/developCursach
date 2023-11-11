package ru.rsatu.cursach;


import jakarta.servlet.annotation.WebServlet;
import ru.rsatu.cursach.service.ReferenceService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/time")
public class MainServlet extends HttpServlet {

    private final ReferenceService referenceService;

    @Inject
    public MainServlet(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.close();
    }
}
