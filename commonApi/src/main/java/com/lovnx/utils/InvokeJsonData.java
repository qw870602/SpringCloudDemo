package com.lovnx.utils;

import com.lovnx.pojo.base.BasePojo;
import com.lovnx.pojo.base.BasePojoList;
import com.traffic.core.persistence.Page;

/**
 * 
 * @author yangxiaobo
 *
 */
public class InvokeJsonData {
	public static <T> BasePojo invokeData(Page<T> page, BasePojoList result) {
		com.lovnx.pojo.base.Page page2 = new com.lovnx.pojo.base.Page();
		page2.setPageNo(page.getPageNo());
		page2.setPageSize(page.getPageSize());
		page2.setTotalSize(page.getCount());
		
		result.setPage(page2);
		result.setData(page.getList());
		return result;
	}
}
