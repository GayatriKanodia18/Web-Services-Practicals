package com.example.client;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/calculate")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        try {
            String xml = SOAPClient.callService(a, b, operation);

            int start = xml.indexOf("<return>");
            start = xml.indexOf(">", start) + 1;

            int end = xml.indexOf("</return>");

            String result = xml.substring(start, end).trim();

            request.setAttribute("result", result);

        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
        }

        request.getRequestDispatcher("index.jsp")
               .forward(request, response);
    }
}
