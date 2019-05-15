
package com.lovnx.pojo.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

public class Page implements Serializable
{

    private static final long serialVersionUID = 1L;

    public Page(){}
   
    /**
     * 查询的页数
     */
    private int pageNo = 1;


    /**
     * 页面大小/每页显示数
     */
    private int pageSize = 10;
    /**
     * 总数
     */
    private long totalSize = 0;
  

 

   /* public void initCondition() {
        this.startNumber = this.pageNumber >= 1 ? (this.pageNumber - 1) * this.pageSize : 0;
    }
*/
   
    @JsonView(BasePojo.hasPage.class) 
    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize( int pageSize )
    {
        this.pageSize = pageSize;
    }

   


    @JsonView(BasePojo.hasPage.class) 
	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	@JsonView(BasePojo.hasPage.class) 
	public int getPageNo() {
		return pageNo;
	}



	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

  
}
