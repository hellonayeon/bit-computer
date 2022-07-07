package bbs.model1.dto;

import java.io.Serializable;

// Public Domain Software (자료실)
public class PdsDto implements Serializable {

    private int seq;

    private String id;

    private String title;

    private String content;

    private String filename; // [원본 파일 이름]

    private String newFilename; // [저장되는 파일 이름] 충돌을 방지하기 위한, 실제로 저장되는 파일 이름

    private int readCount;

    private int downCount; // 다운로드 횟수

    private String regDate;

    public PdsDto(int seq, String id, String title, String content, String filename, String newFilename, int readCount, int downCount, String regDate) {
        this.seq = seq;
        this.id = id;
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.newFilename = newFilename;
        this.readCount = readCount;
        this.downCount = downCount;
        this.regDate = regDate;
    }

    public PdsDto(String id, String title, String content, String filename, String newFilename) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.newFilename = newFilename;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNewFilename() {
        return newFilename;
    }

    public void setNewFilename(String newFilename) {
        this.newFilename = newFilename;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
