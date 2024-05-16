package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static date.DateFormat.dateFormat;

@WebServlet("/load-book")
@MultipartConfig(maxFileSize = 15*1024*1024, fileSizeThreshold = 1024*1024*5)
public class LoadBook extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            log(dateFormat(new Date()) + "-загрузка");
            Part partFile = req.getPart("name");
            partFile.write("E:\\Server\\" + partFile.getSubmittedFileName());
            PrintWriter out = resp.getWriter();
            log("fff");
            out.print("File uploaded successfully");
            log(dateFormat(new Date()) + " Файл загружен.");
        }
}
