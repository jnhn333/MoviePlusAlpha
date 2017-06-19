package Crawling.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Crawling.vo.MovieScoreVO;
import Crawling.vo.MovieVO;
public class ParsingTest {

	public static void main(String[] args) throws IOException {
		int id = 1;
		Document doc = Jsoup.connect("http://movie.naver.com/movie/bi/mi/point.nhn?code="+id).get();
		Elements elements = doc.select("#content > div.article > div.mv_info_area > div.mv_info > strong");
		String title = doc.select("#content > div.article > div.mv_info_area > div.mv_info > h3 > a").text();
		String subTitle = elements.attr("title");
		System.out.println("subTitle :" + subTitle);

		Elements elements2 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(1) > a:nth-child(1)");

		String genre = elements2.text();

		Elements elements3 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(2)");

		String nation = elements3.text();

		Elements elements4 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(3)");

		String playTime = elements4.text();

		Elements elements5 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(4)");
		String pubDate = parseOpenDate(elements5.text());

		Elements elements6 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(8) > p > a:nth-child(1)");

		String ageGrade = elements6.text();

		Elements elements7 = doc.select(
				"#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(4) > p > a");

		String director = elements7.text();


		Elements elements8 = doc.select("#netizen_point_tab_inner > div");
		Elements elements9 = doc.select("#netizen_point_tab_inner > span > em");
		String scoreTotal = elements8.text();
		String evaluatorCount = elements9.text();

		Elements elements10 = doc.select("#netizen_group_graph > div.grp_sty2 > ul > li.ma > span.grp_score > em");

		Elements elements11 = doc.select("#netizen_group_graph > div.grp_sty2 > ul > li.fa > span.grp_score > em");

		String scoreMale = elements10.text();
		String scoreFemale = elements11.text();

		Elements elements14 = doc.select("#netizen_group_graph > div.grp_sty3 > ul >li em");
		if(elements14.first() == null)
			return;//함수 변경 후 return null로 변경
		String score_10=elements14.first().text();
		String score_20=elements14.eq(1).text();
		String score_30=elements14.eq(2).text();
		String score_40=elements14.last().text();
		MovieScoreVO msvo = new MovieScoreVO(id, Double.parseDouble(scoreTotal), 
				Double.parseDouble(scoreMale), Double.parseDouble(scoreFemale), 
				Double.parseDouble(score_10), Double.parseDouble(score_20), 
				Double.parseDouble(score_30), Double.parseDouble(score_40));
		MovieVO mvo = new MovieVO(id, title, subTitle, genre, nation, director, playTime, pubDate, ageGrade, Integer.parseInt(evaluatorCount), msvo);
		System.out.println(mvo);
	}
	public static String parseOpenDate(String str){
		String result = str;
		for(int i = 0 ; i < str.length() ; i++)
			if(str.charAt(i) == ',')
				result = str.substring(i + 2, i + 12);
		return result;
	}
}