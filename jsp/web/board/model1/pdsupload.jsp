<%@ page import="java.io.IOException" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="bbs.model1.dao.PdsDao" %>
<%@ page import="bbs.model1.dto.PdsDto" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    // 실제 파일 업로드를 처리하는 함수
    // FileItem: 파일 정보를 취득할 때 사용하는 클래스
    public String processUploadFile(FileItem fileItem, String newFilename, String dir) throws IOException {

        String f = fileItem.getName();
        long sizeOfBytes = fileItem.getSize();

        System.out.println(String.format("[filename]=%s", f));
        System.out.println(String.format("[file size of bytes]=%d", sizeOfBytes));

        String fileName = "";
        String fPost = "";

        if (sizeOfBytes > 0) {

            int idx = f.lastIndexOf("\\");
            if (idx == -1) {
                idx = f.lastIndexOf("/");
            }
            fileName = f.substring(idx + 1);

            try {

                File uploadFile = new File(dir, newFilename); // 변환된 파일 이름

                fileItem.write(uploadFile);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return fileName;
    }
%>
<%
    // tomcat (Web Server) 올리기 = 실무에서 사용하는 방법
    String fUpload = application.getRealPath("/upload");

    // 지정 폴더에 올리기
//    String fUpload = "d:\\tmp";

    int yourMaxRequestSize = 100 * 1024 * 1024; // 1M
    int yourMaxMemorySize = 100 * 1024; // 1K

    // form field 에 데이터를 저장할 수 있는 공간
    String id = "";
    String title = "";
    String content = "";

    // file 데이터
    String filename = "";
    String newFilename = "";

    boolean isMulipart = ServletFileUpload.isMultipartContent(request);
    if (isMulipart) {
        // FileItem 생성하는 클래스
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(yourMaxMemorySize);
        factory.setRepository(new File(fUpload));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(yourMaxRequestSize);

        List<FileItem> items = upload.parseRequest(request);
        Iterator<FileItem> it = items.iterator();

        while (it.hasNext()) {
            FileItem item = it.next();

            if (item.isFormField()) { // id, title, content
                if (item.getFieldName().equals("id")) {
                    id = item.getString("utf-8");
                }
                else if (item.getFieldName().equals("title")) {
                    title = item.getString("utf-8");
                }
                else if (item.getFieldName().equals("content")) {
                    content = item.getString("utf-8");
                }

            }
            else { // file

                if (item.getFieldName().equals("fileload")) {

                    // 확장자명
                    String fname = item.getName();
                    int lastInNum = fname.lastIndexOf(".");
                    String exName = fname.substring(lastInNum);
                    System.out.println(fname + " " + lastInNum + " " + exName);

                    // 새로운 파일명
                    newFilename = (new Date().getTime()) + "";
                    newFilename = newFilename + exName;

                    filename = processUploadFile(item, newFilename, fUpload);
                }

            }
        }
    }
    else {
        System.out.println("request is not multipart type !!");
    }

    // DB에 저장
    PdsDao dao = PdsDao.getInstance();
    boolean isS = dao.writePds(new PdsDto(id, title, content, filename, newFilename));
    if (isS) {
%>
        <script>
            alert("파일 업로드 성공 :>");
            location.href = "pdslist.jsp";
        </script>
<%
    }
    else {
%>

        <script>
            alert("파일 업로드 실패 :<");
            location.href = "pdswrite.jsp";
        </script>

<%
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
