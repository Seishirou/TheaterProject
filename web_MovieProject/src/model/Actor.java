package model;
/**
 * 배우 정보를 담는 클래스
 */
public class Actor {
	private String peopleCd;
	private String peopleNm;
	private String job;

	public Actor() {}
	public Actor(String peopleCd, String peopleNm, String job) {
		super();
		this.peopleCd = peopleCd;
		this.peopleNm = peopleNm;
		this.job = job;
	}

	public String getPeopleCd() {
		return peopleCd;
	}

	public void setPeopleCd(String peopleCd) {
		this.peopleCd = peopleCd;
	}

	public String getPeopleNm() {
		return peopleNm;
	}

	public void setPeopleNm(String peopleNm) {
		this.peopleNm = peopleNm;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor [peopleCd=");
		builder.append(peopleCd);
		builder.append(", peopleNm=");
		builder.append(peopleNm);
		builder.append(", job=");
		builder.append(job);
		builder.append("]");
		return builder.toString();
	}
}// end of class
