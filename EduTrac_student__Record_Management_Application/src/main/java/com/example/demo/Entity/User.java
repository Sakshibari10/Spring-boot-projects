package com.example.demo.Entity;

import java.security.cert.TrustAnchor;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Name")
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int user_Id;
	public String user_Name;
	public String first_Name;
	public String last_Name;
	@Column(name = "user_email")
	public String email;
	public int phone_No;
    public String passWord;
    final public String role = "Student";
    public String eduCation;
    public int passout_Year;
    public String statuS;
    public String parent_No;
    public int aGe;
    public String gender;
    public String dOb;
    public String adhar_No;
    public int vAn;
    @Column(name ="OTP")
    private String sendOtp;

@Column(name = "otp_created_at")
private Instant otpCreatedAt;

@Column(nullable = false)
private Boolean otpUsed = false; // default value

@OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true )
private List<Enrollment> enrollments = new ArrayList<>();
	
	public Instant getOtpCreatedAt() {
	return otpCreatedAt;
}
public void setOtpCreatedAt(Instant otpCreatedAt) {
	this.otpCreatedAt = otpCreatedAt;
}
public boolean isOtpUsed() {
	return otpUsed;
}
public void setOtpUsed(boolean otpUsed) {
	this.otpUsed = otpUsed;
}
	public String getSendOtp() {
		return sendOtp;
	}
	public void setSendOtp(String otp) {
		this.sendOtp = otp;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail() {
	    return email;
	}
	public void setEmail(String Email) {
	    this.email = Email;
	}
	public int getPhone_No() {
		return phone_No;
	}
	public void setPhone_No(int phone_No) {
		this.phone_No = phone_No;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEduCation() {
		return eduCation;
	}
	public void setEduCation(String eduCation) {
		this.eduCation = eduCation;
	}
	public int getPassout_Year() {
		return passout_Year;
	}
	public void setPassout_Year(int passout_Year) {
		this.passout_Year = passout_Year;
	}
	public String getStatuS() {
		return statuS;
	}
	public void setStatuS(String statuS) {
		this.statuS = statuS;
	}
	public String getParent_No() {
		return parent_No;
	}
	public void setParent_No(String parent_No) {
		this.parent_No = parent_No;
	}
	public int getaGe() {
		return aGe;
	}
	public void setaGe(int aGe) {
		this.aGe = aGe;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getdOb() {
		return dOb;
	}
	public void setdOb(String dOb) {
		this.dOb = dOb;
	}
	public String getAdhar_No() {
		return adhar_No;
	}
	public void setAdhar_No(String adhar_No) {
		this.adhar_No = adhar_No;
	}
	public int getvAn() {
		return vAn;
	}
	public void setvAn(int vAn) {
		this.vAn = vAn;
	}
	public String getRole() {
		return role;
	}
	
	
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Name=" + user_Name + ", first_Name=" + first_Name + ", last_Name="
				+ last_Name + ", email=" + email + ", phone_No=" + phone_No + ", passWord=" + passWord + ", role="
				+ role + ", eduCation=" + eduCation + ", passout_Year=" + passout_Year + ", statuS=" + statuS
				+ ", parent_No=" + parent_No + ", aGe=" + aGe + ", gender=" + gender + ", dOb=" + dOb + ", adhar_No="
				+ adhar_No + ", vAn=" + vAn + ", sendOtp=" + sendOtp + ", otpCreatedAt=" + otpCreatedAt + ", otpUsed="
				+ otpUsed + "]";
	}
	public User(int user_Id, String user_Name, String first_Name, String last_Name, String email, int phone_No,
			String passWord, String eduCation, int passout_Year, String statuS, String parent_No, int aGe,
			String gender, String dOb, String adhar_No, int vAn, String sendOtp) {
		super();
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.phone_No = phone_No;
		this.passWord = passWord;
		this.eduCation = eduCation;
		this.passout_Year = passout_Year;
		this.statuS = statuS;
		this.parent_No = parent_No;
		this.aGe = aGe;
		this.gender = gender;
		this.dOb = dOb;
		this.adhar_No = adhar_No;
		this.vAn = vAn;
		this.sendOtp = sendOtp;
	}
	public User(int user_Id, String user_Name, String first_Name, String last_Name, String email, int phone_No,
			String passWord, String eduCation, int passout_Year, String statuS, String parent_No, int aGe,
			String gender, String dOb, String adhar_No, int vAn, String sendOtp, Instant otpCreatedAt, boolean otpUsed) {
		super();
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.phone_No = phone_No;
		this.passWord = passWord;
		this.eduCation = eduCation;
		this.passout_Year = passout_Year;
		this.statuS = statuS;
		this.parent_No = parent_No;
		this.aGe = aGe;
		this.gender = gender;
		this.dOb = dOb;
		this.adhar_No = adhar_No;
		this.vAn = vAn;
		this.sendOtp = sendOtp;
		this.otpCreatedAt = otpCreatedAt;
		this.otpUsed = otpUsed;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
	
	
}
