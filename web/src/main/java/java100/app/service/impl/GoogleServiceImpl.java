package java100.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java100.app.service.GoogleService;

@Service
public class GoogleServiceImpl implements GoogleService {

    @Override
    public <T> T me(String accessToken, Class<T> type) {
        
        RestTemplate restTemplate = new RestTemplate();
        
        try {
            return restTemplate.getForObject(
                    /*"https://graph.fackbook.com/v2.12/me?access_token={v1}&fields={v2}",*/
                    "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token={v1}",
                    type, accessToken);
        } catch (Exception e) {
            throw new RuntimeException("Google OAuth2 실행 오류", e);
        }
    }

}
