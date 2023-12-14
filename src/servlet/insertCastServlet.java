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

@WebServlet("/castInsert")
public class insertCastServlet extends HttpServlet {

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
        Cast insertedCast = objectMapper.readValue(jsonFromFrontend, Cast.class);

        CastDao cd = new CastDao();
        System.out.println("here1");
        cd.Insert(insertedCast);
        System.out.println("here2");

    }
}