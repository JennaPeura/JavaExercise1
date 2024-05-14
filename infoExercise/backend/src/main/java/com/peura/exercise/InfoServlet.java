package com.peura.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitInfo")
public class InfoServlet extends HttpServlet {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       BufferedReader reader = req.getReader();
        StringBuilder jsonPayload = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonPayload.append(line);
        }

        JsonNode jsonNode = objectMapper.readTree(jsonPayload.toString());

        String firstName = jsonNode.get("fname").asText();
        String lastName = jsonNode.get("lname").asText();
        String pid = jsonNode.get("pid").asText();
        String address = jsonNode.get("address").asText();
        String nationality = jsonNode.get("nationality").asText();
        String language = jsonNode.get("language").asText();


        AddressParser addressParser = new AddressParser();
        int zipCode = Integer.parseInt(addressParser.extractNumber(address));
        String city = addressParser.extractCity(address);
        String actualAddress = addressParser.extractActualAddress(address);

        PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, pid, actualAddress, zipCode, city, nationality, language);

        // Send back the info if it's successful to test
        String jsonResponse = objectMapper.writeValueAsString(personalInfo);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setContentType("application/json");
    
        PrintWriter out = resp.getWriter();
        out.println(jsonResponse);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
