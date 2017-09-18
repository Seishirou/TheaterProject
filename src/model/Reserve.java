package model;
/**
 * 예약 정보를 담은 클래스
 */
public class Reserve {
	private int bookCode;
	private String thtrCd = "";
	private String movieCd = "";
	private String watchDate = "";
	private int seatNo;
	private int playSeq;
	private String memberId = "";
	private String thtrNm = "";
	private String movieNm = "";
	private int thtrSeatCnt;
	private String memberNm = "";
	
	public Reserve() {}
	public Reserve(int bookCode, String thtrCd, String movieCd, String watchDate, int seatNo, int playSeq,
			String memberId) {
		super();
		this.bookCode = bookCode;
		this.thtrCd = thtrCd;
		this.movieCd = movieCd;
		this.watchDate = watchDate;
		this.seatNo = seatNo;
		this.playSeq = playSeq;
		this.memberId = memberId;
	}
	public Reserve(int bookCode, String thtrCd, String movieCd, String watchDate, int seatNo, int playSeq,
			String memberId, String thtrNm, String movieNm) {
		super();
		this.bookCode = bookCode;
		this.thtrCd = thtrCd;
		this.movieCd = movieCd;
		this.watchDate = watchDate;
		this.seatNo = seatNo;
		this.playSeq = playSeq;
		this.memberId = memberId;
		this.thtrNm = thtrNm;
		this.movieNm = movieNm;
	}
	
	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public int getThtrSeatCnt() {
		return thtrSeatCnt;
	}

	public void setThtrSeatCnt(int thtrSeatCnt) {
		this.thtrSeatCnt = thtrSeatCnt;
	}

	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
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
	public String getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(String watchDate) {
		this.watchDate = watchDate;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getPlaySeq() {
		return playSeq;
	}
	public void setPlaySeq(int playSeq) {
		this.playSeq = playSeq;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		builder.append("Reserve [bookCode=");
		builder.append(bookCode);
		builder.append(", thtrCd=");
		builder.append(thtrCd);
		builder.append(", movieCd=");
		builder.append(movieCd);
		builder.append(", watchDate=");
		builder.append(watchDate);
		builder.append(", seatNo=");
		builder.append(seatNo);
		builder.append(", playSeq=");
		builder.append(playSeq);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", thtrNm=");
		builder.append(thtrNm);
		builder.append(", movieNm=");
		builder.append(movieNm);
		builder.append(", thtrSeatCnt=");
		builder.append(thtrSeatCnt);
		builder.append(", memberNm=");
		builder.append(memberNm);
		builder.append("]");
		return builder.toString();
	}
} // end of class
