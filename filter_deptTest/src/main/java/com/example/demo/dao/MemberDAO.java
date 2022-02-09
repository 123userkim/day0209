package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;

@Repository
public class MemberDAO {
	//id 존재 x  : -1
	//암호가 일치 x  : 0 
	//암호 일치 o : 1
	public int isMember(String id, String usrPwd) {
		//db에 해당하는 진짜 암호
		String dbPwd = DBManager.isMember(id);
		int re = -1;
		if(dbPwd == null) {
			re = -1;
		}else  {
			if(usrPwd.equals(dbPwd)) {
				re = 1;
			}else {
				re = 0;
			}
		}
		return re;
	}
}
