# IT-3003
# Java Notepad Application

A simple, feature-rich notepad application built with Java Swing that provides essential text editing functionality with a clean, intuitive interface.

## Features

- **File Operations**
  - New file creation
  - Open existing text files
  - Save and Save As functionality
  - Smart file change detection with save prompts

- **Text Editing**
  - Cut, Copy, Paste operations
  - Select All functionality
  - Find text feature
  - Word wrap toggle

- **Formatting**
  - Font selection with preview
  - Bold and italic styling
  - Customizable font sizes

- **User Interface**
  - Clean, native system look and feel
  - Keyboard shortcuts for common operations
  - Status bar
  - Scroll support for large documents

## Requirements

- **Java Version**: Java 8 or later
- **Operating System**: Windows, macOS, or Linux with GUI support
- **Memory**: Minimal requirements (typically 50MB RAM)

## Setup Instructions

# 1. Clone the Repository

```bash
git clone <https://github.com/SandaliW2002/IT-3003/tree/main>
cd notepad-app
```

# 2. Compile the Application

Navigate to the project directory and compile the Java files:

```bash
# Create the package directory structure
mkdir -p com/notepad

# Move the Java files to the correct package location
mv Notepad.java com/notepad/
mv FontChooser.java com/notepad/

# Compile the application
javac com/notepad/*.java
```

# 3. Run the Application

```bash
java com.notepad.Notepad
```

Alternatively, you can create a simple batch file (Windows) or shell script (Linux/macOS):

**Windows (run.bat):**
```batch
@echo off
java com.notepad.Notepad
pause
```

**Linux/macOS (run.sh):**
```bash
#!/bin/bash
java com.notepad.Notepad
```

Make the script executable: `chmod +x run.sh`

## 📁 Project Structure

```
📁 notepad-app/
├── 🔧 compile.bat              # Windows compilation script
├── ⚙️ setup.bat               # Setup script for folder structure
├── 📖 README.md               # You are here!
└── 📁 com/
    └── 📁 notepad/
        ├── 📄 Notepad.java          # Main application class
        ├── 🎨 FontChooser.java      # Font selection utility
        ├── ⚡ Notepad.class         # Compiled main class
        └── 🔤 FontChooser.class     # Compiled font chooser
```

## 🏗️ Technical Architecture

### 🧩 Core Components

| Component | Description | Responsibility |
|-----------|-------------|----------------|
| **Notepad.java** | Main Application | GUI, Event Handling, File Operations |
| **FontChooser.java** | Font Selector | Font customization dialog |
| **compile.bat** | Build Script | Automated compilation and execution |

### 🔧 Technology Stack
- **Language**: Java 8+
- **GUI Framework**: Swing
- **File I/O**: BufferedReader/BufferedWriter
- **Architecture**: Event-Driven Programming
- **Design Pattern**: MVC (Model-View-Controller)

## 🎨 Screenshots

> **Note**: Add screenshots of your application here to showcase the UI!

```
[Main Interface]     [File Menu]      [About Dialog]
     📝                  📂               ℹ️
```

## 🧪 Testing

### ✅ Manual Testing Checklist
- [ ] Application launches successfully
- [ ] Create new document works
- [ ] File open/save operations work
- [ ] Text editing functions properly
- [ ] Keyboard shortcuts respond
- [ ] Menu items are functional
- [ ] Application closes gracefully

### 🐛 Known Issues
- Font selection uses simplified chooser
- Find functionality is basic (case-sensitive)
- No syntax highlighting support

## 🤝 Contributing

### 🌟 How to Contribute
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### 💡 Feature Ideas
- [ ] Syntax highlighting for code files
- [ ] Multiple document tabs
- [ ] Find and replace functionality
- [ ] Print support
- [ ] Recent files menu
- [ ] Auto-save feature
- [ ] Line numbers display
- [ ] Themes/Dark mode

## 📝 License

This project is created for **educational purposes**. Feel free to use, modify, and distribute for learning and academic projects.

## 🙏 Acknowledgments

- Built with using Java Swing
- Inspired by classic text editors
- Perfect for learning GUI development

---
