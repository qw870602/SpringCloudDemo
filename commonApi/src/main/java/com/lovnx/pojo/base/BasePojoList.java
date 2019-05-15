package com.lovnx.pojo.base;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="restful返回对象",description="返回给app端的参数由此对象接收")
public class BasePojoList extends BasePojo
{
	
    private static final long serialVersionUID = 1L;
    
    /**
     * 查询结果集
     */
    @ApiModelProperty(value="返回的json数据",name="data")
    private List<?> data = new ArrayList<>();
   
    @JsonView(BasePojo.hasNotPage.class) 
    public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
    
   
    private Page page;

  
    @JsonView(BasePojo.hasPage.class) 
    public Page getPage()
    {
        return page;
    }

    public void setPage( Page page )
    {
        this.page = page;
    }

}
