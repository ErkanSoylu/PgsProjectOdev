Specification Heading1
=====================

Checkin - OW - DOM - 1 ADT
--------------------------
tags:checkin_ow_dom_1adt

* Select book a flight
* Select one way
* Select from "islamabad" port
* Select to "karachi" port
* Select departure and return flight date
* Select economy
* Click book now button
* Wait "5" seconds
Select "oneway" flight
* Select until the flight finds an empty job android
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Ali" to "name" field
* close keyboard
* Write "Demir" to "surname" field
* close keyboard
* Select birhdate
* DOM> Write country: "Pakistan" and national id number: "12345698"
* Click continue button
* Write contact phone: "2132649623" and email: "safak.sahin@gmail.com"
* Click continue button

* Seat Selection Continue Button Android 2
* "passengerInfo" element is displayed
* Click continue button
 Payment
* swipe et
* Credit card; write name: "3d" and write card number Two
close keyboard          ---> Localde burası patlıyor ama testinium.io böyle çalışıyor.
* Wait "3" seconds
* Credit card; select expire date
* Credit card; write ccv number: "358" and payment address: "test address"
* swipe et
* swipe et
* Payment; write country: "Pakistan" , city: "Islamabad" and postal code: "34567"
* Wait "3" seconds
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "15" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done
* Wait "5" seconds
* Checkin process and surname: "Demir"
* Click element by "checkinContinueOKBtn"
* Wait "5" seconds
* "checkinPassengerItem" checkbox "1". person select
* Click element by "checkinContinueOKBtn"
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done


Checkin - RT - INT - 1 ADT, 1 CHD, 1 INF
----------------------------------------
tags:checkin_rt_int_1adt_1chd_1inf

* Select book a flight
* Select round trip
* Select from "islamabad" port
* Select to "kabul" port
* Select departure and return flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
Select "roundtrip" flight
* Select until the flight finds an empty job android
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Burak" to "name" field
* Write "Sevim" to "surname" field
* Select birhdate
* swipe et
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
 Child
* Wait "3" seconds
* swipe et Two
* Click element by "child"
* Write "Ahmet" to "name" field
* Write "Sevim" to "surname" field
* Select child or infant birhdate
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
 Infant
* Click element by "infant"
* Write "Ayse" to "name" field
* Write "Sevim" to "surname" field
* Select child or infant birhdate
* swipe et
* swipe et
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* Seat Selection Continue Button Android 4
* "passengerInfo" element is displayed
* Click continue button
 Payment
* Credit card; write name: "3d" and write card number Two
close keyboard          ---> Localde burası patlıyor ama testinium.io böyle çalışıyor.
* Wait "3" seconds
* Credit card; select expire date
* Credit card; write ccv number: "358" and payment address: "test address"
* swipe et
* swipe et
* Payment; write country: "Pakistan" , city: "Islamabad" and postal code: "34567"
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "20" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done
* Checkin process and surname: "Sevim"
* Click element by "multiPassengerCheckinContinueBtn1"
* Wait "5" seconds
* "checkinPassengerItem" checkbox "1". person select
* "checkinPassengerItem" checkbox "2". person select
* "checkinPassengerItem" checkbox "3". person select
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done
* Checkin process and surname: "Sevim"
* Click element by "multiPassengerCheckinContinueBtn2"
* Wait "5" seconds
* "checkinPassengerItem" checkbox "1". person select
* "checkinPassengerItem" checkbox "2". person select
* "checkinPassengerItem" checkbox "3". person select
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done

Checkin - OW - DOM_INT - 1 ADT
------------------------------
tags:checkin_ow_dom_int_1adt

* Select book a flight
* Select one way
* Select from "karachi" port
* Select to "kabul" port
* Select departure flight date
* Select economy
* Click book now button
Select "oneway" flight
* Select until the flight finds an empty job android
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Kaan" to "name" field
* Write "Meydan" to "surname" field
* Select birhdate
* INT> Write country : "Pakistan" , passport number: "945123761" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "kaan.meydan@gmail.com"
* Click continue button

* Seat Selection Continue Button Android 4
* "passengerInfo" element is displayed
* Click continue button
 Payment
* Credit card; write name: "3d" and write card number Two
close keyboard          ---> Localde burası patlıyor ama testinium.io böyle çalışıyor.
* Wait "3" seconds
* Credit card; select expire date
* Credit card; write ccv number: "358" and payment address: "test address"
* swipe et
* swipe et
* Payment; write country: "Pakistan" , city: "Islamabad" and postal code: "34567"
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "15" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done
* Wait "5" seconds
* Checkin process and surname: "Meydan"
* Click element by "checkinContinueOKBtn"
* Wait "5" seconds
* "checkinPassengerItem" checkbox "1". person select
* Write "123456789" to "passwordInformation" field
* Click element by "checkinContinueOKBtn"
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done

Checkin - RT - DOM_DOM - 1 ADT, 1 CHD, 1 INF
--------------------------------------------
tags:checkin_rt_dom_dom_1adt_1chd_1inf

* Select book a flight
* Select round trip
* Select from "karachi" port
* Select to "islamabad" port
* Select departure and return flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
Select "roundtrip" flight
* Select until the flight finds an empty job android
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Safak" to "name" field
* Write "Anıl" to "surname" field
* Select birhdate
* swipe et
* DOM> Write country: "Pakistan" and national id number: "123456789"
 Child
* Wait "3" seconds
* swipe et Two
* Click element by "child"
* Write "Nuri" to "name" field
* Write "Anıl" to "surname" field
* Select child or infant birhdate
* DOM> Write country: "Pakistan" and national id number: "432190872"
 Infant
* Click element by "infant"
* Write "Gamze" to "name" field
* Write "Anıl" to "surname" field
* Select child or infant birhdate
* DOM> Write country: "Pakistan" and national id number: "987654321"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* Seat Selection Continue Button Android 4
* "passengerInfo" element is displayed
* Click continue button
 Payment
* Credit card; write name: "3d" and write card number Two
close keyboard          ---> Localde burası patlıyor ama testinium.io böyle çalışıyor.
* Wait "3" seconds
* Credit card; select expire date
* Credit card; write ccv number: "358" and payment address: "test address"
* swipe et
* swipe et
* Payment; write country: "Pakistan" , city: "Islamabad" and postal code: "34567"
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "15" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done
* Checkin process and surname: "Anıl"
* Wait "5" seconds
* Click element by "multiPassengerCheckinContinueBtn1"
* "checkinPassengerItem" checkbox "1". person select
* Click element by "checkinContinueOKBtn"
* "checkinPassengerItem" checkbox "2". person select
* Click element by "checkinContinueOKBtn"
* "checkinPassengerItem" checkbox "3". person select
* Click element by "passwordNationality"
* Write "Pakistan" to "countrySearchTextInput" field
* Click element by "countrySelectItem"
* Write "123456789" to "passwordInformation" field
* Click element by "checkinContinueOKBtn"
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done
* Checkin process and surname: "Anıl"
* Wait "5" seconds
* Click element by "multiPassengerCheckinContinueBtn2"
* "checkinPassengerItem" checkbox "1". person select
* Click element by "checkinContinueOKBtn"
* "checkinPassengerItem" checkbox "2". person select
* Click element by "checkinContinueOKBtn"
* "checkinPassengerItem" checkbox "3". person select
* Click element by "passwordNationality"
* Write "Pakistan" to "countrySearchTextInput" field
* Click element by "countrySelectItem"
* Write "123456789" to "passwordInformation" field
* Click element by "checkinContinueOKBtn"
Click element by "passwordNationality"
Write "Turkey" to "countrySearchTextInput" field
Click element by "countrySelectItem"
Write "abcd" to "passwordInformation" field
Click element by "issueCountryApisForm"
Write "Pakistan" to "countrySearchTextInput" field
Click element by "countrySelectItem"
Click element by "okBtn"
* Click element by "acceptedCheckbox"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "bookingContinueBtn"
* PNR displayed and test scenario done