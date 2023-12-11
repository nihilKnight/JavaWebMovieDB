package servlet;

import dao.MoviesDao;
import entity.Movie;
import entity.Cast;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/movieDetail")
public class movieDetailServlet extends HttpServlet {

    static class MovieWithCast{
        public Movie movie;
        public List<Cast> castList;

        public MovieWithCast(Movie movie, List<Cast> castList) {
            this.movie = movie;
            this.castList = castList;
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer movie_id = Integer.valueOf(request.getParameter("movie_id"));

        MoviesDao md = new MoviesDao();
        Movie movie = md.selectID(movie_id);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMovie = objectMapper.writeValueAsString(movie);
        response.getWriter().write(jsonMovie);
    }
}