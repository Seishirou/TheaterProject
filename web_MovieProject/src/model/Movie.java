package model;
/**
 * 영화 정보를 담는 클래스
 */
public class Movie {
	private String movieCd = ""; 
	private String movieNm = ""; 
	private String movieNmEn = "";
	private String prdtYear = ""; 
	private String openDt = ""; 
	private String typeNm = ""; 
	private String prdtStatNm = "";
	private String nationAlt = ""; 
	private String genreAlt = "";
	private String repNationNm = "";
	private String repGenreNm = "";
	private String director = "";
	private int movieRuntime;
	private String thtrNm = "";
	private int thtrCnt;
	private String movieImg = "";

	public Movie() {}
	public Movie(String movieCd, String movieNm, String movieNmEn, String prdtYear, String openDt, String typeNm,
			String prdtStatNm, String nationAlt, String genreAlt, String repNationNm, String repGenreNm,
			String director) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.movieNmEn = movieNmEn;
		this.prdtYear = prdtYear;
		this.openDt = openDt;
		this.typeNm = typeNm;
		this.prdtStatNm = prdtStatNm;
		this.nationAlt = nationAlt;
		this.genreAlt = genreAlt;
		this.repNationNm = repNationNm;
		this.repGenreNm = repGenreNm;
		this.director = director;
	}
	public Movie(String movieCd, String movieNm, String movieNmEn, String prdtYear, String openDt, String typeNm,
			String prdtStatNm, String nationAlt, String genreAlt, String repNationNm, String repGenreNm,
			String director, int movieRuntime, String thtrNm, int thtrCnt, String movieImg) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.movieNmEn = movieNmEn;
		this.prdtYear = prdtYear;
		this.openDt = openDt;
		this.typeNm = typeNm;
		this.prdtStatNm = prdtStatNm;
		this.nationAlt = nationAlt;
		this.genreAlt = genreAlt;
		this.repNationNm = repNationNm;
		this.repGenreNm = repGenreNm;
		this.director = director;
		this.movieRuntime = movieRuntime;
		this.thtrNm = thtrNm;
		this.thtrCnt = thtrCnt;
		this.movieImg = movieImg;
	}
	
	public int getThtrCnt() {
		return thtrCnt;
	}

	public void setThtrCnt(int thtrCnt) {
		this.thtrCnt = thtrCnt;
	}

	public String getThtrNm() {
		return thtrNm;
	}

	public void setThtrNm(String thtrNm) {
		this.thtrNm = thtrNm;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getMovieNmEn() {
		return movieNmEn;
	}

	public void setMovieNmEn(String movieNmEn) {
		this.movieNmEn = movieNmEn;
	}

	public String getPrdtYear() {
		return prdtYear;
	}

	public void setPrdtYear(String prdtYear) {
		this.prdtYear = prdtYear;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getTypeNm() {
		return typeNm;
	}

	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}

	public String getPrdtStatNm() {
		return prdtStatNm;
	}

	public void setPrdtStatNm(String prdtStatNm) {
		this.prdtStatNm = prdtStatNm;
	}

	public String getNationAlt() {
		return nationAlt;
	}

	public void setNationAlt(String nationAlt) {
		this.nationAlt = nationAlt;
	}

	public String getGenreAlt() {
		return genreAlt;
	}

	public void setGenreAlt(String genreAlt) {
		this.genreAlt = genreAlt;
	}

	public String getRepNationNm() {
		return repNationNm;
	}

	public void setRepNationNm(String repNationNm) {
		this.repNationNm = repNationNm;
	}

	public String getRepGenreNm() {
		return repGenreNm;
	}

	public void setRepGenreNm(String repGenreNm) {
		this.repGenreNm = repGenreNm;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getMovieRuntime() {
		return movieRuntime;
	}

	public void setMovieRuntime(int movieRuntime) {
		this.movieRuntime = movieRuntime;
	}
	
	public String getmovieImg() {
		return movieImg;
	}
	
	public void setmovieImg(String movieImg) {
		this.movieImg = movieImg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [movieCd=");
		builder.append(movieCd);
		builder.append(", movieNm=");
		builder.append(movieNm);
		builder.append(", movieNmEn=");
		builder.append(movieNmEn);
		builder.append(", prdtYear=");
		builder.append(prdtYear);
		builder.append(", openDt=");
		builder.append(openDt);
		builder.append(", typeNm=");
		builder.append(typeNm);
		builder.append(", prdtStatNm=");
		builder.append(prdtStatNm);
		builder.append(", nationAlt=");
		builder.append(nationAlt);
		builder.append(", genreAlt=");
		builder.append(genreAlt);
		builder.append(", repNationNm=");
		builder.append(repNationNm);
		builder.append(", repGenreNm=");
		builder.append(repGenreNm);
		builder.append(", director=");
		builder.append(director);
		builder.append(", movieRuntime=");
		builder.append(movieRuntime);
		builder.append(", thtrNm=");
		builder.append(thtrNm);
		builder.append(", thtrCnt=");
		builder.append(thtrCnt);
		builder.append("]");
		return builder.toString();
	}
} // end of class
