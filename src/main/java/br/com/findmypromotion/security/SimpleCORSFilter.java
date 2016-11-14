package br.com.findmypromotion.security;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Enabling Cross Origin Requests for a RESTful Web Service
 * 
 * <br>See more:<br>
 *  <a href="http://stackoverflow.com/questions/10636611/how-does-access-control-allow-origin-header-work">
 *  	How does access control allow origin header work
 *  </a><br>
 * 	<a href="https://spring.io/guides/gs/rest-service-cors/">
 * 		Enabling Cross Origin Requests for a RESTful Web Service
 *  </a> 
 * @author Dalton
 *
 */

@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}