# 🏨 Hotel Reservation System (CCP)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)

## 📜 Project Overview
This project is a **Complex Computing Problem (CCP)** focused on developing a scalable Hotel Reservation System. The core objective is to translate a detailed **UML Class Diagram** into high-quality Java code, ensuring that all architectural relationships (Aggregation, Composition, and Association) are accurately represented.



---

## 🚀 Key Features
- **UML-to-Code Fidelity:** Precise implementation of classes like `Hotel_Chain`, `Room`, `Reservation`, and `ReserverPayer`.
- **Defensive Programming:** Robust validation logic to prevent illegal states (e.g., negative costs, null objects).
- **Unit Testing:** 100% verification of domain logic using **JUnit 5** and the **AAA (Arrange-Act-Assert)** pattern.
- **Relationship Management:** Handles complex interactions between guest occupancy, room types, and chain-level reservations.

---

## 📂 Project Structure
```text
Hotel-Reservation-System/
├── src/
│   ├── CCP/                 # Root Package
│   │   ├── Main.java        # Entry Point
│   │   ├── Hotel_Chain.java # Controller Class
│   │   ├── Hotel.java
│   │   ├── Room.java
│   │   ├── RoomType.java
│   │   ├── Reservation.java
│   │   ├── ReserverPayer.java
│   │   └── How_Many.java    # Value Object
├── tests/                   # JUnit Test Suite
│   └── ... (Test classes for each domain object)
└── README.
```
---

## 🛠️ Installation & Setup

Follow these steps to set up the project on your local environment:

1.  **Clone the Repository** 📂
    ```bash
    git clone [https://github.com/hassanzzzj/Hotel-Reservation-System.git](https://github.com/hassanzzzj/Hotel-Reservation-System.git)
    ```
2.  **Import Project** 💻
    * Open **VS Code** or **IntelliJ IDEA**.
    * Select `File > Open Folder` and choose the cloned directory.
3.  **Configure SDK** ⚙️
    * Ensure **JDK 11 or higher** is installed.
    * In VS Code, set your `java.configuration.runtimes` to point to your JDK path.
4.  **Add Dependencies** 🧪
    * Add **JUnit 5.x** library to your Project Build Path to enable unit testing functionality.

---

## 🧪 Testing Methodology (AAA Pattern)

We follow the industry-standard **Arrange-Act-Assert** pattern to ensure each unit test is readable and maintainable.



| Phase | Description |
| :--- | :--- |
| **Arrange** 🏗️ | Initialize objects, mock dependencies, and prepare input data. |
| **Act** ⚡ | Execute the specific method or function being tested. |
| **Assert** ✅ | Verify that the actual output matches the expected result. |

---

## 📊 Documentation Guide (For Reports)

If you are using this project for a formal report, use the following descriptions for your screenshots to provide a professional context:

> [!TIP]
> **Main Execution:** Shows system initialization, hotel setup, and successful reservation flow.
> 
> **Domain Logic:** Demonstrates defensive checks (e.g., preventing negative room costs or invalid dates).
> 
> **Test Suite:** Displays green checkmarks for all unit tests, confirming 100% functional correctness.

---

## 🛡️ License

Distributed under the **MIT License**. See `LICENSE` for more information.

---

<p align="center">
  <b>Developed with ❤️ by <a href="https://github.com/hassanzzzj">Hassan</a></b>
</p>