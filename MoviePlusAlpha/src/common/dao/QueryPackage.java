package common.dao;

public final class QueryPackage {
	public final static String INSERT_MOVIE="INSERT INTO MOVIETEST (ID, Title, Genre, Nation, Director, PlayTime, Subtitle, PubDate, AgeGrade, Evaluator) VALUES(?, ?, ?, ?, ?, ?, ?, str_to_date(?,'%Y.%m.%d'), ?, ?)";
	public final static String INSERT_MOVIE_SCORE="INSERT INTO MOVIESCORETEST (MovieID, ScoreTotal, ScoreMale, ScoreFemale, Score_10, Score_20, Score_30, Score_40) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	//morpheme load to database query
	public final static String INSERT_MORPHEME="INSERT INTO SubtitleInformation (SubKey, SubValue) VALUES (?, ?)";
	public final static String INSERT_WORD_COUNT="INSERT INTO MovieSubTitle (MovieID, SubKey, WordCount) VALUES (?, ?, ?)";
}
