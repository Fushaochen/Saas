package org.fsc.saas.project.service.impl;

import lombok.SneakyThrows;
import org.fsc.saas.project.service.UrlTitleService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName:UrlTitleServiceImpl
 * Package:com.nageoffer.shortlink.project.service.impl
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/11/6 - 19:03
 * @Version: v1.0
 */
@Service
public class UrlTitleServiceImpl implements UrlTitleService {
    @SneakyThrows
    @Override
    public String getTitleByUrl(String url) {
        URL tagetUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) tagetUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Document document = Jsoup.connect(url).get();
            return document.title();
        }
        return "Erro while fetching title";
    }
}
