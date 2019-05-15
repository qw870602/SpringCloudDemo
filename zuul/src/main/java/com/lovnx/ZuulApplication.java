package com.lovnx;


import com.lovnx.filter.PreFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.lovnx.filter.ErrorFilter;
import com.lovnx.filter.ResultFilter;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@SpringCloudApplication
@ComponentScan(basePackages="com.lovnx")
public class ZuulApplication {

   public static void main(String[] args) {
      new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
   }

   @Bean
   public PreFilter preFilter(){
      return new PreFilter();
   }
   @Bean
   public ResultFilter resultFilter() {
      return new ResultFilter();
   }
   @Bean
   public ErrorFilter errorFilter() {
      return new ErrorFilter();
   }

}
