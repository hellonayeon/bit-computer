package me.hellonayeon.pds.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

    Logger logger = LoggerFactory.getLogger(DownloadView.class);

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
        HttpServletResponse response) throws IOException {

        logger.info("DownloadView class: {}", new Date());

        File file = (File) model.get("downloadFile");
        String originalFile = (String) model.get("originalFile");
        int seq = (Integer) model.get("seq");

        // 한글 파일명을 설정
        originalFile = URLEncoder.encode(originalFile, "utf-8");

        response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Length", "" + file.length());
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try (
            OutputStream out = response.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            )
        {
            FileCopyUtils.copy(fis, out);
        }
    }
}
