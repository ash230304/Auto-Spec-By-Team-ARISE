
# Custom Car Builder - Java Swing GUI Application

## 🛠️ Project Description
**Custom Car Builder** is a GUI-based Java application that allows users to customize their dream car by selecting:
- A car model
- Seat material
- Colors for seats, dashboard, and ambient lights
- Additional optional features like a premium sound system, custom steering wheel, and ambient lighting kit

Once selections are made, a detailed summary of the build is generated for the user.

---

## 🚀 Features
- Dropdown selection for car models and seat materials
- Color pickers for seat, dashboard, and ambient lighting
- Checkboxes for optional car features
- Button to generate a full build summary
- Scrollable output area to display the selected configuration
- Input validation and safe error handling

---

## 🖼️ GUI Components Used
- `JComboBox`
- `JCheckBox`
- `JButton`
- `JColorChooser`
- `JTextArea` with `JScrollPane`
- `JPanel` and `JLabel` for layout management

---

## 🧪 Requirements
- Java 8 or above
- No external libraries required

---

## ▶️ How to Run
1. Compile the Java file:
   ```bash
   javac CustomCarBuilder_Refactored.java
   ```
2. Run the compiled class:
   ```bash
   java CustomCarBuilder
   ```

---

## 📦 File Structure
```
CustomCarBuilder_Refactored.java   # Main Java source code file
README.md                          # This documentation
```

---

## 📌 Notes
- Default fallback colors are used if the user cancels color selection.
- All major GUI components and event listeners are modularized for better readability and maintainability.

---

## 📄 License
This project is released under the MIT License.
