import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebCrawler {

    private static String crawledURL = "http://ebusiness.free.bg/";
    private static List<URL> visitedURLS = new ArrayList<URL>();

    private static String getURLContent(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }

        String contentInURL = sb.toString();
        in.close();

        return contentInURL;
    }

    private static ArrayList<String> getAllLinks(String url) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }

        return resultList;
    }

    private static void crawl(URL url, String needle) throws IOException {

        visitedURLS.add(url);

        String contentInURL = getURLContent(url);

        if (contentInURL.contains(needle)) {
            System.out.println("Found Needle At: " + url.toString());
        }

        ArrayList<String> allTheLinks = getAllLinks(contentInURL);

        for (String currentLink : allTheLinks) {
            if (currentLink.contains("http")) { // So we don't go out of the website's scope...!
                continue;
            }

            if (currentLink.contains("/")) {
                currentLink = currentLink.substring(currentLink.lastIndexOf("/") + 1);
            }

            URL finalURL = new URL(crawledURL + currentLink);

            if (!(visitedURLS.contains(finalURL))) {
                crawl(finalURL, needle);
            }
        }
    }

    public static void main(String[] arguments) throws MalformedURLException, IOException {

        URL crawlURL = new URL(crawledURL);
        String needle = "�����������";
        crawl(crawlURL, needle);

    }

}
