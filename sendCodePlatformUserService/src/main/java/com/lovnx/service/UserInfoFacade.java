package com.lovnx.service;





import com.lovnx.entity.ctr.UserInfo;

import java.util.Map;



public interface UserInfoFacade {

	/**根据用户编号获取信息
	 * @param userNo
	 * @return
	 */
	UserInfo getUserInfo(String userNo);


}
