package mx.edu.utez.SCA.configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.AlumnoRepository;
import mx.edu.utez.SCA.repository.DocenteRepository;
import mx.edu.utez.SCA.repository.UsuarioRepository;

@Component
public class JwtTokenUtil {
	private static final long serialVersionUID = 1L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private DocenteRepository docenteRepository;
	@Value("${jwt.secret}")
	private String secret;

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean ignoreTokenExpiration(String token) {
		return false;
	}

	public String rol1;

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		UsuarioDocument roles = usuarioRepository.findByUsuario(userDetails.getUsername());
		roles.getRol().forEach((rol) -> {
			System.out.println(rol.getRol());
			rol1 = rol.getRol().toString();

		});
		if (rol1.equals("ROLE_ADMIN")) {
			claims.put("perfil",docenteRepository.findByUsuario(usuarioRepository.findByUsuario(userDetails.getUsername())));
		}else if(rol1.equals("ROLE_ALUMNO")){
			claims.put("perfil",
					alumnoRepository.findByUsuario(usuarioRepository.findByUsuario(userDetails.getUsername())));
		}
		System.out.println("USAHDID" + rol1);
		
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
