package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GenreDao;
import dao.MoviesDao;
import dao.CastDao;
import dao.PersonDao;
import entity.Person;
import entity.Cast;
import entity.Genre;
import entity.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateByPersonId")
public class SelectPersonByIDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int person_id = Integer.valueOf(request.getParameter("person_id"));

        PersonDao pd = new PersonDao();
        Person person = pd.SelectById(person_id);

        request.setAttribute("person", person);

        request.getRequestDispatcher("updateByPersonID.jsp").forward(request,response);
    }
}
