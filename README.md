
# PROCESS -2

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
 
