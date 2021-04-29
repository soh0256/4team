package com.springbook.biz.notice;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

//VO(Value Object)
@Getter @Setter
public class NoticeVO {
	private String notice_no;
	private String notice_title;
	private String notice_contents;
	private Date notice_date;
	private int notice_hits;
	private String searchCondition; // 검색조건
	private String searchKeyword; // 검색 내용
	private MultipartFile uploadFile; // 파일 업로드

	@Override
	public String toString() {
		return "NoticeVO [notice_no=" + notice_no + ", notice_title=" + notice_title + ",  notice_contents="
				+ notice_contents + ", notice_date=" + notice_date + ", notice_hits=" + notice_hits + "]";
	}
}