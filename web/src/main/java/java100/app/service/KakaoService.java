package java100.app.service;

public interface KakaoService {

    <T> T me(String accessToken, Class<T> clazz);
    
}
