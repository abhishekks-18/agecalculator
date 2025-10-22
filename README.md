# 🎂 Java Swing Age Calculator

A simple, clean, and modern-looking desktop application built with Java Swing that calculates a person's age in years, months, and days from their date of birth.

![Age Calculator Screenshot](httpsd://i.imgur.com/example.png)
*(**Note:** You should replace the image link above with a real screenshot of your application. Upload your screenshot to the GitHub repo and link to it.)*

---

## ✨ Features

* **User-Friendly Interface:** A clean and centered UI built with Swing.
* **Easy Date Selection:** Uses dropdown menus (JComboBox) for selecting the Day, Month, and Year.
* **Dynamic Year Population:** The 'Year' dropdown is automatically populated from the current year back to 1900.
* **Accurate Calculation:** Uses the modern `java.time` API (`LocalDate` and `Period`) for precise age calculation.
* **Error Handling:**
    * Provides a "future date" error if the selected date of birth is after today.
    * Handles invalid date combinations (e.g., February 30th) using Java's built-in date exception handling.
* **Styled Components:** Custom fonts, colors, and layouts for a polished look.

---

## 🛠️ Technology Used

* **Java:** Core programming language.
* **Java Swing:** The GUI widget toolkit for building the desktop interface.
* **Java Time API (`java.time`):** Used for all date and period calculations.

---

## 🚀 How to Run

To run this application, you must have the **Java Development Kit (JDK)** (version 8 or higher) installed on your system.

### Option 1: Using an IDE (Recommended)

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    ```
2.  **Open in your IDE:**
    * Open the cloned folder in your favorite Java IDE (like IntelliJ IDEA, Eclipse, or VS Code with the Java Extension Pack).
3.  **Run:**
    * Navigate to the `AgeCalculator.java` file.
    * Right-click and select "Run" or "Run 'AgeCalculator.main()'".

### Option 2: Using the Command Line

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    ```
2.  **Navigate to the source directory:**
    ```bash
    cd your-repository-name
    # (Navigate to where AgeCalculator.java is, e.g., src/ folder if you have one)
    ```
3.  **Compile the Java file:**
    ```bash
    javac AgeCalculator.java
    ```
4.  **Run the application:**
    ```bash
    java AgeCalculator
    ```

---

## 🕹️ How to Use

1.  Launch the application using one of the methods above.
2.  Select your **Day**, **Month**, and **Year** of birth from the dropdown menus.
3.  Click the **"Calculate Age"** button.
4.  Your exact age will be displayed at the bottom (e.g., "Your age is: 25 years, 4 months, 10 days").

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE.md).
