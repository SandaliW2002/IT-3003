@echo off
echo Compiling Java files...
javac com\notepad\*.java

if %ERRORLEVEL% == 0 (
    echo.
    echo Compilation successful!
    echo Starting Notepad...
    echo.
    java com.notepad.Notepad
) else (
    echo.
    echo Compilation failed! Check for errors above.
)
pause