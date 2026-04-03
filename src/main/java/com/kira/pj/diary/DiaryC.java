package com.kira.pj.diary;

import com.kira.pj.main.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = "/diary")
public class DiaryC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("diary~~~~??");
        try {
            Connection con = DBManager.connection();
            PreparedStatement pstmt = con.prepareStatement("select * from pictures");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println(rs.getString("p_text"));
            System.out.println("db success!!!!");
        } catch (SQLException e) {
    e.printStackTrace();
        }
        DiaryM.getCalendar(request);
        request.setAttribute("content", "diary/diary.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    public void destroy() {
    }
}