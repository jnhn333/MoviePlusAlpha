package Crawling.vo;

public class MovieScoreVO {
	int movieId;
	double scoreTotal;
	double scoreMale;
	double scoreFemale;
	double score_10;
	double score_20;
	double score_30;
	double score_40;
	public MovieScoreVO(int movieId, double scoreTotal, double scoreMale, double scoreFemale, double score_10,
			double score_20, double score_30, double score_40) {
		this.movieId = movieId;
		this.scoreTotal = scoreTotal;
		this.scoreMale = scoreMale;
		this.scoreFemale = scoreFemale;
		this.score_10 = score_10;
		this.score_20 = score_20;
		this.score_30 = score_30;
		this.score_40 = score_40;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public double getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(double scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public double getScoreMale() {
		return scoreMale;
	}
	public void setScoreMale(double scoreMale) {
		this.scoreMale = scoreMale;
	}
	public double getScoreFemale() {
		return scoreFemale;
	}
	public void setScoreFemale(double scoreFemale) {
		this.scoreFemale = scoreFemale;
	}
	public double getScore_10() {
		return score_10;
	}
	public void setScore_10(double score_10) {
		this.score_10 = score_10;
	}
	public double getScore_20() {
		return score_20;
	}
	public void setScore_20(double score_20) {
		this.score_20 = score_20;
	}
	public double getScore_30() {
		return score_30;
	}
	public void setScore_30(double score_30) {
		this.score_30 = score_30;
	}
	public double getScore_40() {
		return score_40;
	}
	public void setScore_40(double score_40) {
		this.score_40 = score_40;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieId;
		long temp;
		temp = Double.doubleToLongBits(scoreFemale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(scoreMale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(scoreTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score_10);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score_20);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score_30);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score_40);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieScoreVO other = (MovieScoreVO) obj;
		if (movieId != other.movieId)
			return false;
		if (Double.doubleToLongBits(scoreFemale) != Double.doubleToLongBits(other.scoreFemale))
			return false;
		if (Double.doubleToLongBits(scoreMale) != Double.doubleToLongBits(other.scoreMale))
			return false;
		if (Double.doubleToLongBits(scoreTotal) != Double.doubleToLongBits(other.scoreTotal))
			return false;
		if (Double.doubleToLongBits(score_10) != Double.doubleToLongBits(other.score_10))
			return false;
		if (Double.doubleToLongBits(score_20) != Double.doubleToLongBits(other.score_20))
			return false;
		if (Double.doubleToLongBits(score_30) != Double.doubleToLongBits(other.score_30))
			return false;
		if (Double.doubleToLongBits(score_40) != Double.doubleToLongBits(other.score_40))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieScoreVO [movieId=" + movieId + ", scoreTotal=" + scoreTotal + ", scoreMale=" + scoreMale
				+ ", scoreFemale=" + scoreFemale + ", score_10=" + score_10 + ", score_20=" + score_20 + ", score_30="
				+ score_30 + ", score_40=" + score_40 + "]";
	}
}
