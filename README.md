# Spring Boot Assignment – Source Code Setup



# PROCESS - 1

If you have Java and Maven installed, you can run it directly from the source code.

---

## 🔧 Prerequisites

Make sure the following are installed:

- **Java JDK 23 or above**
- **Maven**
- (Optional) **IntelliJ IDEA** or any other Java IDE

---

## 🚀 Installation & Setup Guide
INSTALLATION AND SETUP GUIDES :

**A. If you have Maven and Java JDK 23 or above already installed  (Follow process 1)

B . If you want to only run the application jar and verify the output (Follow process 2) **

1. **Clone the Repository**  
   Clone this repo or download it as a ZIP and extract it:
  
2. **Use Maven to resolve dependencies and build the project**
   ```mvn clean install```

3. **You can run the application with different Spring profiles depending on the task**
     TO RUN TASK 1 use: 
    ```mvn spring-boot:run```
   
     TO RUN TASK 2 use: 
     ``` mvn spring-boot:run -Dspring-boot.run.profiles=tasktwo```

# PROCESS - 2

### Spring Boot Assignment – JAR + Docker Setup

In this approach we can run it easily using Docker without needing to install Java or Maven. This method uses Docker to run the pre-built JAR file.

---

#### 🚀 Quick Start (No Java or Maven Required)
---

✅ Prerequisites

- Docker installed on your machine

---

📁 Files Required

- `Dockerfile`
- `Pothis-0.0.1-SNAPSHOT.jar` (pre-built JAR file)

You can download both from here:

🔗 [Download ZIP with JAR + Dockerfile] :
    ** https://drive.google.com/drive/folders/1AVFEe8iKd5lqPWtXwhbgkoGpwkvaJtOp?usp=sharing

---

🛠️ Steps to Run

1. **Extract the ZIP** (or place the `.jar` and `Dockerfile` in the same folder)

2. **Open terminal** in that folder and build the Docker image (This may take some time):
  
 ```  docker build -t spring-boot-pothi-sse-app .   ```

3. To run Task 1 (default profile) use :

  ``` docker run spring-boot-pothi-sse-app  ```

4. To run Task 2 use : 

  ``` docker run spring-boot-pothi-sse-app --spring.profiles.active=tasktwo  ```
 
