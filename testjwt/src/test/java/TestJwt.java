import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {


    @Test
    public void test01() {

        Map<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60*60);
        String token = JWT.create()
                .withHeader(map) //header
                .withClaim("userId", 10) //payload
                .withClaim("username", "leo")
                .withExpiresAt(instance.getTime()) //指定令牌的过期时间
                .sign(Algorithm.HMAC256("!@#$%^"));//签名

        System.out.println(token);
    }

    @Test
    public void test02(){
        //生成验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@#$%^")).build();

        //验证token,得到解码对象
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTE4MTIwMjMsInVzZXJJZCI6MTAsInVzZXJuYW1lIjoibGVvIn0.ZebnJcbeShVSFOySsLkigwLRwP6N8tfhw4ARYNpaZuE\n");

        //通过解码对象得到负载信息
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("username").asString());

        System.out.println(verify.getClaims().get("userId").asInt());
        System.out.println(verify.getClaims().get("username").asString());

        System.out.println(verify.getExpiresAt());//过期时间
    }



}
