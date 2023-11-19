package edu.hw6;

import edu.hw1.Main;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public final class Task5 {
    private static final Pattern TITLE_PATTERN = Pattern.compile("\"title\":\"([^\"]*)\"");
    private static final String TOP_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/";

    private Task5() {
    }

    public static long[] hackerNewsTopStories() {
        try (var client = newHttpClient()) {
            final URI topURI = new URI(TOP_URL);
            var request = HttpRequest.newBuilder()
                .uri(topURI)
                .GET()
                .build();
            var response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );
            return parseTopStories(response.body());
        } catch (Exception e) {
            return new long[] {};
        }
    }

    private static long[] parseTopStories(String data) {
        var trimmed = data.substring(1, data.length() - 1);
        var values = trimmed.split(",");
        return Arrays.stream(values)
            .mapToLong(Long::parseLong)
            .toArray();
    }

    public static String news(long id) {
        try (var client = newHttpClient()) {
            var itemURI = new URI(ITEM_URL + id + ".json");
            var request = HttpRequest.newBuilder()
                .uri(itemURI)
                .GET()
                .build();
            var response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );
            return findNewsTitle(response.body());
        } catch (Exception ignored) {
            return "";
        }
    }

    private static String findNewsTitle(String newsData) {
        Matcher matcher = TITLE_PATTERN.matcher(newsData);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
