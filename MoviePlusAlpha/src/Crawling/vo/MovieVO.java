package Crawling.vo;

public class MovieVO {
	int id;
	String title;
	String subTitle;
	String genre;
	String nation;
	String director;
	int playTime;
	String pubDate;
	String ageGrade;
	int evaluatorCount;
	MovieScoreVO msvo;
	
	public MovieVO() {
		super();
	}
	public MovieVO(int id, String title, String subTitle, String genre, String nation, String director, String playTime, String pubDate,
			String ageGrade, int evaluatorCount, MovieScoreVO msvo) {
		setId(id);
		setTitle(title);
		setSubTitle(subTitle);
		setGenre(genre);
		setNation(nation);
		setDirector(director);
		setPlayTime(playTime);
		setPubDate(pubDate);
		setAgeGrade(ageGrade);
		setEvaluatorCount(evaluatorCount);
		setMsvo(msvo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		int result = Integer.parseInt(playTime.replace('분', ' ').trim());
		this.playTime = result;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getAgeGrade() {
		return ageGrade;
	}
	public void setAgeGrade(String ageGrade) {
		this.ageGrade = ageGrade;
	}
	public int getEvaluatorCount() {
		return evaluatorCount;
	}
	public void setEvaluatorCount(int evaluatorCount) {
		this.evaluatorCount = evaluatorCount;
	}
	public MovieScoreVO getMsvo() {
		return msvo;
	}
	public void setMsvo(MovieScoreVO msvo) {
		this.msvo = msvo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageGrade == null) ? 0 : ageGrade.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + evaluatorCount;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((msvo == null) ? 0 : msvo.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + playTime;
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + ((subTitle == null) ? 0 : subTitle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		MovieVO other = (MovieVO) obj;
		if (ageGrade == null) {
			if (other.ageGrade != null)
				return false;
		} else if (!ageGrade.equals(other.ageGrade))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (evaluatorCount != other.evaluatorCount)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (msvo == null) {
			if (other.msvo != null)
				return false;
		} else if (!msvo.equals(other.msvo))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (playTime != other.playTime)
			return false;
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		if (subTitle == null) {
			if (other.subTitle != null)
				return false;
		} else if (!subTitle.equals(other.subTitle))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieVO [id=" + id + ", title=" + title + ", subTitle=" + subTitle + ", genre=" + genre + ", nation="
				+ nation + ", director=" + director + ", playTime=" + playTime + ", pubDate=" + pubDate + ", ageGrade="
				+ ageGrade + ", evaluatorCount=" + evaluatorCount + ", msvo=" + msvo + "]";
	}

}

