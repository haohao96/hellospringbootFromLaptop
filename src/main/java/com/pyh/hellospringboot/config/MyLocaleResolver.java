package com.pyh.hellospringboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //        获得默认的地区
        Locale locale = Locale.getDefault();
        String language=httpServletRequest.getParameter("l");
        if (!StringUtils.isEmpty(language))
        {
            String[] locales=language.split("_");
            locale=new Locale(locales[0],locales[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
