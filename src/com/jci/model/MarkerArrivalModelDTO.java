package com.jci.model;

import javax.persistence.Column;

public class MarkerArrivalModelDTO {
	
	private String cropyr;
	 
	private String centername;
	
	 private String datearrival;
	 
	 private String arrivedqty;
	 
	 private int grade_rate1;
	    
	  private int grade_rate2;
	    
	  private int grade_rate3;
	    
	   private int grade_rate4;
	    
	  private int grade_rate5;
	  
	  private String mixmois;
	  
	  private String maxmois;
	  
	  private double grade2;
	    
	  private double grade3;
	    
	  private double grade4;
	    
	  private double grade5;
	  
	  private String ro_name;
	  
	  private String jute_verity;
	  
	  private double g2total;
	    
	  private double g3total;
	    
	  private double g4total;
	    
	  private double g5total;
	  
	  private double qtytotal;
	  

	  
		public double getG2total() {
		return g2total;
	}

	public void setG2total(double g2total) {
		this.g2total = g2total;
	}

	public double getG3total() {
		return g3total;
	}

	public void setG3total(double g3total) {
		this.g3total = g3total;
	}

	public double getG4total() {
		return g4total;
	}

	public void setG4total(double g4total) {
		this.g4total = g4total;
	}

	public double getG5total() {
		return g5total;
	}

	public void setG5total(double g5total) {
		this.g5total = g5total;
	}

	public double getQtytotal() {
		return qtytotal;
	}

	public void setQtytotal(double qtytotal) {
		this.qtytotal = qtytotal;
	}

		public String getRo_name() {
		return ro_name;
	}

	public void setRo_name(String ro_name) {
		this.ro_name = ro_name;
	}

	public String getJute_verity() {
		return jute_verity;
	}

	public void setJute_verity(String jute_verity) {
		this.jute_verity = jute_verity;
	}

		public String getCropyr() {
			return cropyr;
		}

		public void setCropyr(String cropyr) {
			this.cropyr = cropyr;
		}

		public String getCentername() {
			return centername;
		}

		public void setCentername(String centername) {
			this.centername = centername;
		}

		public String getDatearrival() {
			return datearrival;
		}

		public void setDatearrival(String datearrival) {
			this.datearrival = datearrival;
		}

		public String getArrivedqty() {
			return arrivedqty;
		}

		public void setArrivedqty(String arrivedqty) {
			this.arrivedqty = arrivedqty;
		}

		public int getGrade_rate1() {
			return grade_rate1;
		}

		public void setGrade_rate1(int grade_rate1) {
			this.grade_rate1 = grade_rate1;
		}

		public int getGrade_rate2() {
			return grade_rate2;
		}

		public void setGrade_rate2(int grade_rate2) {
			this.grade_rate2 = grade_rate2;
		}

		public int getGrade_rate3() {
			return grade_rate3;
		}

		public void setGrade_rate3(int grade_rate3) {
			this.grade_rate3 = grade_rate3;
		}

		public int getGrade_rate4() {
			return grade_rate4;
		}

		public void setGrade_rate4(int grade_rate4) {
			this.grade_rate4 = grade_rate4;
		}

		public int getGrade_rate5() {
			return grade_rate5;
		}

		public void setGrade_rate5(int grade_rate5) {
			this.grade_rate5 = grade_rate5;
		}

		public String getMixmois() {
			return mixmois;
		}

		public void setMixmois(String mixmois) {
			this.mixmois = mixmois;
		}

		public String getMaxmois() {
			return maxmois;
		}

		public void setMaxmois(String maxmois) {
			this.maxmois = maxmois;
		}

		public double getGrade2() {
			return grade2;
		}

		public void setGrade2(double grade2) {
			this.grade2 = grade2;
		}

		public double getGrade3() {
			return grade3;
		}

		public void setGrade3(double grade3) {
			this.grade3 = grade3;
		}

		public double getGrade4() {
			return grade4;
		}

		public void setGrade4(double grade4) {
			this.grade4 = grade4;
		}

		public double getGrade5() {
			return grade5;
		}

		public void setGrade5(double grade5) {
			this.grade5 = grade5;
		}

		

		

		@Override
		public String toString() {
			return "MarkerArrivalModelDTO [cropyr=" + cropyr + ", centername=" + centername + ", datearrival="
					+ datearrival + ", arrivedqty=" + arrivedqty + ", grade_rate1=" + grade_rate1 + ", grade_rate2="
					+ grade_rate2 + ", grade_rate3=" + grade_rate3 + ", grade_rate4=" + grade_rate4 + ", grade_rate5="
					+ grade_rate5 + ", mixmois=" + mixmois + ", maxmois=" + maxmois + ", grade2=" + grade2 + ", grade3="
					+ grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", ro_name=" + ro_name + ", jute_verity="
					+ jute_verity + ", g2total=" + g2total + ", g3total=" + g3total + ", g4total=" + g4total
					+ ", g5total=" + g5total + ", qtytotal=" + qtytotal + "]";
		}

		

		public MarkerArrivalModelDTO(String cropyr, String centername, String datearrival, String arrivedqty,
				int grade_rate1, int grade_rate2, int grade_rate3, int grade_rate4, int grade_rate5, String mixmois,
				String maxmois, double grade2, double grade3, double grade4, double grade5, String ro_name,
				String jute_verity, double g2total, double g3total, double g4total, double g5total, double qtytotal) {
			super();
			this.cropyr = cropyr;
			this.centername = centername;
			this.datearrival = datearrival;
			this.arrivedqty = arrivedqty;
			this.grade_rate1 = grade_rate1;
			this.grade_rate2 = grade_rate2;
			this.grade_rate3 = grade_rate3;
			this.grade_rate4 = grade_rate4;
			this.grade_rate5 = grade_rate5;
			this.mixmois = mixmois;
			this.maxmois = maxmois;
			this.grade2 = grade2;
			this.grade3 = grade3;
			this.grade4 = grade4;
			this.grade5 = grade5;
			this.ro_name = ro_name;
			this.jute_verity = jute_verity;
			this.g2total = g2total;
			this.g3total = g3total;
			this.g4total = g4total;
			this.g5total = g5total;
			this.qtytotal = qtytotal;
		}

		public MarkerArrivalModelDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		
	    
	    

}
