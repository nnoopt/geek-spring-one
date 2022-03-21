package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    private ProductRepo userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new ProductRepo();
        this.userRepository.insert(new Product("Meat", 35543));
        this.userRepository.insert(new Product("Sugar", 454));
        this.userRepository.insert(new Product("Chips", 545));
        this.userRepository.insert(new Product("Pasta", 545));
        this.userRepository.insert(new Product("Tea", 546));
        this.userRepository.insert(new Product("Bread", 678));
        this.userRepository.insert(new Product("Water", 54));
        this.userRepository.insert(new Product("Salt", 545));
        this.userRepository.insert(new Product("Bananas", 876));
        this.userRepository.insert(new Product("Tomato", 54678));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("<h1>Привет от сервлета!!!</h1>");
//        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
//        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
//        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
//        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
//        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
//        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");

        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Title</th>");
        wr.println("<th>Coast</th>");
        wr.println("</tr>");

        for(Product user : userRepository.findAll()) {
            wr.println("<tr>");
            wr.println("<td><a href='" + "#link" +"'>" + user.getId() +"</a></td>");
            wr.println("<td>" + user.getTitle() + "</td>");
            wr.println("<td>" + user.getCost() + "</td>");
            wr.println("</tr>");
        }

        wr.println("</table>");
    }
}