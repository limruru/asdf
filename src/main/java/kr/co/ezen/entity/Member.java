package kr.co.ezen.entity;

import lombok.Data;

@Data //게터세터가 들어있다!!
public class Member {
	
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	private double latitude;
	private double longitude;
	
	
}
