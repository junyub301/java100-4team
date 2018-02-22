package java100.app.service;

public interface GoogleService {
    <T> T me(String accessToken, Class<T> type);
}