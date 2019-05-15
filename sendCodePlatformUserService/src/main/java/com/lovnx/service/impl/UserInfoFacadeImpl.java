package com.lovnx.service.impl;


import com.lovnx.entity.ctr.UserInfo;
import com.lovnx.mapper.UserInfoMapper;
import com.lovnx.service.UserInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserInfoFacadeImpl implements UserInfoFacade {
	@Autowired
	private UserInfoMapper userInfoMapper;


	/**
	 * 根据用户编号获取用户信息
	 * @param userNo
	 * @return
	 */
	@Override
	public UserInfo getUserInfo(String userNo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userNo);
		return userInfoMapper.getUserInfo(userInfo);
	}

}
