package Crawling.utility;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Crawling.vo.MovieScoreVO;
import Crawling.vo.MovieVO;

public class JSoupParser {
	public MovieVO executeParse(int queryId) throws IOException {
		Document doc = Jsoup.connect("http://movie.naver.com/movie/bi/mi/point.nhn?code="+queryId).get();
		Elements elements = doc.select("#content > div.article > div.mv_info_area > div.mv_info > strong");
		String title = doc.select("#content > div.article > div.mv_info_area > div.mv_info > h3 > a").text();
		String subTitle = elements.attr("title");

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
		System.out.println(elements5.text());
		if(elements5.text().trim().equals("")){
			
			System.out.println(queryId +" " + title + " parse failed.(not published)");
			return null;
		}
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
		if(elements14.first() == null){
			System.out.println(queryId +" " + title + " parse failed.(evaluate result not found)");
			return null;
			}
		String score_10=elements14.first().text();
		String score_20=elements14.eq(1).text();
		String score_30=elements14.eq(2).text();
		String score_40=elements14.last().text();
		MovieScoreVO msvo = new MovieScoreVO(queryId, Double.parseDouble(scoreTotal), 
				Double.parseDouble(scoreMale), Double.parseDouble(scoreFemale), 
				Double.parseDouble(score_10), Double.parseDouble(score_20), 
				Double.parseDouble(score_30), Double.parseDouble(score_40));
		MovieVO mvo = new MovieVO(queryId, title, subTitle, genre, nation, director, playTime, pubDate, ageGrade, Integer.parseInt(evaluatorCount.replaceAll(",","")), msvo);
		System.out.println(queryId +" " + title + " parse success.");
		return mvo;
	}
	String parseOpenDate(String str){
		//,가 없으면 재개봉정보가 없다.
		String result = str.substring(0, 10);
		for(int i = 0 ; i < str.length() ; i++)
			//,가 있으면 재개봉정보가 있다.
			if(str.charAt(i) == ',')
				result = str.substring(i + 2, i + 12);
		return result;
	}
}
