package model;
/**
 * 극장별 상영 스케줄 정보를 담는 클래스
 */
public class ThtrPlaySeq {
	private String thtrCd = "";
	private String movieCd = "";
	private int playSeq;
	private String playStrtTm = "";
	private String thtrNm = "";
	private String movieNm = "";
	
	public ThtrPlaySeq() {}
	public ThtrPlaySeq(String thtrCd, String movieCd, int playSeq, String playStrtTm) {
		super();
		this.thtrCd = thtrCd;
		this.movieCd = movieCd;
		this.playSeq = playSeq;
		this.playStrtTm = playStrtTm;
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

	public int getPlaySeq() {
		return playSeq;
	}

	public void setPlaySeq(int playSeq) {
		this.playSeq = playSeq;
	}

	public String getPlayStrtTm() {
		return playStrtTm;
	}

	public void setPlayStrtTm(String playStrtTm) {
		this.playStrtTm = playStrtTm;
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
		builder.append("ThtrPlaySeq [thtrCd=");
		builder.append(thtrCd);
		builder.append(", movieCd=");
		builder.append(movieCd);
		builder.append(", playSeq=");
		builder.append(playSeq);
		builder.append(", playStrtTm=");
		builder.append(playStrtTm);
		builder.append(", thtrNm=");
		builder.append(thtrNm);
		builder.append(", movieNm=");
		builder.append(movieNm);
		builder.append("]");
		return builder.toString();
	}
} // end of class
