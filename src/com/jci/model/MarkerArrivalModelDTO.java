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
	  
	  private int mixmois;
	  
	  private int maxmois;
	  
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
	  
	  private String m_min;
	  private String m_max;
	  
	  private double TD1_min;
	  private double TD2_min;
	  private double TD3_min;
	  private double TD4_min;
	  private double TD5_min;
	  
	  private double TD5_max;
	  private double TD4_max;
	  private double TD3_max;
	  private double TD2_max;
	  private double TD1_max;
	  
	  

	public double getTD1_min() {
		return TD1_min;
	}

	public void setTD1_min(double tD1_min) {
		TD1_min = tD1_min;
	}

	public double getTD2_min() {
		return TD2_min;
	}

	public void setTD2_min(double tD2_min) {
		TD2_min = tD2_min;
	}

	public double getTD3_min() {
		return TD3_min;
	}

	public void setTD3_min(double tD3_min) {
		TD3_min = tD3_min;
	}

	public double getTD4_min() {
		return TD4_min;
	}

	public void setTD4_min(double tD4_min) {
		TD4_min = tD4_min;
	}

	public double getTD5_min() {
		return TD5_min;
	}

	public void setTD5_min(double tD5_min) {
		TD5_min = tD5_min;
	}

	public double getTD5_max() {
		return TD5_max;
	}

	public void setTD5_max(double tD5_max) {
		TD5_max = tD5_max;
	}

	public double getTD4_max() {
		return TD4_max;
	}

	public void setTD4_max(double tD4_max) {
		TD4_max = tD4_max;
	}

	public double getTD3_max() {
		return TD3_max;
	}

	public void setTD3_max(double tD3_max) {
		TD3_max = tD3_max;
	}

	public double getTD2_max() {
		return TD2_max;
	}

	public void setTD2_max(double tD2_max) {
		TD2_max = tD2_max;
	}

	public double getTD1_max() {
		return TD1_max;
	}

	public void setTD1_max(double tD1_max) {
		TD1_max = tD1_max;
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

		

	

		public int getMixmois() {
			return mixmois;
		}

		public void setMixmois(int mixmois) {
			this.mixmois = mixmois;
		}

		public int getMaxmois() {
			return maxmois;
		}

		public void setMaxmois(int maxmois) {
			this.maxmois = maxmois;
		}

		public String getM_min() {
			return m_min;
		}

		public void setM_min(String m_min) {
			this.m_min = m_min;
		}

		public String getM_max() {
			return m_max;
		}

		public void setM_max(String m_max) {
			this.m_max = m_max;
		}
		@Override
		public String toString() {
			return "MarkerArrivalModelDTO [cropyr=" + cropyr + ", centername=" + centername + ", datearrival="
					+ datearrival + ", arrivedqty=" + arrivedqty + ", grade_rate1=" + grade_rate1 + ", grade_rate2="
					+ grade_rate2 + ", grade_rate3=" + grade_rate3 + ", grade_rate4=" + grade_rate4 + ", grade_rate5="
					+ grade_rate5 + ", mixmois=" + mixmois + ", maxmois=" + maxmois + ", grade2=" + grade2 + ", grade3="
					+ grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", ro_name=" + ro_name + ", jute_verity="
					+ jute_verity + ", g2total=" + g2total + ", g3total=" + g3total + ", g4total=" + g4total
					+ ", g5total=" + g5total + ", qtytotal=" + qtytotal + ", m_min=" + m_min + ", m_max=" + m_max
					+ ", TD1_min=" + TD1_min + ", TD2_min=" + TD2_min + ", TD3_min=" + TD3_min + ", TD4_min=" + TD4_min
					+ ", TD5_min=" + TD5_min + ", TD5_max=" + TD5_max + ", TD4_max=" + TD4_max + ", TD3_max=" + TD3_max
					+ ", TD2_max=" + TD2_max + ", TD1_max=" + TD1_max + "]";
		}

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


		public MarkerArrivalModelDTO() {
			super();
			// TODO Auto-generated constructor stub
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

	

	

		
	    
	    

}
