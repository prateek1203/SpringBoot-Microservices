# SpringBoot-Microservices
Learning Microservices

  This project is create for learning microservices with SpringBoot framework.
  
  Here we have 3 services:-
  
    1) Movie-Catalog-Service
    2) Rating-Data-Service
    3) Movie-Info-Service
  There is also a service which acta as a service-discovery

  1) service-discovery-server
    
    Movie catalog service connects with rating service and movie-info service to get the movie and ratings infor for a particular userId.
    
    In order to run this setup, clone the repo to local run mvn cliean install -u for each services.
    
    in order to see if all the service(clients) are registered to the service discovery server or not hit http://localhost:8761
    
    you would see Eureka server dashboard with 3 registered service.
