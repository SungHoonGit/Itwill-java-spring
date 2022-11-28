package net.nbs;

public class NbsDTO {
    
    private int nbsno;
    private String subject;
    private String content;
    private int readcnt;
    private String regdt;
    
    public NbsDTO() { }

    public int getNbsno() {
        return nbsno;
    }

    public void setNbsno(int nbsno) {
        this.nbsno = nbsno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public String getRegdt() {
        return regdt;
    }

    public void setRegdt(String regdt) {
        this.regdt = regdt;
    }

    @Override
    public String toString() {
        return "NbsDTO [nbsno=" + nbsno + ", subject=" + subject + ", content=" + content + ", readcnt=" + readcnt
                + ", regdt=" + regdt + "]";
    }
    
}// class end
