package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CastDao;
import entity.Cast;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/castDelete")
public class castDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer person_id = Integer.valueOf(request.getParameter("person_id"));
        Integer movie_id = Integer.valueOf(request.getParameter("movie_id"));

        CastDao cd = new CastDao();
        cd.DeleteByMovieIDAndPersonID(movie_id, person_id);
    }
}