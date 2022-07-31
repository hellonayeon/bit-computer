package me.hellonayeon.backend.bbs.dto.response;

public class BbsSeqResponse {

    private Integer seq;

    public BbsSeqResponse(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
