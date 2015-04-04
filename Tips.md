# Tips for Eclipse #

## How to debug on phone without plugging it in via USB? ##
  1. Turn on the phone
  1. Plug it in to USB
  1. `android-sdk-windows\platform-tools$ adb tcpip 5555`
  1. Disconnect the calbe
  1. `android-sdk-windows\platform-tools$ adb connect 192.168.1.85:5555`
  1. Eclipse: it should show up at Debug as...\Target\always ask

192.168.1.85 is your phone's Wifi IP address (it's available at Settings/Wifi/Advanced)

Common use cases:
  * After restarting the computer or going out (Phone disconnected from  Wifi)
    1. `GOTO 5`

  * After restarting the phone
    1. `GOTO 1`

  * To restore old USB behaviour
    1. Plug it in
    1. `android-sdk-windows\platform-tools$ adb usb`

## How to hide unrelevant messages when debugging in LogCat (i.e. GC)? ##
For the log filter enter the following for message:
`^(?!GC_|Grow).+`