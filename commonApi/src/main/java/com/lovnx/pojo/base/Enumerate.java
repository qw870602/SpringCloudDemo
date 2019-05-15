package com.lovnx.pojo.base;

public enum Enumerate
{
    /**
     * @Fields INDEX : TODO(未登录)
     */
    OK("ok"),
    
    /**
     * @Fields INDEX : TODO(首页)
     */
    INDEX("/"),
    
    /**
     * @Fields LOGIN : TODO(前台登录)
     */
    LOGIN("^/user/login[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields REGISTER : TODO(前台注册)
     */
    REGISTER("^/user/register[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields ERROR : TODO(错误页面请求)
     */
    ERROR("(^/WEB-INF/jsp/error/(\\s|\\S)+)|(^/error/(\\s|\\S)+)"),
    
    /**
     * @Fields CUSTOMER : TODO(没有登录不允许访问的)
     */
    CUSTOMER("^/customer/[\\w-\\*._/?&=#%:]*$"),
    
    MY_LOVE("^/51ai/[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields PORTAL_SYSTEM : TODO(后台系统管理)
     */
    PORTAL_SYSTEM("^/portal/system/[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields PORTAL_SYSTEM : TODO(后台系统管理)
     */
    PORTAL_SYSTEM_DIC("^/portal/system/dic/[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields PORTAL_SYSTEM : TODO(后台系统管理)
     */
    PORTAL_SYSTEM_REGION("^/portal/system/region/[\\w-\\*._/?&=#%:]*$"),
    
    /**
     * @Fields PORTAL_LOGIN : TODO(后台系统管理登录)
     */
    PORTAL_LOGIN("^(/portal/system/login)|(/portal/system/login2Main)$"),
    
    /**
     * @Fields CUSTOMER_LOGIN_USER : TODO(前台登录的用户)
     */
    CUSTOMER_LOGIN_USER("CUSTOMER_LOGIN_USER"),
    
    /**
     * @Fields PORTAL_LOGIN_USER : TODO(后台登录的用户)
     */
    PORTAL_LOGIN_USER("PORTAL_LOGIN_USER"),
    
    /**
     * @Fields PORTAL_LOGIN_USER_POWER : TODO(后台登录的用户的权限)
     */
    PORTAL_LOGIN_USER_POWER("PORTAL_LOGIN_USER_POWER"),
    
    /**
     * @Fields ERROR_MSG : TODO(错误信息)
     */
    ERROR_MSG("ERROR_MSG"),
    
    /**
     * @Fields LAST_URL : TODO(最后请求的链接)
     */
    LAST_URL("LAST_URL"),
    
    /**
     * @Fields IOS_TOKEN : TODO(IOS请求标识)
     */
    TOKEN_IOS("iosToken"),
    
    /**
     * @Fields ANDROID_TOKEN : TODO(安卓请求标识)
     */
    TOKEN_ANDROID("androidToken"),
    
    /**
     * @Fields UN_LOGIN_6 : TODO(第三方请求时，判断未登录返回的结果)
     */
    UN_LOGIN_6("3D2F8900F2E49C02B481C2F717AA9020"),
    
    /** 
    * @Fields PHONE : TODO(手机号) 
    */ 
    PHONE("PHONE"),

    /**
     * @Fields ANDROID_TOKEN : TODO(缓存的后缀)
     */
    BUFFER("BUFFER"),
    /**
     * @Fields REGION_LIST : TODO(所有地区List缓存)
     */
    REGION_LIST("REGION_LIST"),
    /**
     * @Fields REGION_NUll_LIST : TODO(所有地区List缓存[包括不限])
    */
    REGION_NUll_LIST("REGION_NUll_LIST"),
    /**
     * @Fields REGION_MAP : TODO(所有行政地区Map缓存)
     */
    REGION_MAP("REGION_MAP"),
    /**
     * @Fields STATE_LIST : TODO(所有市级行政地区List缓存)
     */
    STATE_LIST("STATE_LIST"),
    /**
     * @Fields STATE_MAP : TODO(所有市级行政地区Map缓存)
     */
    STATE_MAP("STATE_MAP"),
    /**
    * @Fields CITIES_LIST : TODO(所有县级地区List缓存)
    */
    CITIES_LIST("CITIES_LIST"),
    /**
     * @Fields KEYWORDS_LIST : TODO(所有关键词List缓存)
     */
    KEYWORDS_LIST("KEYWORDS_LIST"),
    /**
     * @Fields TAGS_LIST : TODO(所有标签List缓存)
     */
    TAGS_LIST("TAGS_LIST"),
    /**
     * @Fields ADDRESS_HOT_LIST : TODO(热门地区List缓存)
     */
    ADDRESS_HOT_LIST("ADDRESS_HOT_LIST"),
    /**
     * @Fields FP_ : TODO(订单编号—前缀)
     */
    FP_("FP_");
    
    private String value;
    
    public String getValue()
    {
        return value;
    }

    private Enumerate(String value)
    {
        this.value = value;
    }


}
