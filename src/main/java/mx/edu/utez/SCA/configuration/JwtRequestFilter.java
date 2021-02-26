package mx.edu.utez.SCA.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import mx.edu.utez.SCA.service.UsuarioService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,  FilterChain chain) throws ServletException, IOException{
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;

		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			
			try {
				jwtToken = requestTokenHeader.substring(7);
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
				System.out.println("USERNAME: "+ username);
				System.out.println(username);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expires");
			}
		}else {
			logger.warn("JWT Token doesn't begin with Bearer String");

		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.usuarioService.loadUserByUsername(username);
				
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
		}
		System.out.println("aaaaaa");
		chain.doFilter(request, response);
		
	}
}
