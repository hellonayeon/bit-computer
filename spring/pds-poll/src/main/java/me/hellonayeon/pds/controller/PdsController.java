package me.hellonayeon.pds.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.hellonayeon.pds.dto.PdsDto;
import me.hellonayeon.pds.service.PdsService;
import me.hellonayeon.pds.util.PdsUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PdsController {

    Logger logger = LoggerFactory.getLogger(PdsController.class);

    @Autowired
    PdsService service;


    @RequestMapping(value = "pdslist.do", method = RequestMethod.GET)
    public String pdslist(Model model) {
        logger.info("PdsController.class pdslist(): {}", new Date());

        List<PdsDto> list = service.pdslist();
        model.addAttribute("pdslist", list);

        return "pdslist.tiles";
    }

    @RequestMapping(value = "pdswrite.do", method = RequestMethod.GET)
    public String pdswrite() {
        logger.info("PdsController.class pdswrite(): {}", new Date());

        return "pdswrite.tiles";
    }

    @RequestMapping(value = "pdsupload.do", method = RequestMethod.POST)
    public String pdsupload(PdsDto pds,
                            @RequestParam(value = "fileload", required = false) MultipartFile fileload,
                            HttpServletRequest req) {
        logger.info("PdsController.class pdsupload: {}", new Date());

        // 파일명 가져오기
        String filename = fileload.getOriginalFilename();
        System.out.println("filename: " + filename);

        pds.setFilename(filename);

        // 업로드 경로 설정
        String fupload = req.getServletContext().getRealPath("/upload");

        // 폴더
//        String fupload = "D:\\upload";

        System.out.println(fupload);

        // 파일명 변경
        String newFilename = PdsUtil.getNewFileName(pds.getFilename());
        pds.setNewfilename(newFilename);

        File file = new File(fupload + "/" + newFilename);

        try {
            FileUtils.writeByteArrayToFile(file, fileload.getBytes());
            service.uploadPds(pds);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/pdslist.do";
    }

    @RequestMapping(value = "filedownload.do", method = RequestMethod.GET)
    public String filedownload(String newfilename, int seq, String filename,
                                Model model, HttpServletRequest req) {

        String fupload = req.getServletContext().getRealPath("/upload");

        File downloadFile = new File(fupload + "/" + newfilename);
        model.addAttribute("downloadFile", downloadFile);
        model.addAttribute("originalFile", filename);
        model.addAttribute("seq", seq);

        return "downloadView";

    }

    @RequestMapping(value = "pdsdetail.do", method = RequestMethod.GET)
    public String pdsdetail(int seq, Model model) {

        PdsDto pds = service.pdsdetail(seq);
        model.addAttribute("pds", pds);

        return "pdsdetail.tiles";

    }
}
