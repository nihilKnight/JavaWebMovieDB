package servlet;// SearchActorsServlet.java
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.*;
import entity.Person;

@WebServlet("/SearchActorsServlet")
public class SearchActorsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String query = request.getParameter("query"); // Get the search query

        PersonDao pd = new PersonDao();
        List<Person> matchingPerson = new ArrayList<Person>();

        matchingPerson = pd.selectName(query, 1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPerson = objectMapper.writeValueAsString(matchingPerson);
        response.getWriter().write(jsonPerson);
    }
}
