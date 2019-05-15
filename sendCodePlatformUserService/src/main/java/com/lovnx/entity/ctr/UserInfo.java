package com.lovnx.entity.ctr;

import lombok.Data;


import java.util.Date;

@Data
public class UserInfo {

   private String id;

   private String userName;

   private Integer age;

   private Date createDate;

   private String remarks;


}