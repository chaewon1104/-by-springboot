package com.spring.web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class BoardEnty {
    
    private int bbsno;
    private String wname;
    private String subject;
    private String content;
    private String passwd;
    private int readcnt;
    private String regdt;
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

    
}
//