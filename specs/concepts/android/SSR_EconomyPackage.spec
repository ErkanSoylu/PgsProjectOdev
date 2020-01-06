Specification Heading
=====================
Created by testinium on 6.01.2020

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Koşulmadı
RT , DOM+DOM , 1 ADT , Seat + XBAG - Ekonomi
--------------------
tags:rt_dom_dom_1adt_seat_xbag_economy

* Select book a flight
* Select round trip
* Select from "karachi" port
* Select to "gilgit" port
* Select departure and return flight date
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
* DOM> Write country: "Pakistan" and national id number: "123456789"
* Click continue button
* Write contact phone: "2132649632" and email: "burak.sevim@gmail.com"
* Click continue button

* RT - DOM_DOM - 1 ADT - Seat - Xbag
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
* Wait "3" seconds
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "15" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done

Koşulmadı
RT , INT , 1 ADT ,  Seat +  XBAG - Ekonomi
----------------
tags:rt_int_1adt_seat_xbag_ekonomy

* Select book a flight
* Select round trip
* Select from "islamabad" port
* Select to "kabul" port
* Select departure and return flight date
* Select economy
* Click book now button
Select "roundtrip" flight
* Select until the flight finds an empty job android 4
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Safak" to "name" field
* Write "Sahin" to "surname" field
* Select birhdate
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* 1 Ad - Seat Selection + Baggage Selection Continue Button Android 4
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


Silinebilir
OW - DOM_INT - 1 ADT, 1 CHD, 1 INF - Seat - Xbag - Ekonomi
----------------------------------
tags:ow_dom_int_1adt_1chd_1inf_seat_xbag_ekonomi

* Select book a flight
* Select one way
* Select from "karachi" port
* Select to "kabul" port
* Select departure flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
Select "oneway" flight
* Select until the flight finds an empty job android 4
* Click continue button
 Contact Information
* Select female
* Click title
* Select miss title
* Write "Ayşe" to "name" field
* Write "Uyumaz" to "surname" field
* Select birhdate
* swipe et
* INT> Write country : "Pakistan" , passport number: "641246976" and issue country: "Afghanistan"
 Child
* Wait "3" seconds
* swipe et Two
* Click element by "child"
* Write "Selim" to "name" field
* Write "Uyumaz" to "surname" field
* Select child or infant birhdate
* INT> Write country : "Pakistan" , passport number: "253086135" and issue country: "Afghanistan"
 Infant
* Click element by "infant"
* Write "Ahmet" to "name" field
* Write "Uyumaz" to "surname" field
* Select child or infant birhdate
* swipe et
* swipe et
* INT> Write country : "Pakistan" , passport number: "456123987" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* OW - 1 AD - 1 INF - SEAT - BAG Selection
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


Koşulmadı
RT , DOM  , 1 ADT - 1 CHD - 1 INF , 2 XBAG . + 2SEAT
----------------------------------
tags:rt_dom_int_1adt_1chd_1inf_2xbag_2xseat_ekonomi

* Select book a flight
* Select round trip
* Select from "islamabad" port
* Select to "kabul" port
* Select departure and return flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
Select "roundtrip" flight
* Select until the flight finds an empty job android 4
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Safak" to "name" field
* Write "Sahin" to "surname" field
* Select birhdate
* swipe et
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
 Child
* Wait "3" seconds
* swipe et Two
* Click element by "child"
* Write "Ahmet" to "name" field
* Write "Sahin" to "surname" field
* Select child or infant birhdate
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
 Infant
* Click element by "infant"
* Write "Ayse" to "name" field
* Write "Sahin" to "surname" field
* Select child or infant birhdate
* swipe et
* swipe et
* INT> Write country : "Pakistan" , passport number: "123456789" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* RT - 1 AD - 1 INF - 2xSEAT - 2xBAG Selection
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

OW - DOM_INT - 1 ADT, 1 CHD, 1 INF - Seat - Ekonomi
----------------------------------
tags:ow_dom_int_1adt_1chd_1inf_seat_economy

* Select book a flight
* Select one way
* Select from "karachi" port
* Select to "kabul" port
* Select departure flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
Select "oneway" flight
* Select until the flight finds an empty job android 4
* Click continue button
 Contact Information
* Select female
* Click title
* Select miss title
* Write "Ayşe" to "name" field
* Write "Uyumaz" to "surname" field
* Select birhdate
* swipe et
* INT> Write country : "Pakistan" , passport number: "641246976" and issue country: "Afghanistan"
 Child
* Wait "3" seconds
* swipe et Two
* Click element by "child"
* Write "Selim" to "name" field
* Write "Uyumaz" to "surname" field
* Select child or infant birhdate
* INT> Write country : "Pakistan" , passport number: "253086135" and issue country: "Afghanistan"
 Infant
* Click element by "infant"
* Write "Ahmet" to "name" field
* Write "Uyumaz" to "surname" field
* Select child or infant birhdate
* swipe et
* swipe et
* INT> Write country : "Pakistan" , passport number: "456123987" and issue country: "Afghanistan"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* RT - 1 AD - 1 INF - 2xSEAT
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

RT - DOM_DOM - 1 ADT, 1 CHD, 1 INF - 2 Seat - Ekonomi
----------------------------------
tags:rt_dom_dom_1adt_1chd_1inf_2seat_economy

* Select book a flight
* Select round trip
* Select from "karachi" port
* Select to "islamabad" port
* Select departure and return flight date
* Child and infant passenger count increased
* Select economy
* Click book now button
* Wait "15" seconds
swipe et
Select "roundtrip" flight
* Select until the flight finds an empty job android 4
* Click continue button
 Contact Information
* Select male
* Click title
* Select mister title
* Write "Burak" to "name" field
* Write "Sevim" to "surname" field
* Select birhdate
* swipe et
* DOM> Write country: "Pakistan" and national id number: "123456789"
 Child
* swipe et Two
* Wait "3" seconds
* Click element by "child"
* Write "Fatma" to "name" field
* Write "Sevim" to "surname" field
* Select child or infant birhdate
* DOM> Write country: "Pakistan" and national id number: "432190872"
 Infant
* Click element by "infant"
* Write "Mahmut" to "name" field
* Write "Sevim" to "surname" field
* Select child or infant birhdate
* DOM> Write country: "Pakistan" and national id number: "987654321"
* Click continue button
* Write contact phone: "2132649632" and email: "safak.sahin@gmail.com"
* Click continue button

* RT , DOM + DOM , 1 ADT _ 1 CHD _ 2 Seat
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
* Wait "3" seconds
* swipe et Two
* Rule accept checkbox clicked
* Buy ticket clicked
* Wait "15" seconds
* Submit clicked
* Wait "15" seconds
* PNR displayed and test scenario done