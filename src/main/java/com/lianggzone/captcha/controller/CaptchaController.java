package com.lianggzone.captcha.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lianggzone.captcha.service.CaptchaService;

/**
 * <h3>概要:</h3><p>CaptchaController</p>
 * <h3>功能:</h3><p>CaptchaController</p>
 * <h3>履历:</h3>
 * <li>2017年5月16日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@RestController
@RequestMapping(value = "/v0.1/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void genCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getParameter("token");
        // TODO:有效性检验优化
        Assert.hasText(token);
        captchaService.genCaptcha(token, req, resp);
    }

    /**
     * 查询图片验证码
     */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public Map<String, Object> findCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getParameter("token");
        String reqCaptchaCode = req.getParameter("captchaCode");
        // TODO:有效性检验优化
        Assert.hasText(token);
        Assert.hasText(reqCaptchaCode);
        String captchaCode = captchaService.findCaptcha(token);
        
        Map<String, Object> params = new HashMap<String, Object>();
        boolean isValid = false;
        if(reqCaptchaCode.equals(captchaCode)){
            isValid = true;
        }
        params.put("valid", isValid);
        return params;
    }
}