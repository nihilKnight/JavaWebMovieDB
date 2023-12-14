package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GenreDao;
import dao.MoviesDao;
import entity.Genre;
import entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/genreById")
public class genreByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int genre_id = Integer.valueOf(request.getParameter("genre_id"));

        Genre genre = new GenreDao().SelectById(genre_id);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMovies = objectMapper.writeValueAsString(genre);
        response.getWriter().write(jsonMovies);
    }
}
