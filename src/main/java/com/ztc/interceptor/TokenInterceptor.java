package com.ztc.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ztc.anno.NoToken;
import com.ztc.entity.Users;
import com.ztc.entity.Users;
import com.ztc.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份验证：token拦截器 拦截所有请求（除了@notoken注解） 1、获取请求里的token 2、验证token是否正确
 * 
 * @author Administrator
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		// 检查是否有NoToken注释，有则跳过认证
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		if (method.isAnnotationPresent(NoToken.class)) {
			NoToken passToken = method.getAnnotation(NoToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 设置响应的编码
		response.setCharacterEncoding("utf-8");
		// 获取参数token
		String tokenStr = request.getParameter("token");
		if (StringUtils.isBlank(tokenStr)){
			//请求头里面取token
			tokenStr=request.getHeader("token");
		}
		// 验证token
		if (tokenStr != null && tokenStr != "") {
			try {
				Users admin = TokenUtil.unsign(tokenStr, Users.class);
				if (admin != null) {
					// 如果能解密成功，说明验证通过
					System.out.println(admin);
					return true;
				}
			} catch (Exception e) {
				// 否则，验证不通过，返回失败信息
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				JSON json = new JSONObject();
				Map<String, Object> rslmap = new HashMap<>();
				rslmap.put("code", "500");
				rslmap.put("msg", "身份认证失败，请先登录");
				response.getWriter().append(json.toJSONString(rslmap));
				System.out.println("认证失败");
				return false;
			}
		}
		// 否则，验证不通过，返回失败信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		JSON json = new JSONObject();
		Map<String, Object> rslmap = new HashMap<>();
		rslmap.put("code", "500");
		rslmap.put("msg", "身份认证失败，请先登录");
		response.getWriter().append(json.toJSONString(rslmap));
		System.out.println("认证失败");
		return false;
	}
}
