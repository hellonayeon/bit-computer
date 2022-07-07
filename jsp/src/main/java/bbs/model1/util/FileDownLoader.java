package bbs.model1.util;

import bbs.model1.dao.PdsDao;
import bbs.model1.dto.PdsDto;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/filedown")
public class FileDownLoader extends HttpServlet {

    ServletConfig mConfig = null;
    final int BUFFER_SIZE = 8192;

    PdsDao pdsDao = PdsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newFilename = req.getParameter("newFilename");
        int seq = Integer.parseInt(req.getParameter("seq"));

        PdsDto pds = pdsDao.getPds(seq);
        String filename = pds.getFilename();

        try {
            BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());

            String path = mConfig.getServletContext().getRealPath("/upload");

            path = path + "/" + newFilename;

            File f = new File(path);
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
            resp.setHeader("Content-Transfer-Encoding", "binary;");
            resp.setHeader("Content-Length", "" + f.length());
            resp.setHeader("Pragma", "no-cache;");
            resp.setHeader("Expires", "-1;");

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
            byte buffer[] = new byte[BUFFER_SIZE];
            int read = 0;

            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read); // 실제 다운로드 부분
            }
            in.close();
            out.close();

            // 다운로드 횟수 증가
            pdsDao.upDownCount(seq);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        mConfig = config;
    }
}
