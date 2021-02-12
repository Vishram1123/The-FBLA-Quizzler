# Help
## Application not opening:
If you see the following error message:
![No Internet](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/No%20Internet.png?raw=true "No Internet")
1. Connect to the Internet
2. Reopen The FBLA Quizzler.jar

If you see this error message:
![No Permission](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/Mac-Cannot%20be%20opened.png?raw=true "No Permission")
* On Mac:
    1. Option 1:
        1. Open Finder
        2. Go to the folder that you downloaded The FBLA Quizzler to
        3. Right click on the FBLA Quizzler
        4. Click open
        5. Click open on the dialog box
    2. Option 2:
        1. Open Terminal
        2. `cd "/Path/To/The/FBLA/Quizzler"`
        3. `java -jar "The FBLA Quizzler.jar"`
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
    11. `java -jar "The FBLA Quizzler.jar"`
* On Linux:
    1. Open Terminal
    2. `cd "/Path/To/The/FBLA/Quizzler"`
    3. `java -jar "The FBLA Quizzler.jar"`
## Other general help:
### Choosing a text file with a custom name:
![Step 1: Click Different Question Set](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/Custom%20File%20Step%201.png?raw=true "Step 1: Click Different Question Set")
![Step 2: Choose Your File](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/Custom%20File%20Step%202.png?raw=true "Step 2: Choose Your File")
### Saving your results:
![Step 1: Click I would like to save my results](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/Save%20Results%20Step%201.png?raw=true "Step 1: Click I would like to save my results")
![Step 2: Choose the folder to save it in](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Resources%20(README.md%20and%20Help.md)/Save%20Results%20Step%202.png?raw=true "Step 2: Choose the folder to save it in")
* It will then give a message box with the location you saved the file, and after you dismiss that, it will open the file in your default browser. 
### Editing the question database:
1. Download Questions Template.txt from [here](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Questions%20Template.txt)
    * If you cannot find a Download button, click `Raw` and then copy the text into a text document on your computer
2. Once downloaded, rename the file to "Questions.txt" 
    * If you don't, look [here](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Help.md#choosing-a-text-file-with-a-custom-name) to choose a different text file. 
3. Do not delete lines, but delete contents on lines that do not have a "#" on them. 
    * Example:
    ```
    #
    # Multiple Choice Questions Answer Choice A:
    #
    Ferdinand
    Oklahoma
    TI-84
    ```
    * And so on. Delete `Ferdinand`, `Oklahoma`, and `TI-84`, not `#`, `# Multiple Choice Questions Answer Choice A:`, or `#`.
4. Once editing them, open up The FBLA Quizzler, and choose the directory containing your custom Questions.txt.
    * If your file is named something different, look [here](https://github.com/Vishram1123/The-FBLA-Quizzler/blob/main/Help.md#choosing-a-text-file-with-a-custom-name) to choose a different text file. 
