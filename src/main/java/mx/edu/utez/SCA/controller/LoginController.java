package mx.edu.utez.SCA.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mx.edu.utez.SCA.configuration.JwtResponse;
import mx.edu.utez.SCA.configuration.JwtTokenUtil;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.service.UsuarioService;
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class LoginController {
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UsuarioService usuarioService;
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UsuarioDocument authenticationRequest)throws Exception{
	
		System.out.println(authenticationRequest.getUsuario()+authenticationRequest.getPassword());
		
			authenticate(authenticationRequest.getUsuario(),authenticationRequest.getPassword());
			final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsuario());	
			final String token = jwtTokenUtil.generateToken(userDetails);
			System.out.println(token+" user");
			return ResponseEntity.ok(new JwtResponse(token));
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioDocument user, @RequestParam String id){
		System.out.println(id);
		return ResponseEntity.ok(usuarioService.save(user, id));
	}
	private void authenticate (String user, String contra) throws Exception{
		System.out.println(user+  "  "+contra);
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(user, contra));
		}catch (DisabledException e) {
			System.out.println(e.getMessage());
			throw new Exception ("User_DISABLED", e);
		}catch(BadCredentialsException e) {
			System.out.println(e.getMessage());
			throw new Exception ("User_DISABLED", e);
		}
		
		
	}
}
