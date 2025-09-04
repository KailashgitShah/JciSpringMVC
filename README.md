# JCI Phase-2 Project

This repository contains the implementation of **Phase-2 enhancements** for the **Jute Corporation of India (JCI) Management Information System**.

## 📖 Overview
The project is focused on extending and enhancing the existing MIS functionalities for **procurement, contract management, grading, and payment processing** under Phase-2.  

It addresses automation, data integrity, user experience improvements, and compliance with JCI’s operational workflows.

## 🚀 Key Features
- **Procurement Enhancements**
  - Bulk VS&WC (Village Service & Work Contract) data upload with PDF validations
  - Contract generation automation
  - Rank-based bid processing
- **Contract Management**
  - Multi-contract creation based on ranking
  - Authorization workflows (Mill, JCI Officials)
  - Tracking of contract acceptance/rejection
- **Payment & Finance**
  - Initial and final payment workflow
  - Dynamic payment type handling (online, offline)
  - Payment due-date tracking
- **Grading & Quality**
  - JCIGRADE composition management
  - Mill-wise grade allocation
  - Quality parameters with remarks
- **Reports & Dashboards**
  - Contract status report
  - Payment summary report
  - Crop year–wise analytics

## 🏗️ System Architecture
- **Backend**: Spring Boot (Java 17+)
- **Frontend**: JSP / JavaScript / jQuery
- **Database**: Azure SQL Database
- **Security**: JWT Authentication, Spring Security
- **Deployment**: Docker

## 📂 Repository Structure
├── backend/ # Spring Boot backend code
├── frontend/ # JSP/JavaScript UI
├── sql/ # Database scripts
├── docs/ # Project documentation (SRS, diagrams, guides)
├── scripts/ # Deployment scripts
└── README.md # Project documentation

## 🔐 Non-Functional Requirements
- **Performance**: Handle concurrent procurement transactions across multiple users.
- **Security**: Role-based access control, JWT-based authentication.
- **Reliability**: ≥99.9% uptime SLA.
- **Scalability**: Support multiple procurement centers and mills simultaneously.

- Contributors

Jute Corporation of India (JCI)

Development Partner: [Cyfuture]

Teams: Developers, Testers, DBA, Business Analysts
