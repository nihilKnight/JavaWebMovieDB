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

@WebServlet("/updateByMovieId")
public class updateServlet extends HttpServlet {
    public static class castPerson{
        public int cast_id = 0;
        public Integer movie_id = 0;
        public Integer actor_id = 0;
        public String character_name = "";

        public int getCast_id() {
            return cast_id;
        }

        public Integer getMovie_id() {
            return movie_id;
        }

        public Integer getActor_id() {
            return actor_id;
        }

        public String getCharacter_name() {
            return character_name;
        }

        public int getOrder_of_appearance() {
            return order_of_appearance;
        }

        public String getName() {
            return name;
        }

        public int getGender() {
            return gender;
        }

        public int order_of_appearance = 0;
        public String name = "";
        public int gender = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int movie_id = Integer.valueOf(request.getParameter("movie_id"));

        MoviesDao md = new MoviesDao();
        Movie movie = md.selectID(movie_id);
        request.setAttribute("movie_attribute", movie);

        List<Genre> allGenreList = new ArrayList<Genre>();
        List<Genre> selectedGenreList = new ArrayList<Genre>();
        GenreDao gd = new GenreDao();
        allGenreList = gd.SelectAll();
        selectedGenreList = gd.SelectByMovieId(movie_id);

        request.setAttribute("allGenresList", allGenreList);
        request.setAttribute("selectedGenreList", selectedGenreList);

        List<Cast> castList = new ArrayList<Cast>();
        CastDao cd = new CastDao();
        castList = cd.SelectByMovieID(movie_id);
        PersonDao pd = new PersonDao();
        List<castPerson> castPersonList = new ArrayList<castPerson>();
        int maxCastId = 0;
        for (int i=0;i< castList.size();i++){
            Person person = pd.SelectById(castList.get(i).actor_id);
            castPerson cp = new castPerson();
            cp.actor_id = castList.get(i).actor_id;
            cp.cast_id = castList.get(i).cast_id;
            cp.movie_id = castList.get(i).movie_id;
            cp.order_of_appearance = castList.get(i).order_of_appearance;
            cp.character_name = castList.get(i).character_name;
            cp.name = person.name;
            cp.gender = person.gender;
            castPersonList.add(cp);
            if (cp.cast_id > maxCastId) {
                maxCastId = cp.cast_id;
            }
        }

        request.setAttribute("castPersonList", castPersonList);
        request.setAttribute("maxCastId", maxCastId);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMovies = objectMapper.writeValueAsString(selectedGenreList);

        request.getRequestDispatcher("updateByMovieID.jsp").forward(request,response);
    }
}