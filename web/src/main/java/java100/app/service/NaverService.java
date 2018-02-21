package java100.app.service;

public interface NaverService {
    <T> T me(String accessToken, Class<T> type);
}