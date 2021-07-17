# cowin-vaccine-alert

This project uses Quarkus, the Supersonic Subatomic Java Framework, Angular and BootStrap technologies

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
Installation steps for Quarkus can be learned from Google or follow this link -- https://javabydeveloper.com/install-graalvm-on-windows-10-linux-mac/

## Running the quarkus application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/

Currently, following api's are integrated:
## Integrated with Frontend
/cowin/findByPin ---> to find vaccine slots by pincodes and next date from current date 
/cowin/pincodes ---> to get list of pincodes to list on pincodes page from H2 DB
/cowin/pincodes ---> to store preferred pincodes to store in H2 DB

## To Be Integrated with Frontend
/cowin/calendarByPin ---> to find vaccine slots planned sessions for next 7 days from current date in a given pincodes

## Running the angular application
> Goto to src/main/angular
> Run npm install
> Run npm install bootstrap --save
> Run npm install --save @ng-bootstrap/ng-bootstrap
> Run ng serve
angular app will launch at http://localhost:4200

