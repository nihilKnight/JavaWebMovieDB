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

@WebServlet("/selectByMovieIDAndPersonID")
public class movieCastServlet extends HttpServlet {
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
        int person_id = Integer.valueOf(request.getParameter("person_id"));

        CastDao cd = new CastDao();
        Cast cast = cd.SelectByMovieIDAndPersonID(movie_id, person_id);
        PersonDao pd = new PersonDao();
        Person person = pd.SelectById(person_id);
        castPerson cp = new castPerson();
        cp.actor_id = cast.actor_id;
        cp.cast_id = cast.cast_id;
        cp.movie_id = cast.movie_id;
        cp.order_of_appearance = cast.order_of_appearance;
        cp.character_name = cast.character_name;
        cp.name = person.name;
        cp.gender = person.gender;


        request.setAttribute("castPerson", cp);


        request.getRequestDispatcher("updateByMovieIDAndPersonID.jsp").forward(request,response);
    }
}