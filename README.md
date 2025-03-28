
---

## 🚀 goUPskill - E-Learning Management System  

### 📝 Description  
**goUPskill** is a **monolithic full-stack e-learning platform** built using **Angular and Spring Boot**. It enables **learners** to browse and enroll in courses, while **instructors** can create, manage, and track course enrollments. The system ensures smooth course management with a secure backend and an intuitive frontend.  

---

## 🛠️ Tech Stack  

### **Frontend (Angular)**  
- **Angular 16+** (Single Page Application - SPA)  
- **RxJS** (Reactive Programming)  
- **Angular Material** (UI Components)  
- **NgRx (if used)** (State Management)  
### **Backend (Spring Boot)**  
- **Spring Boot 3+** (RESTful API)  
- **Spring Security & JWT** (Authentication & Authorization)  
- **Spring Data JPA** (Database ORM)  
- **Hibernate** (Object-Relational Mapping)  
- **MySQL** (Relational Database)  
- **Lombok** (Boilerplate Reduction)    

---

## ✨ Features  

### 🔹 **Learner Features**  
✅ Browse and search for courses  
✅ Enroll in courses  
✅ View enrolled courses and progress  
✅ Access course details  
✅ Manage profile  

### 🔹 **Instructor Features**  
✅ Create new courses (title, description, price, duration)  
✅ Update or delete courses  
✅ View enrolled students  
✅ Manage profile  

---

## 📂 Project Structure  
```
/goUPskill
  ├── /backend (Spring Boot)
  │   ├── /src/main/java/com/goupskill
  │   │   ├── /controller
  │   │   ├── /service
  │   │   ├── /repository
  │   │   ├── /entity
  │   │   ├── Application.java
  │   ├── pom.xml
  ├── /frontend (Angular)
  │   ├── /src/app
  │   │   ├── /components
  │   │   ├── /services
  │   │   ├── /models
  │   │   ├── app.module.ts
  │   │   ├── main.ts
  │   ├── angular.json
  ├── README.md
```

---

## 🚀 Installation Guide  

### 1️⃣ Clone the Repository  
```sh
git clone https://github.com/yourusername/goUPskill.git
cd goUPskill
```

### 2️⃣ Backend Setup  
```sh
cd backend
mvn clean install
```
#### Configure Environment Variables  
Create a `.env` file in the **backend** directory and add:  
```
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/goupskill
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=yourpassword
JWT_SECRET=your-jwt-secret
```
#### Start the Backend Server  
```sh
mvn spring-boot:run
```

### 3️⃣ Frontend Setup  
```sh
cd frontend
npm install
npm start
```

---

## 🚀 Future Enhancements  
- **Payment Integration** (Stripe, Razorpay, etc.)  
- **Course Progress Tracking**  
- **Real-time Notifications**  
- **Quiz & Assessment Module**  
- **Chat System for Learners & Instructors**  

---

## 📜 License  
This project is **open-source** and available under the **MIT License**.  

---
