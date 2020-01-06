Specification Heading
=====================

Checkin - OW - DOM - 1 ADT
--------------------------
tags:checkin_ow_dom_1adt_ios

* Select book a flight ios
* elementinin "20" , "50" koordinatlarına tıkla
 Select one way --> tıklanır durumdan çıktı koordinatlarına tıklanıyor
* Select from "karachi" port
* Select to "islamabad" port
* Select departure click and flight
* Wait "10" seconds if iOS
* Select economy
* Click book now button
* Select until the flight finds an empty job
 --> uçuş seç burası random değil onun için * Select flight ios
* Click continue button
 Contact Information
* Select male
* Click title ıos
* Select mister title ios
* Write "Safak" to "name" field ios
* Write "Sahin" to "surname" field ios
* Select birhdate ios "dateOfBirth" day: "1" year: "1990"
* Select passenger 1 nationality country flag ios
* Passenger 1 national id number: "123456789" ios
 Select country: "Pakistan" and national id number: "123456789"
* Click passenger info multi continue button
* Write "2132649632" to "contactPhone" field ios
* Write "ak.sahin@gmail.com" to "contactEmail" field ios
* Click contact info multi continue button

* Seat Selection Continue Button 2
 "passengerInfo" element is displayed
* Click flight summary multi continue button
 Payment
* Payment CreditCard Element Click
* Write "3d" to "cardHolderName" field ios
* Write "4444333322221111" to "cardNumber" field ios
* Payment CreditCard Element Click
* Select credit card expire date ios
* Write "358" to "cardCCVNumber" field ios
* Write "test address" to "paymentAddress" field ios
* swipe et
 Select "Pakistan" as country ios
* Payment CreditCard Country Select ios
* Payment CreditCard Element Click
* swipe et
* Write "Islamabad" to "paymentCity" field ios
* Write "34567" to "paymentPostalCode" field ios

* "50","50" "acceptedCheckbox" Click
* Click buy ticket button

* Wait "15" seconds
* Click Submit button on 3DSecure page
* Wait "15" seconds
* Check if PNR No exists ios

* Online Check-in
* Wait "5" seconds
* Click element by "checkinContinueOKBtn"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Check if PNR No exists ios

Checkin - OW - DOM_INT - 1 ADT
------------------------------
tags:checkin_ow_dom_int_1adt_ios

* Select book a flight ios
* elementinin "20" , "50" koordinatlarına tıkla
 Select one way --> tıklanır durumdan çıktı koordinatlarına tıklanıyor
* Select from "karachi" port
* Select to "kabul" port
* Select departure click and flight
* Select economy
* Click book now button
* Select until the flight finds an empty job
 --> uçuş seç burası random değil onun için * Select flight ios
* Click continue button
 Contact Information
* Select male
* Click title ıos
* Select mister title ios
* Write "Safak" to "name" field ios
* Write "Sahin" to "surname" field ios
* Select birhdate ios "dateOfBirth" day: "1" year: "1990"
* Select passenger 1 nationality country flag ios
* Passenger 1 national id number: "123456789" ios
* Select passenger 1 nationality country flag ios
* swipe et
* Passenger 1 national id number: "123456789" ios
* INT> Country, national id number and issue country IOS
* Click passenger info multi continue button
* Write "2132649632" to "contactPhone" field ios
* Write "ak.sahin@gmail.com" to "contactEmail" field ios
* Click contact info multi continue button

* Seat Selection Continue Button 4
 "passengerInfo" element is displayed
* Click flight summary multi continue button
 Payment
* Payment CreditCard Element Click
* Write "3d" to "cardHolderName" field ios
* Write "4444333322221111" to "cardNumber" field ios
* Payment CreditCard Element Click
* Select credit card expire date ios
* Write "358" to "cardCCVNumber" field ios
* Write "test address" to "paymentAddress" field ios
* swipe et
 Select "Pakistan" as country ios
* Payment CreditCard Country Select ios
* Payment CreditCard Element Click
* swipe et
* Write "Islamabad" to "paymentCity" field ios
* Write "34567" to "paymentPostalCode" field ios

* "50","50" "acceptedCheckbox" Click
* Click buy ticket button

* Wait "20" seconds
* Click Submit button on 3DSecure page
* Wait "20" seconds
* Check if PNR No exists ios

* Online Check-in
* Wait "5" seconds
* Click element by "checkinContinueOKBtn"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"

* Online Check-in
* Click element by "checkinContinueOKBtn2"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Check if PNR No exists ios


Checkin - RT - INT - 1 ADT, 1 CHD, 1 INF
----------------------------------------
tags:checkin_rt_int_1adt_1chd_1inf_ios

* Select book a flight ios
* Select from "islamabad" port
* Select to "kabul" port
* Select departure and return flight
* Book a flight passenger count increased
* Select economy
* Click book now button
* Select until the multi flight finds an empty job
 --> uçuş seç burası random değil onun için * Select Multi flight ios
* Click multi continue button
 Contact Information
* Select male
* Click title ıos
* Select mister title ios

* Write "Safak" to "name" field ios
* Write "Sahin" to "surname" field ios
* Select birhdate ios "dateOfBirth" day: "1" year: "1990"
* Select passenger 1 nationality country flag ios
* Passenger 1 national id number: "123456789" ios
* Select passenger 1 nationality country flag ios
* swipe et
* Passenger 1 national id number: "123456789" ios
* INT> Country, national id number and issue country IOS

* Passenger information child 1 name: "Safakk" surname: "Sahinn"
* Select birhdate ios "passengerInformationChildOneDate" day: "1" year: "2008"
* Select child 1 nationality country flag ios
* Child 1 national id number: "123456789" ios
* Select child 1 nationality country flag ios
* swipe et
* Child 1 national id number: "123456789" ios
* INT> Country, national id number and issue country IOS

* Passenger information infant 1 name: "Safakkk" surname: "Sahinnn"
* Select birhdate ios "passengerInformationInfantOneDate" day: "1" year: "2018"
* Select infant 1 nationality country flag ios
* National id number: "123456789" ios
* Select infant 1 nationality country flag ios
* swipe et
* National id number: "123456789" ios
* INT> Country, national id number and issue country IOS
* Click passenger info multi continue button

* Write "2132649632" to "contactPhone" field ios
* Write "ak.sahin@gmail.com" to "contactEmail" field ios
* Click contact info multi continue button 2

* Seat Selection Continue Button 4
 "passengerInfo" element is displayed
* Click flight summary multi continue button
 Payment
* Payment CreditCard Element Click
* Write "3d" to "cardHolderName" field ios
* Write "4444333322221111" to "cardNumber" field ios
* Payment CreditCard Element Click
* Select credit card expire date ios
* Write "358" to "cardCCVNumber" field ios
* Write "test address" to "paymentAddress" field ios
* swipe et
 Select "Pakistan" as country ios
* Payment CreditCard Country Select ios
* Payment CreditCard Element Click
* swipe et
* Write "Islamabad" to "paymentCity" field ios
* Write "34567" to "paymentPostalCode" field ios

* "50","50" "acceptedCheckbox" Click
* Click buy ticket button

* Wait "15" seconds
* Click Submit button on 3DSecure page
* Wait "15" seconds
* Check if PNR No exists ios

* Online Check-in
* Wait "5" seconds
* Click element by "checkinContinueOKBtn"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"

* Online Check-in
* Click element by "checkinContinueOKBtn2"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Check if PNR No exists ios


Checkin - RT - DOM_DOM - 1 ADT, 1 CHD, 1 INF
--------------------------------------------
tags:checkin_rt_dom_dom_1adt_1chd_1inf_ios

* Select book a flight ios
* Select from "karachi" port
* Select to "islamabad" port
* Select departure and return flight
* Wait "2" seconds if iOS
* Book a flight passenger count increased
* Select economy
* Click book now button
* Select until the multi flight finds an empty job
 --> uçuş seç burası random değil onun için * Select Multi flight ios
* Click multi continue button
Contact Information
* Select male
* Click title ıos
* Select mister title ios
* Write "Safak" to "name" field ios
* Write "Sahin" to "surname" field ios
* Select birhdate ios "dateOfBirth" day: "1" year: "1990"
* swipe et
* Select passenger 1 nationality country flag ios
* Passenger 1 national id number: "123456789" ios

* Passenger information child 1 name: "Safakk" surname: "Sahinn"
* Select birhdate ios "passengerInformationChildOneDate" day: "1" year: "2008"
* Select child 1 nationality country flag ios
* Child 1 national id number: "123456789" ios

* Passenger information infant 1 name: "Safakkk" surname: "Sahinnn"
* Select birhdate ios "passengerInformationInfantOneDate" day: "1" year: "2018"
* Select infant 1 nationality country flag ios
* National id number: "123456789" ios
* Click passenger info multi continue button

* Write "2132649632" to "contactPhone" field ios
* Write "ak.sahin@gmail.com" to "contactEmail" field ios
* Click contact info multi continue button 2

* Seat Selection Continue Button 4
 "passengerInfo" element is displayed
* Click flight summary multi continue button
 Payment
* Payment CreditCard Element Click
* Write "3d" to "cardHolderName" field ios
* Write "4444333322221111" to "cardNumber" field ios
* Payment CreditCard Element Click
* Select credit card expire date ios
* Write "358" to "cardCCVNumber" field ios
* Write "test address" to "paymentAddress" field ios
* swipe et
 Select "Pakistan" as country ios
* Payment CreditCard Country Select ios
* Payment CreditCard Element Click
* swipe et
* Write "Islamabad" to "paymentCity" field ios
* Write "34567" to "paymentPostalCode" field ios

* "50","50" "acceptedCheckbox" Click
* Click buy ticket button

* Wait "15" seconds
* Click Submit button on 3DSecure page
* Wait "15" seconds
* Check if PNR No exists ios

* Online Check-in
* Wait "5" seconds
* Click element by "checkinContinueOKBtn"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "checkinContry"
* Click element by "parkistanSelectFlag"
* swipe et
* elementinin "50" , "50" koordinatlarına tıkla "checkinInformationId" "123456789"
* Click Done button to close keyboard
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"

* Online Check-in
* Click element by "checkinContinueOKBtn2"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "checkinContry"
* Click element by "parkistanSelectFlag"
* swipe et
* elementinin "50" , "50" koordinatlarına tıkla "checkinInformationId" "123456789"
* Click Done button to close keyboard
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Check if PNR No exists ios


Checkin - RT - DOM_DOM - 1 ADT, 1 CHD, 1 INF ---- TEST
--------------------------------------------
tags:checkin_rt_dom_dom_1adt_1chd_1inf_ios----TEST

* Wait "15" seconds
* Online Check-in TEST
* Wait "5" seconds
* Click element by "checkinContinueOKBtn"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Click element by "okBtn"
* Click element by "homePageBtn"


* Online Check-in TEST
* Click element by "checkinContinueOKBtn2"
* Click element by "PassengerOnlineCheckInCheckbox1"
* Click element by "PassengerOnlineCheckInCheckbox2"
* Click element by "PassengerOnlineCheckInCheckbox3"
* Click element by "PassengerOnlineCheckInCheckbox4"
* Click element by "onlineCheckinContinueBtn"
* Wait "4" seconds
* Click element by "okBtn"
* Click element by "seatSelectionBtn"
* Click element by "okBtn"
* Check if PNR No exists ios