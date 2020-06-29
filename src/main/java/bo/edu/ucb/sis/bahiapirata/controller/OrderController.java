package bo.edu.ucb.sis.bahiapirata.controller;

import bo.edu.ucb.sis.bahiapirata.bl.OrderBl;
import bo.edu.ucb.sis.bahiapirata.model.CredentialModel;
import bo.edu.ucb.sis.bahiapirata.model.OrderModel;
import bo.edu.ucb.sis.bahiapirata.model.ProductOrderModel;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "*")
public class OrderController {
    private OrderBl orderBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public OrderController(OrderBl orderBl) {
        this.orderBl = orderBl;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> findAllActives(@RequestHeader("Authorization") String authorization) { // bearer
        System.out.println("obteniando ordenes");
        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);

        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.findAllActives(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> findUserById(@RequestHeader("Authorization") String authorization, @PathVariable("id") int orderId) {
        String tokenJwT = authorization.substring(7);
        System.out.println("encontrar orden por id");
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();


        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.findOrderById(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "{orderId}/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductOrderModel>> findProductsByOrderId(@RequestHeader("Authorization") String authorization, @PathVariable("orderId") int orderId) {
        String tokenJwT = authorization.substring(7);
        System.out.println("encontrar productos de una orden por id");
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();


        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.findProductsByOrderId(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "{orderId}/product", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductOrderModel> updateProductOrderById(@RequestHeader("Authorization") String authorization, @PathVariable("orderId") int orderId,
                                                                         @RequestBody ProductOrderModel productOrderModel) {
        String tokenJwT = authorization.substring(7);
        System.out.println("encontrar orden por id");
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        int userId = Integer.parseInt(decodedJWT.getSubject());
        System.out.println("Lo esta editando el usuario " + userId);

        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);
        System.out.println("updating product order in Controller");
        System.out.println(productOrderModel.getQttyReceived());
        ProductOrderModel response = this.orderBl.updateProductOrder(
                productOrderModel.getProductOrderId(),
                productOrderModel.getQttyCommit(),
                productOrderModel.getQttyReceived(),
                userId);
        //Map <String, Object> response = new HashMap();

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);

    }

    @RequestMapping(value = "{orderId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> updateOrder(@RequestHeader("Authorization") String authorization, @PathVariable("orderId") int orderId,
                                                   @RequestBody OrderModel orderModel) {
        String tokenJwT = authorization.substring(7);
        System.out.println("encontrar orden por id");
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        int userId = Integer.parseInt(decodedJWT.getSubject());


        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.updateOrder(orderModel.getOrderStatus(), orderId, userId), HttpStatus.OK);
    }

    @RequestMapping(value = "{orderId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> deleteOrder(@RequestHeader("Authorization") String authorization, @PathVariable("orderId") int orderId) {
        String tokenJwT = authorization.substring(7);
        System.out.println("borrar orden por id");
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        int userId = Integer.parseInt(decodedJWT.getSubject());


        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication
        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.deleteOrder(orderId, userId), HttpStatus.OK);
    }
}
