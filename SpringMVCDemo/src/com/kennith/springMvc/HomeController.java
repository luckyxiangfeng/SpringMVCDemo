package com.kennith.springMvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.ModelAndView;  


@Controller  
public class HomeController {  
    //@RequestMapping 中请求Action为"home"，支持方法有post,get， (required = false)参数非必要  
    @RequestMapping(value = "home", method = { RequestMethod.POST,  
            RequestMethod.GET })  
    public String responsePage(@RequestParam(required = false) String page) {  
        return page;  
    }  
      
    //支持HTTP协议所有方法，@ResoinseBody = 响应此“方法”返回值为页面内容。参数键为"para"，默认para默认值为"this is body"  
    @ResponseBody  
    @RequestMapping(value = "getshow")  
    public String responseBody(@RequestParam(value = "para", defaultValue = "this is body content", required = false) String content) {  
        return content;  
    }  
      
    //显示El表达式，响应body.jsp视图  
    @RequestMapping(value = "getel")  
    public ModelAndView responseEL(){  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("message", "你们好！我是通过EL表达式出来的内容");  
        mv.setViewName("body");  
        return mv;  
    }  
}  