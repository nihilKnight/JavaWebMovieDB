package servlet;

import dao.CastDao;
import entity.Cast;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Movie;

@WebServlet("/movieCast")
public class CastServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer movie_id = Integer.valueOf(request.getParameter("movie_id"));

        CastDao cd = new CastDao();
        List<Cast> castList = cd.SelectByMovieID(movie_id);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCast = objectMapper.writeValueAsString(castList);
        response.getWriter().write(jsonCast);
    }
}
