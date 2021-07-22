# cowin-vaccine-alert

This project uses Quarkus, the Supersonic Subatomic Java Framework, Liquibase, H2 DB, Angular and BootStrap technologies

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
Installation steps for Quarkus can be learned from Google or follow this link -- https://javabydeveloper.com/install-graalvm-on-windows-10-linux-mac/

## Architecture of the App:
![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Architecture.jpg?raw=true)

## Running the quarkus application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/

Currently, following api's are integrated:
## API Integrated with Frontend
/cowin/findByPin ---> to find vaccine slots by pincodes and next date from current date

/cowin/pincodes ---> to get list of pincodes to list on pincodes page from H2 DB

/cowin/pincodes ---> to store preferred pincodes to store in H2 DB

/cowin/pincodes/{id} ---> to delete pincodes from the list

/cowin/ages ---> POST to add prefered ages for filter criteria

/cowin/ages ---> GET to get all list prefered ages

/cowin/vaccines ---> POST to add prefered vaccines for filter criteria

/cowin/vaccines ---> GET to get all list prefered vaccines

/cowin/doses ---> GET to get all list prefered doses

/cowin/preferences ---> POST to store prefered filter criteria

## To Be Integrated with Frontend
/cowin/calendarByPin ---> to find vaccine slots planned sessions for next 7 days from current date in a given pincodes


## Running the angular application
> Goto to src/main/angular

> Run npm install

> Run npm install bootstrap --save

> Run npm install --save @ng-bootstrap/ng-bootstrap

> Run ng serve

angular app will launch at http://localhost:4200

## App Screens

1. Alert ![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Vaccine-Alert.jpg?raw=true)
2. Vaccine Listing ![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Vaccine-Listing.jpg)
3. Pincode Listing ![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Pincode-Listing.jpg)
4. Add Pincode ![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Pincode-Add.jpg)
5. Preferences ![Architecture](https://github.com/navinkumarboddu/cowin-vaccine-alert/blob/master/Preferences.jpg)




