package comman_programs;

import java.io.InputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class BeanClass implements Serializable
{
	                     private long accountNo;
	                     private double accountBalance;
	                     private String name;
	                     private String password;
	                     private String fatherName;
	                     private long aadhaarNo;
	                     private String dateOfBirth;
	                     private long contactNo;
	                     private String emailId;
	                     private String gender;
	                     private String occupation;
	                     private String accountType;
	                     private String nominee;
	                     private String address;
	                     private String openingDate;
	                     private InputStream photo;
	                     private String dbPhoto;
	                     private String description;
	                     private double transactionAmount;
	                     private String time;
	                     private String transactionDate;
	                     private Long ATMcardNo;
	                     private String expiryDate;
	                     private int cvv;
	                     private String generatedDate;

	     public BeanClass()
	     {

	     }

	     public long getAccountNo()
	     {
		       return accountNo;
	     }

	     public void setAccountNo(long accountNo)
	     {
		       this.accountNo = accountNo;
	     }

	     public double getAccountBalance()
	     {
		       return accountBalance;
	     }

	     public void setAccountBalance(double accountBalance)
	     {
		       this.accountBalance = accountBalance;
	     }

	     public String getName()
	     {
		       return name;
	     }

	     public void setName(String name)
	     {
		       this.name = name;
	     }

	     public String getPassword()
	     {
		       return password;
	     }

	     public void setPassword(String password)
	     {
		       this.password = password;
	     }

	     public String getFatherName()
	     {
		       return fatherName;
	     }

	     public void setFatherName(String fatherName)
	     {
		       this.fatherName = fatherName;
	     }

	     public long getAadhaarNo()
	     {
		        return aadhaarNo;
	     }

	     public void setAadhaarNo(long aadhaarNo)
	     {
		        this.aadhaarNo = aadhaarNo;
	     }

	     public String getDateOfBirth()
	     {
		        return dateOfBirth;
	     }

	     public void setDateOfBirth(String dateOfBirth)
	     {
		        this.dateOfBirth = dateOfBirth;
	     }

	     public long getContactNo()
	     {
		        return contactNo;
	     }

	     public void setContactNo(long contactNo)
	     {
		        this.contactNo = contactNo;
	     }

	     public String getEmailId()
	     {
		        return emailId;
	     }

	     public void setEmailId(String emailId)
	     {
		        this.emailId = emailId;
	     }

	     public String getGender()
	     {
		        return gender;
	     }

	     public void setGender(String gender)
	     {
		        this.gender = gender;
	     }

	     public String getOccupation()
	     {
		        return occupation;
	     }

	     public void setOccupation(String occupation)
	     {
		        this.occupation = occupation;
	     }

	     public String getAccountType()
	     {
		        return accountType;
	     }

	     public void setAccountType(String accountType)
	     {
		        this.accountType = accountType;
	     }

	     public String getNominee()
	     {
		        return nominee;
	     }

	     public void setNominee(String nominee)
	     {
		        this.nominee = nominee;
	     }

	     public String getAddress()
	     {
		        return address;
	     }

	     public void setAddress(String address)
	     {
		        this.address = address;
	     }

	     public String getOpeningDate()
	     {
		        return openingDate;
	     }

	     public void setOpeningDate(String openingDate)
	     {
		        this.openingDate = openingDate;
	     }

	     public InputStream getPhoto()
	     {
		        return photo;
	     }

	     public void setPhoto(InputStream photo)
	     {
		        this.photo = photo;
	     }

	     public String getDbPhoto()
	     {
		        return dbPhoto;
	     }

	     public void setDbPhoto(String dbPhoto)
	     {
		        this.dbPhoto = dbPhoto;
	     }

		 public String getDescription()
		 {
			    return description;
		 }

		 public void setDescription(String description)
		 {
			    this.description = description;
		 }

		 public double getTransactionAmount()
		 {
			    return transactionAmount;
		 }

		 public void setTransactionAmount(double transactionAmount)
		 {
			    this.transactionAmount = transactionAmount;
		 }

		 public String getTime()
		 {
			    return time;
		 }

		 public void setTime(String time)
		 {
			    this.time = time;
		 }

		 public String getTransactionDate()
		 {
			    return transactionDate;
		 }

		 public void setTransactionDate(String transactionDate)
		 {
			    this.transactionDate = transactionDate;
		 }

		 public Long getATMcardNo()
		 {
			    return ATMcardNo;
		 }

		 public void setATMcardNo(Long aTMcardNo)
		 {
			    ATMcardNo = aTMcardNo;
		 }

		 public String getExpiryDate()
		 {
			    return expiryDate;
		 }

		 public void setExpiryDate(String expiryDate)
		 {
			    this.expiryDate = expiryDate;
		 }

		 public int getCvv()
		 {
			    return cvv;
		 }

		 public void setCvv(int cvv)
		 {
			    this.cvv = cvv;
		 }

		 public String getGeneratedDate()
		 {
			    return generatedDate;
		 }

		 public void setGeneratedDate(String generatedDate)
		 {
			    this.generatedDate = generatedDate;
		 }
}