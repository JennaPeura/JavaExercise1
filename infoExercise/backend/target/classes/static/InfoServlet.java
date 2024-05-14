package com.peura.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitInfo")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String pid = req.getParameter("pid");
        String address = req.getParameter("address");
        String nationality = req.getParameter("nationality");
        String language = req.getParameter("language");

        AddressParser addressParser = new AddressParser();
        int zipCode = Integer.parseInt(addressParser.extractNumber(address));
        String city = addressParser.extractCity(address);
        String actualAddress = addressParser.extractActualAddress(address);

        PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, pid, actualAddress, zipCode, city, nationality, language);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Information Received Successfully</h1>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Personal Identification Number: " + pid + "</p>");
        out.println("<p>Address: " + actualAddress + "</p>");
        out.println("<p>Zip Code: " + zipCode + "</p>");
        out.println("<p>City: " + city + "</p>");
        out.println("<p>Nationality: " + nationality + "</p>");
        out.println("<p>Language: " + language + "</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
