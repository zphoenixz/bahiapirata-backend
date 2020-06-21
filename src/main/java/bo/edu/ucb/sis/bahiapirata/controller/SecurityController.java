package bo.edu.ucb.sis.bahiapirata.controller;

import bo.edu.ucb.sis.bahiapirata.bl.SecurityBl;
import bo.edu.ucb.sis.bahiapirata.model.CredentialModel;
import bo.edu.ucb.sis.bahiapirata.model.TokenRefreshModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/security")
@CrossOrigin(origins = "*")
public class SecurityController {

    private SecurityBl securityBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public SecurityController(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody CredentialModel credentialsModel) {

        Map<String, String> tokens = securityBl.authenticate(credentialsModel.getUsername(), credentialsModel.getPassword());

        if( tokens != null ) {
            Map <String, Object> response = new HashMap();
            response.put("message", "Authentication OK");
            response.put("authentication", tokens.get("authentication"));
            response.put("refresh", tokens.get("refresh"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map <String, Object> response = new HashMap();
            response.put("message", "User or password invalid");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "refresh", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody TokenRefreshModel tokenRefreshModel) {
        Map <String,String> tokens = securityBl.refresh(tokenRefreshModel);
        Map <String, Object> response = new HashMap();
        response.put("message", "Authentication OK");
        response.put("authentication", tokens.get("authentication"));
        response.put("refresh", tokens.get("refresh"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}