package model;
/**
 * 상영중인 영화 정보를 담는 클래스
 */
public class ThtrMovie {
	private String thtrCd = "";
	private String movieCd = "";
	private String playStrtDt = "";
	private String playEndDt= "";
	private String thtrNm = "";
	private String movieNm = "";
	
	public ThtrMovie() {}
	public ThtrMovie(String thtrCd, String movieCd, String playStrtDt, String playEndDt, String thtrNm,
			String movieNm) {
		super();
		this.thtrCd = thtrCd;
		this.movieCd = movieCd;
		this.playStrtDt = playStrtDt;
		this.playEndDt = playEndDt;
		this.thtrNm = thtrNm;
		this.movieNm = movieNm;
	}

	public String getThtrCd() {
		return thtrCd;
	}

	public void setThtrCd(String thtrCd) {
		this.thtrCd = thtrCd;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getPlayStrtDt() {
		return playStrtDt;
	}

	public void setPlayStrtDt(String playStrtDt) {
		this.playStrtDt = playStrtDt;
	}

	public String getPlayEndDt() {
		return playEndDt;
	}

	public void setPlayEndDt(String playEndDt) {
		this.playEndDt = playEndDt;
	}

	public String getThtrNm() {
		return thtrNm;
	}

	public void setThtrNm(String thtrNm) {
		this.thtrNm = thtrNm;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ThtrMovie [thtrCd=");
		builder.append(thtrCd);
		builder.append(", movieCd=");
		builder.append(movieCd);
		builder.append(", playStrtDt=");
		builder.append(playStrtDt);
		builder.append(", playEndDt=");
		builder.append(playEndDt);
		builder.append(", thtrNm=");
		builder.append(thtrNm);
		builder.append(", movieNm=");
		builder.append(movieNm);
		builder.append("]");
		return builder.toString();
	}
} // end of class
