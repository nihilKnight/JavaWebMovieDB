package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CrewDao;
import entity.Crew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/movieCrew")
public class CrewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer movie_id = Integer.valueOf(request.getParameter("movie_id"));

        CrewDao cd = new CrewDao();
        List<Crew> crewList = cd.SelectByMovieID(movie_id);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCrew = objectMapper.writeValueAsString(crewList);
        response.getWriter().write(jsonCrew);
    }
}
