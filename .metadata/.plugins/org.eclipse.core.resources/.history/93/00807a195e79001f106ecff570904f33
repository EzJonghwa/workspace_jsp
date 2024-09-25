package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//Filter 웹 애플리케이션에서 요청 , 응답 객체를 가로채고 특정 작업을 수행할 수 있게 해주는 서블릿 기술
public class CharEncoding implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("응답 전");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request,response);
		System.out.println("응답후");
	}

	
	

}
