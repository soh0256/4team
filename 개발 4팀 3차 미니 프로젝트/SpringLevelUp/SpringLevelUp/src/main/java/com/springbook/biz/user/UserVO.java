package com.springbook.biz.user;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

//VO(Value Object)
@Getter @Setter
public class UserVO {
	private String id;
	private String pw;
	private String email;
	private String name;
	private String user_image;
	private String birth;
	private String phone_num;
	private String address;
	private String post_num;
	private Date ent_date;
	private String grade;

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", email=" + email + ", name=" 
				+ name + ", user_image=" + user_image + ", birth=" 
				+ birth + ", phone_num=" + phone_num + ", address=" + address + ", post_num=" 
				+ post_num + ", ent_date=" + ent_date + ", grade=" + grade + "]";
	}
}