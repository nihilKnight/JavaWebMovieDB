package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MoviesDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/genreUpdate")
public class genreUpdateServlet extends HttpServlet {

    public static class Movie_Genres{
        public Integer movie_id;
        public List<Integer> genre_ids;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取 JSON 字符串
        String jsonFromFrontend = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        // 将 JSON 字符串转换为 MovieWithCastDTO 对象
        ObjectMapper objectMapper = new ObjectMapper();

        Movie_Genres updatedMovie_Genres = objectMapper.readValue(jsonFromFrontend, Movie_Genres.class);

        System.out.println(objectMapper.writeValueAsString(updatedMovie_Genres));
        MoviesDao md = new MoviesDao();
        md.updateGenres(updatedMovie_Genres.movie_id, updatedMovie_Genres.genre_ids);

    }
}