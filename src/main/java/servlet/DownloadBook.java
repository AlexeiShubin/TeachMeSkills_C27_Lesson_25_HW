package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static date.DateFormat.dateFormat;

@WebServlet("/book")
public class DownloadBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log(dateFormat(new Date())+"-скачивание");
        PrintWriter out = resp.getWriter();
        String name = "AutoScan.txt";
        String path = "E:\\";

        resp.setContentType("application/txt");
        resp.setHeader("Content-Disposition",
                "attachment; filename=\""
                        + name + "\"");
        FileInputStream inputStream
                = new FileInputStream(path + name);


        int in;
        while ((in = inputStream.read()) != -1) {
            out.write(in);
        }


        inputStream.close();
        out.close();
        log(dateFormat(new Date()) + " Файл скачан");
    }

}

