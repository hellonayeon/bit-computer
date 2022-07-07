package movie;

import dto.MovieDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MovieChart {

    private static MovieChart movieChart = new MovieChart();

    private List<MovieDto> list = new ArrayList<>();

    private MovieChart() {

    }

    public static MovieChart getInstance() {
        return movieChart;
    }

    public List<MovieDto> getCGVData() throws IOException {

        Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();

//        <div class="box-contents">
//              <a href="/movies/detail-view/?midx=85852">
//                  <strong class="title">헤어질 결심</strong>
//              </a>

//            <div class="score">
//                <strong class="percent">
//                      예매율
//                      <span>66.2%</span>
//                </strong>


        Elements titles = doc.select("div.box-contents strong.title");
        Elements percents = doc.select("div.box-contents div.score strong.percent span");

        for (int i=0; i<19; i++) {
            Element title = titles.get(i);
            Element percent = percents.get(i);

            System.out.println(title.text());
            System.out.println(percent.text());

            String t = title.text();
            double p = Double.parseDouble( percent.text().replace("%", "") );

            list.add(new MovieDto(t, p));
        }

        return list;
    }

}
