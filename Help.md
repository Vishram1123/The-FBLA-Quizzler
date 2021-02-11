# Help
## Troubleshooting file problems:
If you see the following error message:
![File error dialog box](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/File%20Chosen%20does%20not%20work.png?raw=true "File error dialog box")
* On Windows:
    1. Open Command Prompt or Powershell as administrator
    2. Answer the UAC (Do you want to allow this app to make changes to your device?) prompt
    3. `cd "C:\Path\To\The\FBLA\Quizzler"`
    4. `javaw.exe -jar "The FBLA Quizzler.jar"`
* On macOS:
    1. Open System Preferences
    2. Open Finder
    3. Go to /usr/bin in Finder
    4. Find `java` in Finder
    5. Go to Security & Privacy > Privacy > Full Disk Access in System Preferences
    6. Click on the Lock icon in System Preferences
    7. Type in your administrator password on the popup dialog
    8. Drag `java` from Finder into the bar on the right hand side of System Preferences
    9. Open Terminal
    10. `cd "/Path/To/The/FBLA/Quizzler"`
    11. `sudo java -jar "The FBLA Quizzler.jar"`
    12. Type in your administrator password
* On Linux:
    1. Open Terminal
    2. `cd "/Path/To/The/FBLA/Quizzler"`
    3. `sudo java -jar "The FBLA Quizzler.jar"`
    4. Type in your administrator password
  
